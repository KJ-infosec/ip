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
    /**
     * Parses the given input string and returns the appropriate Command object.
     * @param input The raw user input string.
     * @return A Command object representing the user's request.
     * @throws KjException If the input format is invalid or the command is unknown.
     */
    public static Command parse(String input) throws KjException {
        assert input != null : "Parser received a null input string";

        // Extract the first word to determine the command type
        String commandWord = input.trim().split(" ")[0].toLowerCase();

        switch (commandWord) {
        case "bye":
            return new ExitCommand();

        case "list":
            return new ListCommand();

        case "mark":
            return prepareMark(input);

        case "unmark":
            return prepareUnmark(input);

        case "todo":
            return prepareTodo(input);

        case "deadline":
            return prepareDeadline(input);

        case "event":
            return prepareEvent(input);

        case "delete":
            return prepareDelete(input);

        case "find":
            return prepareFind(input);

        default:
            throw new KjException("Sorry, I don't understand that command.");
        }
    }

    private static Command prepareTodo(String input) throws KjException {
        if (input.equals("todo")) {
            throw new KjException("The description of a Todo cannot be empty.");
        }
        String description = input.substring(5).trim();
        assert !description.isEmpty() : "Todo description extraction logic failed";
        return new AddCommand(new ToDo(description));
    }

    private static Command prepareDeadline(String input) throws KjException {
        if (!input.contains("/by")) {
            throw new KjException("Deadline must have /by.");
        }
        String[] parts = input.substring(9).split(" /by ", 2);
        if (parts.length < 2 || parts[0].trim().isEmpty()) {
            throw new KjException("Deadline description and date cannot be empty.");
        }
        return new AddCommand(new Deadline(parts[0].trim(), parts[1].trim()));
    }

    private static Command prepareEvent(String input) throws KjException {
        if (!input.contains("/from") || !input.contains("/to")) {
            throw new KjException("Event must have /from and /to");
        }
        String[] parts = input.substring(6).split(" /from | /to ");
        assert parts.length == 3 : "Event parsing failed to extract three components";
        return new AddCommand(new Event(parts[0].trim(), parts[1].trim(), parts[2].trim()));
    }

    private static Command prepareMark(String input) throws KjException {
        try {
            int index = Integer.parseInt(input.split(" ")[1]) - 1;
            return new MarkCommand(index);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new KjException("Please provide a valid task number to mark.");
        }
    }

    private static Command prepareUnmark(String input) throws KjException {
        try {
            int index = Integer.parseInt(input.split(" ")[1]) - 1;
            return new UnmarkCommand(index);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new KjException("Please provide a valid task number to unmark.");
        }
    }

    private static Command prepareDelete(String input) throws KjException {
        try {
            int index = Integer.parseInt(input.split(" ")[1]) - 1;
            return new DeleteCommand(index);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new KjException("Please provide a valid task number to delete.");
        }
    }

    private static Command prepareFind(String input) throws KjException {
        String keyword = input.substring(4).trim();
        if (keyword.isEmpty()) {
            throw new KjException("The search keyword cannot be empty.");
        }
        return new FindCommand(keyword);
    }
}
