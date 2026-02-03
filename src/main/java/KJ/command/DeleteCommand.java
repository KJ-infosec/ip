package KJ.command;

import KJ.KJException;
import KJ.task.Task;
import KJ.task.TaskList;
import KJ.Ui;
import KJ.Storage;

public class DeleteCommand extends Command{
    private final int taskNum;

    public DeleteCommand(int taskNum) {
        this.taskNum = taskNum;
    }

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