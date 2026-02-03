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

    public static void showWelcome() {
        System.out.println(LINE);
        System.out.println("Hello! I'm KJ");
        System.out.println("What can I do for you? \n");
        System.out.println(LINE);
    }

    public static void showBye() {
        System.out.println(LINE);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    public String readCommand() {
        return this.scanner.nextLine();
    }

    public void showAddedMessage(Task task, int taskSize) {
        System.out.println(LINE);
        System.out.println("Got it. I've added this task:");
        System.out.println(" " + task);
        System.out.println("Now you have " + taskSize + " tasks in the list.");
        System.out.println(LINE);
    }

    public void showListMessage(TaskList tasks, int taskSize) {
        System.out.println(LINE);
        for(int i = 0; i< tasks.size(); i++) {
            System.out.println(i+1 + "." + tasks.get(i));
        }
        System.out.println(LINE);
    }

    public void showMarkedMessage(Task task) {
        System.out.println(LINE);
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task);
        System.out.println(LINE);
    }

    public void showUnmarkedMessage(Task task) {
        System.out.println(LINE);
        System.out.println("Nice! I've unmarked this task as not done yet:");
        System.out.println(task);
        System.out.println(LINE);
    }

    public void showDeletedMessage(TaskList tasks, Task removedTask) {
        System.out.println(LINE);
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + removedTask);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(LINE);
    }

    public void showErrorMessage(String message) {
        System.out.println(LINE);
        System.out.println(" " + message);
        System.out.println(LINE);
    }

    public void showLoadingError() {
        System.out.println(LINE);
        System.out.println("Warning: No existing data found." );
        System.out.println(LINE);
    }
}