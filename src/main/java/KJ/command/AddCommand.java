package KJ.command;

import KJ.KJException;
import KJ.Task;
import KJ.TaskList;
import KJ.Ui;
import KJ.Storage;

public class AddCommand extends Command{
    private final Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KJException {
        tasks.add(this.task);
        storage.save(tasks);
        ui.showAddedMessage(this.task, tasks.size());
    }

}