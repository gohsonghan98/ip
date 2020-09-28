/**
 * Represents a done command. A <code>DoneCommand</code> object represents a command to
 * set a task to done.
 */
public class DoneCommand extends Command {
    public static int taskNumber = -1;

    /**
     * Sets the specified task from task list to done.
     *
     * @param taskList task list containing the task to be set to done.
     * @param ui user interface.
     */
    @Override
    public void execute(TaskList taskList, Ui ui) {
        try {
            taskList.get(taskNumber).setDone();
        } catch (IndexOutOfBoundsException e) {
            ui.printNoTask();
        }
    }
}
