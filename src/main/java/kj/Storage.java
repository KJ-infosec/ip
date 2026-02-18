package kj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import kj.task.Deadline;
import kj.task.Event;
import kj.task.Task;
import kj.task.TaskList;
import kj.task.ToDo;

/**
 * Handles loading tasks from the file and saving tasks in the file.
 */
public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads the task list from the file specified in the constructor.
     * @throws KjException If there is an issue reading the file or the data format is invalid.
     */
    public TaskList load() throws KjException {
        TaskList tasks = new TaskList();
        File file = new File(filePath);

        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
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
            throw new KjException("Error loading data from file");
        }
        return tasks;
    }

    /**
     * Decodes a single line of text from the data file into a Task object.
     * @param line The raw string line from the data file.
     * @throws KjException If the data format is unrecognized or corrupted.
     */
    private Task parseTask(String line) throws KjException {
        try {
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
                throw new KjException("Corrupted data found.");
            }

            if (isDone) {
                task.markAsDone();
            }
            return task;
        } catch (Exception e) {
            throw new KjException("Corrupted data file");
        }
    }

    /**
     * Saves the current task list to the data file.
     * @throws KjException If there is an I/O error during the saving process.
     */
    public void save(TaskList tasks) throws KjException {
        try {
            FileWriter fw = new FileWriter(filePath);

            for (Task task : tasks.getTasks()) {
                fw.write(task.toFileString() + System.lineSeparator());
            }

            fw.close();
        } catch (IOException e) {
            throw new KjException("Error saving data.");
        }
    }
}
