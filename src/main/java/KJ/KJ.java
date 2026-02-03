package KJ;
import KJ.command.Command;
import KJ.task.TaskList;

public class KJ {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public KJ(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try{
            tasks = storage.load();
        } catch (KJException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while(!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (KJException e) {
                ui.showErrorMessage(e.getMessage());
            }
        }
    }

    public static void main() {
        new KJ("data/kj.txt").run();
    }
}