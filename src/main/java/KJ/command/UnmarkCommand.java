package KJ.command;

import KJ.KJException;
import KJ.task.TaskList;
import KJ.Ui;
import KJ.Storage;

/**
 * Represents a command to mark a specific task as not completed.
 */
public class UnmarkCommand extends Command{
    private final int taskNum;

    public UnmarkCommand(int taskNum) {
        this.taskNum = taskNum;
    }

    /**
     * Executes the unmarking of a task.
     * Checks for valid index bounds, updates the task status to undone,
     * saves the change to the disk, and displays the unmarked message.
     * * @param tasks   The list containing the task to be unmarked.
     * @param ui      The user interface for displaying feedback.
     * @param storage The storage handler for data persistence.
     * @throws KJException If there is an issue saving the updated task list.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KJException {
        try {
            if (taskNum < 0 || taskNum >= tasks.size()) {
                throw new KJException("That task number does not exist.");
            }
            tasks.get(taskNum).markAsUndone();
            storage.save(tasks);
            ui.showUnmarkedMessage(tasks.get(taskNum));
        } catch (Exception e) {
            ui.showErrorMessage(e.getMessage());
        }
    }
}