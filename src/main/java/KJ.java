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
        tasks[count] = new Task(input);
        count++;
        System.out.println(Line);
        System.out.println(" added: " + input);
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
