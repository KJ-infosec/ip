import java.util.Scanner;

public class KJ {
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
            } else {
                System.out.println(LINE);
                System.out.println(input);
                System.out.println(LINE);
            }
        }
    }

    public static void byeMessage() {
        System.out.println(LINE);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    public static void main() {
        greeting();
        readInput();
    }

}