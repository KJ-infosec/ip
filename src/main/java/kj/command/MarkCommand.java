package kj.command;

import kj.KjException;
import kj.Storage;
import kj.Ui;
import kj.task.TaskList;

/**
 * Represents a command to mark a specific task as completed.
 */
public class MarkCommand extends Command {
    private final int taskNum;

    public MarkCommand(int taskNum) {
        this.taskNum = taskNum;
    }

    /**
     * Executes the marking of a task as done.
     * @param tasks   The list containing the task to be marked.
     * @param ui      The user interface for displaying feedback.
     * @param storage The storage handler for saving the updated state.
     * @throws KjException If an error occurs during the saving process.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KjException {
        try {
            if (taskNum < 0 || taskNum >= tasks.size()) {
                throw new KjException("That task number does not exist.");
            }
            tasks.get(taskNum).markAsDone();
            storage.save(tasks);
            ui.showMarkedMessage(tasks.get(taskNum));
        } catch (Exception e) {
            ui.showErrorMessage(e.getMessage());
        }
    }

}
