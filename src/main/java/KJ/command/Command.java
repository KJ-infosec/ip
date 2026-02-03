package KJ.command;

import KJ.KJException;
import KJ.TaskList;
import KJ.Ui;
import KJ.Storage;

public abstract class Command {

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws KJException;

    public boolean isExit() {
        return false;
    }
}