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
        assert input != null : "Parser received a null input string";
        if (input.equals("bye")) {
            return new ExitCommand();
        }

        if (input.equals("list")) {
            return new ListCommand();
        }

        if (input.startsWith("mark")) {
            String[] parts = input.split(" ");
            assert parts.length >= 2 : "Mark command logic failed to provide index";
            taskNum = Integer.parseInt(parts[1]) - 1;
            return new MarkCommand(taskNum);
        }

        if (input.startsWith("unmark")) {
            String[] parts = input.split(" ");
            assert parts.length >= 2 : "Unmark command logic failed to provide index";
            taskNum = Integer.parseInt(parts[1]) - 1;
            return new UnmarkCommand(taskNum);
        }

        if (input.startsWith("todo")) {
            if (input.equals("todo")) {
                throw new KjException("The description of a Todo cannot be empty.");
            }
            String description = input.substring(5);
            assert !description.isEmpty() : "Todo description extraction logic failed";
            return new AddCommand(new ToDo(description));
        }

        if (input.startsWith("event")) {
            if (!input.contains("/from") || !input.contains("/to")) {
                // Throw it and let KJ.java handle the display
                throw new KjException("Event must have /from and /to");
            }
            String[] description = input.substring(6).split(" /from | /to ");
            assert description.length == 3 : "Event parsing failed to extract three components";
            return new AddCommand(new Event(description[0], description[1], description[2]));
        }

        if (input.startsWith("deadline")) {
            if (!input.contains("/by")) {
                throw new KjException("Deadline must have /by.");
            }
            String[] description = input.substring(9).split(" /by ");
            assert description.length == 2 : "Deadline parsing failed to extract two components";
            return new AddCommand(new Deadline(description[0], description[1]));
        }

        if (input.startsWith("delete")) {
            String[] parts = input.split(" ");
            assert parts.length >= 2 : "Delete command logic failed to provide index";
            int taskNum = Integer.parseInt(parts[1]) - 1;
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
