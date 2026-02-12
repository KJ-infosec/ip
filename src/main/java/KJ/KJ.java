package KJ;
import KJ.command.Command;
import KJ.task.TaskList;

public class KJ {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Initializes the KJ application with a specific file path for data storage.
     * If the data file is not found or corrupted, a new empty task list is initialized.
     * * @param filePath The relative path to the file where tasks are saved
     */
    public KJ(String filePath){
        ui = new Ui();
        storage = new Storage(filePath);
        try{
            tasks = storage.load();
        } catch (KJException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Starts the main program loop.
     * Continuously reads user input, parses it into commands, and executes them.
     * Keep running until an exit command is issued.
     */
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