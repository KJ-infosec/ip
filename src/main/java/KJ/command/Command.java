package KJ.command;

import KJ.KJException;
import KJ.task.TaskList;
import KJ.Ui;
import KJ.Storage;

/**
 * This abstract class serves as the template for all specific command behaviors.
 */
public abstract class Command {

    /**
     * Executes the specific command logic.
     * * @param tasks   The current list of tasks.
     * @param ui      The user interface for displaying feedback.
     * @param storage The storage handler for file operations.
     * @throws KJException If an error occurs during execution.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws KJException;

    /**
     * Indicates whether this command should terminate the application.
     * Defaults to false; overridden by ExitCommand.
     * * @return true if the program should exit, false otherwise.
     */
    public boolean isExit() {
        return false;
    }
}