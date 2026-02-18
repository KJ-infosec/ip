package kj.command;

import kj.KjException;
import kj.Storage;
import kj.Ui;
import kj.task.TaskList;

/**
 * Represents a command to terminate the application.
 */
public class ExitCommand extends Command {

    /**
     * @return true to indicate this is an exit command.
     */
    @Override
    public boolean isExit() {
        return true;
    }

    /**
     * Executes the exit sequence by displaying the farewell message.
     * @param tasks   The current list of tasks.
     * @param ui      The user interface for displaying the goodbye message.
     * @param storage The storage handler.
     * @throws KjException If an error occurs during execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KjException {
        ui.showBye();
    }

}
