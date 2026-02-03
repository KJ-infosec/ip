package KJ.command;

import KJ.KJException;
import KJ.Task;
import KJ.TaskList;
import KJ.Ui;
import KJ.Storage;

public class ExitCommand extends Command{
    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KJException {
        ui.showBye();
    }

}