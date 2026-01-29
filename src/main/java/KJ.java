import  java.util.Scanner;

public class KJ {
    public static final String Line ="--------------------------------------------------------------";
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
            try {
                if (input.equals("bye")) {
                    byeMessage();
                    break;
                } else if (input.equals("list")) {
                    listMessage();
                } else if (input.startsWith("mark")) {
                    markTask(input);
                } else if (input.startsWith("unmark")) {
                    unmarkTask(input);
                } else if (input.startsWith("todo")
                        || input.startsWith("deadline")
                        || input.startsWith("event")) {
                    handleAdd(input);
                } else {
                    throw new KJException("Sorry, I don't understand that command.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void byeMessage() {
        System.out.println(Line);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(Line);
    }

    public static void handleAdd(String input) {
        try {
            if (input.startsWith("todo")) {
                if (input.equals("todo")) {
                    throw new KJException("The description of a todo cannot be empty.");
                }
                String description = input.substring(5);
                tasks[count] = new ToDo(description);
            } else if (input.startsWith("event")) {
                if (!input.contains("/from") || !input.contains("/to")) {
                    throw new KJException("Event must have /from and /to");
                }
                String[] description = input.substring(6).split(" /from | /to ");
                tasks[count] = new Event(description[0], description[1], description[2]);
            } else if (input.startsWith("deadline")) {
                if (!input.contains("/by")) {
                    throw new KJException("Deadline must have /by.");
                }
                String[] description = input.substring(9).split(" /by ");
                tasks[count] = new Deadline(description[0], description[1]);
            }
            System.out.println(Line);
            System.out.println("Got it. I've added this task:");
            System.out.println(" " + tasks[count]);
            count++;
            System.out.println("Now you have " + count + " tasks in the list.");
            System.out.println(Line);
        } catch (Exception e) {
            System.out.println(Line);
            System.out.println(e.getMessage());
            System.out.println(Line);
        }
    }

    public static void listMessage() {
        System.out.println(Line);
        for(int i = 0; i<count; i++) {
            System.out.println(i+1 + "." + tasks[i]);
        }
        System.out.println(Line);
    }

    public static void markTask(String input) {
        try {
            System.out.println(Line);
            int taskNum = Integer.parseInt(input.split(" ")[1]) - 1;
            if (taskNum < 0 || taskNum >= count) {
                throw new IndexOutOfBoundsException();
            }
            tasks[taskNum].markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(tasks[taskNum]);
            System.out.println(Line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Please provide a valid task number.");
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("That task number does not exist.");
        }
    }

    public static void unmarkTask(String input) {
        try {
            System.out.println(Line);
            int taskNum = Integer.parseInt(input.split(" ")[1]) - 1;
            if (taskNum < 0 || taskNum >= count) {
                throw new IndexOutOfBoundsException();
            }
            tasks[taskNum].markAsUndone();
            System.out.println("Nice! I've unmarked this task as done:");
            System.out.println(tasks[taskNum]);
            System.out.println(Line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Please provide a valid task number.");
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("That task number does not exist.");
        }
    }

    public static void main() {
        greeting();
        readInput();
    }
}
