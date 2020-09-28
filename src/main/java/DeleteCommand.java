/**
 * Represents a delete command.
 */
public class DeleteCommand extends Command {
    public static int taskNumber = -1;

    /**
     * Deletes task from task list.
     *
     * @param taskList the list of tasks containing task to be removed.
     * @param ui user interaction.
     */
    @Override
    public void execute(TaskList taskList, Ui ui) {
        try {
            Task taskRemoved = taskList.get(taskNumber);
            taskList.remove(taskNumber);
            ui.printTaskRemove(taskRemoved);
            ui.printDivider();
        } catch (IndexOutOfBoundsException e) {
            ui.printNoTask();
        }
    }
}

