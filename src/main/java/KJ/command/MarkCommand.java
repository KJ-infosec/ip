package KJ.command;

import KJ.KJException;
import KJ.Task;
import KJ.TaskList;
import KJ.Ui;
import KJ.Storage;

public class MarkCommand extends Command{
    private final int taskNum;

    public MarkCommand(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KJException {
        try {
            if (taskNum < 0 || taskNum >= tasks.size()) {
                throw new KJException("That task number does not exist.");
            }
            tasks.get(taskNum).markAsDone();
            storage.save(tasks);
            ui.showMarkedMessage(tasks.get(taskNum));
        } catch (Exception e) {
            ui.showErrorMessage(e.getMessage());
        }
    }

}