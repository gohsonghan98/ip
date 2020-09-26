public class FindCommand extends Command {
    public String commandType = null;

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
