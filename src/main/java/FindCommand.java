/**
 * Represents a command to find and filter a task list based on given keyword.
 */
public class FindCommand extends Command {
    public String commandType = null;

    /**
     * Find and filter task list based on given keyword.
     *
     * @param taskList task list to be filtered by keyword.
     * @param ui user interface.
     */
    @Override
    public void execute(TaskList taskList, Ui ui) {
        int listIndex = 1;
        ui.printDivider();
        System.out.println("Here are the matching tasks in your list:");
        String query = task[TASK_DESCRIPTION].toUpperCase();
        for (Task t : taskList) {
            if (t.taskEntry.toUpperCase().contains(query)) {
                System.out.println("\t " + listIndex + "." + "[" + t.getTaskSymbol() + "]" + "["
                        + t.getStatusIcon() + "] " + t);
                listIndex++;
            }
        }
        ui.printDivider();
    }
}
