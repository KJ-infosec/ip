package KJ.task;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void add(Task task) {
        this.tasks.add(task);
    }

    public Task remove(int taskNum) {
        return this.tasks.remove(taskNum);
    }

    public int size() {
        return tasks.size();
    }

    public Task get(int taskNum) {
        return tasks.get(taskNum);
    }

    public Task getLast() {
        return tasks.getLast();
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }
}