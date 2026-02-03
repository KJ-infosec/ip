package KJ;

import java.util.Scanner;
import KJ.task.Task;
import KJ.task.TaskList;

public class Ui {
    private Scanner scanner;
    public static final String LINE ="--------------------------------------------------------------";

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the welcome message to the user.
     */
    public void showWelcome() {
        System.out.println(LINE);
        System.out.println("Hello! I'm KJ");
        System.out.println("What can I do for you? \n");
        System.out.println(LINE);
    }

    /**
     * Displays the farewell message when the application terminates.
     */
    public void showBye() {
        System.out.println(LINE);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    /**
     * Reads the next line of input from the user.
     * * @return The full string entered by the user.
     */
    public String readCommand() {
        return this.scanner.nextLine();
    }

    /**
     * Displays a message confirming that a task has been added.
     * * @param task The task that was added.
     * @param taskSize The current total number of tasks in the list.
     */
    public void showAddedMessage(Task task, int taskSize) {
        System.out.println(LINE);
        System.out.println("Got it. I've added this task:");
        System.out.println(" " + task);
        System.out.println("Now you have " + taskSize + " tasks in the list.");
        System.out.println(LINE);
    }

    /**
     * Lists all the tasks currently present in the task list.
     * * @param tasks The TaskList object containing the tasks.
     * @param taskSize The number of tasks to display.
     */
    public void showListMessage(TaskList tasks, int taskSize) {
        System.out.println(LINE);
        for(int i = 0; i< tasks.size(); i++) {
            System.out.println(i+1 + "." + tasks.get(i));
        }
        System.out.println(LINE);
    }

    /**
     * Confirms that a task has been successfully marked as done.
     * * @param task The task that was marked.
     */
    public void showMarkedMessage(Task task) {
        System.out.println(LINE);
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task);
        System.out.println(LINE);
    }

    /**
     * Confirms that a task has been marked as not done.
     * * @param task The task that was unmarked.
     */
    public void showUnmarkedMessage(Task task) {
        System.out.println(LINE);
        System.out.println("Nice! I've unmarked this task as not done yet:");
        System.out.println(task);
        System.out.println(LINE);
    }

    /**
     * Confirms that a task has been removed from the task list.
     * * @param tasks The current task list (to show the updated size).
     * @param removedTask The task that was deleted.
     */
    public void showDeletedMessage(TaskList tasks, Task removedTask) {
        System.out.println(LINE);
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + removedTask);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(LINE);
    }

    /**
     * Displays an error message to the user.
     * * @param message The error message to be displayed.
     */
    public void showErrorMessage(String message) {
        System.out.println(LINE);
        System.out.println(" " + message);
        System.out.println(LINE);
    }

    /**
     * Displays an error message indicating that the data file could not be loaded.
     */
    public void showLoadingError() {
        System.out.println(LINE);
        System.out.println("Warning: No existing data found." );
        System.out.println(LINE);
    }
}