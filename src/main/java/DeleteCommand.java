public class DeleteCommand extends Command {
    public static int taskNumber = -1;

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

