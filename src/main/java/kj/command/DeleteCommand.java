package kj.command;

import kj.KjException;
import kj.Storage;
import kj.Ui;
import kj.task.Task;
import kj.task.TaskList;

/**
 * Represents a command to remove a task from the task list.
 */
public class DeleteCommand extends Command {
    private final int taskNum;

    public DeleteCommand(int taskNum) {
        this.taskNum = taskNum;
    }

    /**
     * Executes the task deletion.
     * @param tasks   The current list of tasks.
     * @param ui      The user interface for interaction.
     * @param storage The storage handler for saving data.
     * @throws KjException If an error occurs during the storage saving process.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KjException {
        try {
            if (taskNum < 0 || taskNum >= tasks.size()) {
                throw new KjException("That task number does not exist.");
            }
            Task removedTask = tasks.remove(this.taskNum);
            storage.save(tasks);
            ui.showDeletedMessage(tasks, removedTask);
        } catch (Exception e) {
            ui.showErrorMessage(e.getMessage());
        }
    }

}
