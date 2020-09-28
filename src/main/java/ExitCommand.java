/**
 * Represents an exit command.
 */
public class ExitCommand extends Command {
    public void execute(TaskList taskList, Ui ui) {
        isExit = true;
        ui.printByeMessage();
    }
}
