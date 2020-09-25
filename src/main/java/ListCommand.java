public class ListCommand extends Command {
    public void execute(TaskList taskList, Ui ui) {
        ui.displayList(taskList);
    }
}
