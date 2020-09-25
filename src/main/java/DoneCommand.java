public class DoneCommand extends Command{
    public static int taskNumber = -1;
    @Override
    public void execute(TaskList taskList, Ui ui) {
        try {
            taskList.get(taskNumber).setDone();
        } catch (IndexOutOfBoundsException e) {
            ui.printNoTask();
        }
    }
}
