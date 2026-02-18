package kj.command;

import kj.KjException;
import kj.Storage;
import kj.Ui;
import kj.task.TaskList;


/**
 * Represents a command to display all tasks currently in the task list.
 */
public class ListCommand extends Command {

    /**
     * Executes the list command by requesting the UI to display all tasks.
     * @param tasks   The TaskList containing the tasks to be listed.
     * @param ui      The user interface used to print the task list.
     * @param storage The storage handler (not used by this specific command).
     * @throws KjException If an error occurs during execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KjException {
        ui.showListMessage(tasks, tasks.size());
    }

}
