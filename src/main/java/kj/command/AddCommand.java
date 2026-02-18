package kj.command;

import kj.KjException;
import kj.Storage;
import kj.Ui;
import kj.task.Task;
import kj.task.TaskList;

/**
 * Represents a command to add a task to the task list.
 */
public class AddCommand extends Command {
    private final Task task;

    /**
     * Constructs an AddCommand with the specified task.
     * @param task The task to be added (ToDo, Deadline, or Event).
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Executes the addition of a task.
     * The task is added to the list, the updated list is saved to the file,
     * and a confirmation message is displayed.
     * @param tasks   The current list of tasks.
     * @param ui      The user interface for interaction.
     * @param storage The storage handler for saving data.
     * @throws KjException If an error occurs during the saving process.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KjException {
        tasks.add(this.task);
        storage.save(tasks);
        ui.showAddedMessage(this.task, tasks.size());
    }

}
