package KJ.command;

import KJ.KJException;
import KJ.Task;
import KJ.TaskList;
import KJ.Ui;
import KJ.Storage;

public class ListCommand extends Command{

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KJException {
        ui.showListMessage(tasks, tasks.size());
    }

}