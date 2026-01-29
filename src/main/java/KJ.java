import  java.util.Scanner;

public class KJ {
    public static final String Line ="————————————————————————————————————————————————————————————————————";
    private static final Task[] tasks = new Task[100];
    private static int count = 0;

    public static void greeting() {
        System.out.println(Line);
        System.out.println("Hello! I'm KJ");
        System.out.println("What can I do for you? \n");
        System.out.println(Line);
    }

    public static void readInput() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String input = scanner.nextLine();
            if(input.equals("bye")) {
                byeMessage();
                break;
            } else if (input.equals("list")) {
                listMessage();
            } else if (input.startsWith("mark")) {
                markTask(input);
            } else if (input.startsWith("unmark")) {
                unmarkTask(input);
            } else {
                handleAdd(input);
            }
        }
    }

    public static void byeMessage() {
        System.out.println(Line);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(Line);
    }

    public static void handleAdd(String input) {
        if(input.startsWith("todo")) {
            String description = input.substring(5);
            tasks[count] = new ToDo(description);
        } else if (input.startsWith("event")) {
            String[] description = input.substring(6).split(" /from | /to ");
            tasks[count] = new Event(description[0], description[1], description[2]);
        } else if (input.startsWith("deadline")) {
            String[] description = input.substring(9).split(" /by ");
            tasks[count] = new Deadline(description[0], description[1]);
        }
        System.out.println(Line);
        System.out.println("Got it. I've added this task:");
        System.out.println(" " + tasks[count]);
        count++;
        System.out.println("Now you have " + count + " tasks in the list.");
        System.out.println(Line);
    }

    public static void listMessage() {
        System.out.println(Line);
        for(int i = 0; i<count; i++) {
            System.out.println(i+1 + "." + tasks[i]);
        }
        System.out.println(Line);
    }

    public static void markTask(String input) {
        System.out.println(Line);
        int taskNum = Integer.parseInt(input.split(" ")[1]) - 1;
        tasks[taskNum].markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(tasks[taskNum]);
        System.out.println(Line);
    }

    public static void unmarkTask(String input) {
        System.out.println(Line);
        int taskNum = Integer.parseInt(input.split(" ")[1]) - 1;
        tasks[taskNum].markAsUndone();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(tasks[taskNum]);
        System.out.println(Line);
    }

    public static void main(String[] args) {
        greeting();
        readInput();
    }
}
