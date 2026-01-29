import java.util.Scanner;

public class KJ {
    private static String[] tasks = new String[100];
    private static int count = 0;
    private static final String LINE = "————————————————————————————————————————————————————————";

    private static void greeting(){
     System.out.println(LINE);
     System.out.println(" Hello! I'm KJ");
     System.out.println(" What can I do for you?");
     System.out.println(LINE);
    }

    private static void readInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if(input.equals("bye")) {
                byeMessage();
                break;
            } else if (input.equals("list")) {
                listMessage();
            } else {
                handleAdd(input);
            }
        }
    }

    public static void byeMessage() {
        System.out.println(LINE);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    public static void listMessage() {
        System.out.println(LINE);
        for(int i = 0; i < count ; i++) {
            System.out.println(" " + (i + 1) + ". " + tasks[i]);
        }
        System.out.println(LINE);
    }

    public static void handleAdd(String input) {
        tasks[count] = input;
        count++;
        System.out.println(LINE);
        System.out.println("added: " + input);
        System.out.println(LINE);
    }

    public static void main() {
        greeting();
        readInput();
    }

}