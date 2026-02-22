package kj.task;

import java.time.LocalDateTime;
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

    private LocalDateTime getTaskDate(Task t) {
        if (t instanceof Deadline) {
            return ((Deadline) t).getTaskDate();
        }
        if (t instanceof Event) {
            return ((Event) t).getTaskDate();
        }
        return null;
    }

    /**
     * Sort tasklist by its date
     */
    public void sortByDate() {
        tasks.sort((t1, t2) -> {
            // Deadlines and Events have dates; ToDos do not.
            // We can push ToDos to the bottom.
            LocalDateTime d1 = getTaskDate(t1);
            LocalDateTime d2 = getTaskDate(t2);

            if (d1 == null) {
                return 1;
            }
            if (d2 == null) {
                return -1;
            }
            return d1.compareTo(d2);
        });
    }

    /**
     *  Sorts the ArrayList in-place alphabetically by description
     */
    public void sortByName() {
        tasks.sort((t1, t2) -> t1.getDescription().compareToIgnoreCase(t2.getDescription()));
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
