package KJ;

import KJ.command.AddCommand;
import KJ.command.Command;
import KJ.command.DeleteCommand;
import KJ.command.ExitCommand;
import KJ.command.FindCommand;
import KJ.command.ListCommand;
import KJ.command.MarkCommand;
import KJ.command.UnmarkCommand;
import KJ.task.Deadline;
import KJ.task.Event;
import KJ.task.ToDo;


public class Parser {
    static int taskNum;
    public static Command parse(String input) throws KJException{
        if(input.equals("bye")) {
            return new ExitCommand();
        }

        if(input.equals("list")) {
            return new ListCommand();
        }

        if(input.startsWith("mark")) {
            taskNum = Integer.parseInt(input.split(" ")[1]) - 1;
            return new MarkCommand(taskNum);
        }

        if(input.startsWith("unmark")) {
            taskNum = Integer.parseInt(input.split(" ")[1]) - 1;
            return new UnmarkCommand(taskNum);
        }

        if(input.startsWith("todo")) {
            try {
                if (input.equals("todo")) {
                    throw new KJException("The description of a todo cannot be empty.");
                }
                String description = input.substring(5);
                return new AddCommand(new ToDo(description));
            } catch (KJException e) {
                System.out.println(e.getMessage());
            }
        }

        if(input.startsWith("event")) {
            try {
                if (!input.contains("/from") || !input.contains("/to")) {
                    throw new KJException("Event must have /from and /to");
                }
                String[] description = input.substring(6).split(" /from | /to ");
                return new AddCommand(new Event(description[0], description[1], description[2]));
            } catch (KJException e) {
                System.out.println(e.getMessage());
            }
        }

        if(input.startsWith("deadline")) {
            try {
                if (!input.contains("/by")) {
                    throw new KJException("Deadline must have /by.");
                }
                String[] description = input.substring(9).split(" /by ");
                return new AddCommand(new Deadline(description[0], description[1]));
            } catch (KJException e) {
                System.out.println(e.getMessage());
            }
        }

        if(input.startsWith("delete")) {
            int taskNum = Integer.parseInt(input.split(" ")[1]) - 1;
            return new DeleteCommand(taskNum);
        }

        if (input.startsWith("find")) {
            String keyword = input.substring(4).trim();
            if (keyword.isEmpty()) {
                throw new KJException("The search keyword cannot be empty.");
            }
            return new FindCommand(keyword);
        }

        throw new KJException("Sorry, I don't understand that command.");
    }
}