package kj.command;

import kj.KjException;
import kj.Storage;
import kj.Ui;
import kj.task.TaskList;

/**
 * Represents a command to sort existed task list by name or date.
 */
public class SortCommand extends Command {
    private final String criteria;

    public SortCommand(String criteria) {
        this.criteria = criteria;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KjException {
        if (criteria.equalsIgnoreCase("date")) {
            tasks.sortByDate();
        } else {
            tasks.sortByName();
        }

        storage.save(tasks); // Save the new order to the file
        ui.showSortedMessage(tasks);
    }
}
