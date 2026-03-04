package kj.command;
import kj.KjException;
import kj.Storage;
import kj.Ui;
import kj.task.Task;
import kj.task.TaskList;

/**
 * Represents a command to search for tasks containing a specific keyword.
 */
public class FindCommand extends Command {
    private final String keyword;

    /**
     * @param keyword The string to search for within task descriptions.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KjException {
        TaskList matchingTasks = new TaskList();
        String lowerCaseKeyword = keyword.toLowerCase();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.toString().toLowerCase().contains(lowerCaseKeyword)) {
                matchingTasks.add(task);
            }
        }
        ui.showMatchingTasks(matchingTasks);
    }
}
