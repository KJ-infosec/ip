package kj;

import java.util.Scanner;

import kj.task.Task;
import kj.task.TaskList;

/**
 * Handles the user interface of the application.
 */
public class Ui {
    public static final String LINE = "--------------------------------------------------------";
    private StringBuilder buffer = new StringBuilder();
    private Scanner scanner;
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    private void appendToBuffer(String message) {
        buffer.append(message).append("\n");
        System.out.println(message);
    }

    /**
     * Returns the accumulated output and clears the buffer.
     */
    public String printBuffer() {
        String output = buffer.toString().trim();
        buffer.setLength(0); // Clears the buffer for the next command
        return output;
    }

    /**
     * Displays the welcome message to the user.
     */
    public void showWelcome() {
        appendToBuffer(LINE);
        appendToBuffer("Hello! I'm KJ");
        appendToBuffer("What can I do for you? \n");
        appendToBuffer(LINE);
    }

    /**
     * Displays the farewell message when the application terminates.
     */
    public void showBye() {
        appendToBuffer(LINE);
        appendToBuffer("Bye. Hope to see you again soon!");
        appendToBuffer(LINE);
    }

    /**
     * Reads the next line of input from the user.
     * @return The full string entered by the user.
     */
    public String readCommand() {
        return this.scanner.nextLine();
    }

    /**
     * Displays a message confirming that a task has been added.
     * @param task The task that was added.
     * @param taskSize The current total number of tasks in the list.
     */
    public void showAddedMessage(Task task, int taskSize) {
        appendToBuffer(LINE);
        appendToBuffer("Got it. I've added this task:");
        appendToBuffer(" " + task);
        appendToBuffer("Now you have " + taskSize + " tasks in the list.");
        appendToBuffer(LINE);
    }

    /**
     * Lists all the tasks currently present in the task list.
     * @param tasks The TaskList object containing the tasks.
     * @param taskSize The number of tasks to display.
     */
    public void showListMessage(TaskList tasks, int taskSize) {
        appendToBuffer(LINE);
        for (int i = 0; i < tasks.size(); i++) {
            appendToBuffer(i + 1 + "." + tasks.get(i));
        }
        appendToBuffer(LINE);
    }

    /**
     * Confirms that a task has been successfully marked as done.
     * @param task The task that was marked.
     */
    public void showMarkedMessage(Task task) {
        appendToBuffer(LINE);
        appendToBuffer("Nice! I've marked this task as done:");
        appendToBuffer(task.toString());
        appendToBuffer(LINE);
    }

    /**
     * Confirms that a task has been marked as not done.
     * @param task The task that was unmarked.
     */
    public void showUnmarkedMessage(Task task) {
        appendToBuffer(LINE);
        appendToBuffer("Nice! I've unmarked this task as not done yet:");
        appendToBuffer(task.toString());
        appendToBuffer(LINE);
    }

    /**
     * Confirms that a task has been removed from the task list.
     * @param tasks The current task list (to show the updated size).
     * @param removedTask The task that was deleted.
     */
    public void showDeletedMessage(TaskList tasks, Task removedTask) {
        appendToBuffer(LINE);
        appendToBuffer("Noted. I've removed this task:");
        appendToBuffer("  " + removedTask);
        appendToBuffer("Now you have " + tasks.size() + " tasks in the list.");
        appendToBuffer(LINE);
    }

    /**
     * Displays an error message to the user.
     * @param message The error message to be displayed.
     */
    public void showErrorMessage(String message) {
        appendToBuffer(LINE);
        appendToBuffer(" " + message);
        appendToBuffer(LINE);
    }

    /**
     * Displays an error message indicating that the data file could not be loaded.
     */
    public void showLoadingError() {
        appendToBuffer(LINE);
        appendToBuffer("Warning: No existing data found.");
        appendToBuffer(LINE);
    }

    /**
     * Displays the list of tasks that match the search keyword.
     * @param matchingTasks The filtered list of tasks.
     */
    public void showMatchingTasks(TaskList matchingTasks) {
        appendToBuffer(LINE);
        if (matchingTasks.isEmpty()) {
            appendToBuffer(" No matching tasks found in your list.");
        } else {
            appendToBuffer(" Here are the matching tasks in your list:");
            for (int i = 0; i < matchingTasks.size(); i++) {
                appendToBuffer(" " + (i + 1) + "." + matchingTasks.get(i));
            }
        }
        appendToBuffer(LINE);
    }
}
