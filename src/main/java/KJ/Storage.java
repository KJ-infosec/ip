package KJ;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import KJ.task.Deadline;
import KJ.task.Event;
import KJ.task.Task;
import KJ.task.TaskList;
import KJ.task.ToDo;

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public TaskList load() throws KJException {
        TaskList tasks = new TaskList();
        File file = new File(filePath);

        try {
            if(!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if(!file.exists()) {
                file.createNewFile();
                return tasks;
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                tasks.add(parseTask(line));
            }

            br.close();
        } catch (IOException e) {
            throw new KJException("Error loading data from file");
        }
        return tasks;
    }

    private Task parseTask(String line) throws KJException {
        try{
            String[] parts = line.split(" \\| ");
            String type = parts[0];
            boolean isDone = parts[1].equals("1");

            Task task;
            switch (type) {
                case "T":
                    task = new ToDo(parts[2]);
                    break;
                case "D":
                    task = new Deadline(parts[2], parts[3]);
                    break;
                case "E":
                    task = new Event(parts[2], parts[3], parts[4]);
                    break;
                default:
                    throw new KJException("Corrupted data found.");
            }

            if(isDone) {
                task.markAsDone();
            }
            return task;
        } catch (Exception e) {
            throw new KJException("Corrupted data file");
        }
    }

    public void save(TaskList tasks) throws KJException {
        try {
            FileWriter fw = new FileWriter(filePath);

            for (Task task : tasks.getTasks()) {
                fw.write(task.toFileString() + System.lineSeparator());
            }

            fw.close();
        } catch (IOException e) {
            throw new KJException("Error saving data.");
        }
    }
}