package KJ.task;

import java.util.ArrayList;

/**
 * Manages a list of tasks.
 * Provides methods to add, remove, and retrieve tasks from the collection.
 */
public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * @param task The task to be added to the list.
     */
    public void add(Task task) {
        this.tasks.add(task);
    }

    /**
     * @param taskNum The 0-based index of the task to remove.
     * @return The task that was removed.
     */
    public Task remove(int taskNum) {
        return this.tasks.remove(taskNum);
    }

    /**
     * @return The total number of tasks in the list.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * @param taskNum The index of the task.
     * @return The task at the specified index.
     */
    public Task get(int taskNum) {
        return tasks.get(taskNum);
    }


    /**
     * @return The raw ArrayList containing all tasks.
     */
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }
}