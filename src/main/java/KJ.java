import java.util.Scanner;
import java.util.ArrayList;

public class KJ {
    public static final String Line ="--------------------------------------------------------------";
    private static final ArrayList<Task> tasks = new ArrayList<>();
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
                } else if (input.startsWith("delete")) {
                    deleteTask(input);
                } else {
                    throw new KJException("Sorry, I don't understand that command.");
                }
            } catch (Exception e) {
                System.out.println(Line);
                System.out.println(e.getMessage());
                System.out.println(Line);
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
                tasks.add(new ToDo(description));
            } else if (input.startsWith("event")) {
                if (!input.contains("/from") || !input.contains("/to")) {
                    throw new KJException("Event must have /from and /to");
                }
                String[] description = input.substring(6).split(" /from | /to ");
                tasks.add(new Event(description[0], description[1], description[2]));
            } else if (input.startsWith("deadline")) {
                if (!input.contains("/by")) {
                    throw new KJException("Deadline must have /by.");
                }
                String[] description = input.substring(9).split(" /by ");
                tasks.add(new Deadline(description[0], description[1]));
            }
            System.out.println(Line);
            System.out.println("Got it. I've added this task:");
            System.out.println(" " + tasks.getLast());
            count++;
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
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
            System.out.println(i+1 + "." + tasks.get(i));
        }
        System.out.println(Line);
    }

    public static void markTask(String input) {
        try {
            int taskNum = Integer.parseInt(input.split(" ")[1]) - 1;
            if (taskNum < 0 || taskNum >= count) {
                throw new KJException("That task number does not exist.");
            }
            System.out.println(Line);
            tasks.get(taskNum).markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(tasks.get(taskNum));
            System.out.println(Line);
        } catch (Exception e) {
            System.out.println(Line);
            System.out.println(e.getMessage());
            System.out.println(Line);
        }
    }

    public static void unmarkTask(String input) {
        try {
            int taskNum = Integer.parseInt(input.split(" ")[1]) - 1;
            if (taskNum < 0 || taskNum >= count) {
                throw new KJException("That task number does not exist.");
            }
            System.out.println(Line);
            tasks.get(taskNum).markAsUndone();
            System.out.println("Nice! I've unmarked this task as done:");
            System.out.println(tasks.get(taskNum));
            System.out.println(Line);
        } catch (Exception e) {
            System.out.println(Line);
            System.out.println(e.getMessage());
            System.out.println(Line);
        }
    }

    public static void deleteTask(String input) {
        try {
            int taskNum = Integer.parseInt(input.split(" ")[1]) - 1;

            if (taskNum < 0 || taskNum >= tasks.size()) {
                throw new KJException("That task number does not exist.");
            }

            Task removedTask = tasks.remove(taskNum);

            System.out.println(Line);
            System.out.println("Noted. I've removed this task:");
            System.out.println("  " + removedTask);
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
            System.out.println(Line);
        } catch (Exception e) {
            System.out.println(Line);
            System.out.println(e.getMessage());
            System.out.println(Line);
        }
    }

    public static void main() {
        greeting();
        readInput();
    }
}
