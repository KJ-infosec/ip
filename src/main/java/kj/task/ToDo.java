package kj.task;

/**
 * Represents a basic task without any specific date or time attached to it.
 * A ToDo object corresponds to a task that only has a description
 * and a completion status.
 */
public class ToDo extends Task {

    /**
     * Constructs a ToDo task with the given description.
     * @param description The description of the task.
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Returns a string representation of the todo task formatted for file storage.
     * The format used is: T | isDone | description.
     * @return A formatted string suitable for saving to a text file.
     */
    @Override
    public String toFileString() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }

    /**
     * Returns a string representation of the todo task for display to the user.
     * Includes the task type identifier [T], the status icon, and the description.
     * @return A user-friendly string representation of the todo task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
