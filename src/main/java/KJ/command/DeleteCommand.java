package KJ.command;

import KJ.KJException;
import KJ.task.Task;
import KJ.task.TaskList;
import KJ.Ui;
import KJ.Storage;

/**
 * Represents a command to remove a task from the task list.
 */
public class DeleteCommand extends Command{
    private final int taskNum;

    public DeleteCommand(int taskNum) {
        this.taskNum = taskNum;
    }

    /**
     * Executes the task deletion.
     * Removes the task from the list, saves the updated list to storage,
     * and displays a confirmation message.
     * * @param tasks   The current list of tasks.
     * @param ui      The user interface for interaction.
     * @param storage The storage handler for saving data.
     * @throws KJException If an error occurs during the storage saving process.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KJException {
        try {
            if (taskNum < 0 || taskNum >= tasks.size()) {
                throw new KJException("That task number does not exist.");
            }
            Task removedTask = tasks.remove(this.taskNum);
            storage.save(tasks);
            ui.showDeletedMessage(tasks, removedTask);
        } catch (Exception e) {
            ui.showErrorMessage(e.getMessage());
        }
    }


}