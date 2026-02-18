package kj;

import kj.command.AddCommand;
import kj.command.Command;
import kj.command.DeleteCommand;
import kj.command.ExitCommand;
import kj.command.FindCommand;
import kj.command.ListCommand;
import kj.command.MarkCommand;
import kj.command.UnmarkCommand;
import kj.task.Deadline;
import kj.task.Event;
import kj.task.ToDo;

/**
 * Parsing and reading user input into KJ application.
 */
public class Parser {
    private static int taskNum;
    /**
     * Parses the given input string and returns the appropriate Command object.
     * @param input The raw user input string.
     * @return A Command object representing the user's request.
     * @throws KjException If the input format is invalid or the command is unknown.
     */
    public static Command parse(String input) throws KjException {
        if (input.equals("bye")) {
            return new ExitCommand();
        }

        if (input.equals("list")) {
            return new ListCommand();
        }

        if (input.startsWith("mark")) {
            taskNum = Integer.parseInt(input.split(" ")[1]) - 1;
            return new MarkCommand(taskNum);
        }

        if (input.startsWith("unmark")) {
            taskNum = Integer.parseInt(input.split(" ")[1]) - 1;
            return new UnmarkCommand(taskNum);
        }

        if (input.startsWith("todo")) {
            try {
                if (input.equals("todo")) {
                    throw new KjException("The description of a todo cannot be empty.");
                }
                String description = input.substring(5);
                return new AddCommand(new ToDo(description));
            } catch (KjException e) {
                System.out.println(e.getMessage());
            }
        }

        if (input.startsWith("event")) {
            try {
                if (!input.contains("/from") || !input.contains("/to")) {
                    throw new KjException("Event must have /from and /to");
                }
                String[] description = input.substring(6).split(" /from | /to ");
                return new AddCommand(new Event(description[0], description[1], description[2]));
            } catch (KjException e) {
                System.out.println(e.getMessage());
            }
        }

        if (input.startsWith("deadline")) {
            try {
                if (!input.contains("/by")) {
                    throw new KjException("Deadline must have /by.");
                }
                String[] description = input.substring(9).split(" /by ");
                return new AddCommand(new Deadline(description[0], description[1]));
            } catch (KjException e) {
                System.out.println(e.getMessage());
            }
        }

        if (input.startsWith("delete")) {
            int taskNum = Integer.parseInt(input.split(" ")[1]) - 1;
            return new DeleteCommand(taskNum);
        }

        if (input.startsWith("find")) {
            String keyword = input.substring(4).trim();
            if (keyword.isEmpty()) {
                throw new KjException("The search keyword cannot be empty.");
            }
            return new FindCommand(keyword);
        }

        throw new KjException("Sorry, I don't understand that command.");
    }
}
