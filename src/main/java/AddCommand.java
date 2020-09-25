public class AddCommand extends Command {
    public String commandType = null;

    @Override
    public void execute(TaskList taskList, Ui ui) {
        if (commandType == "deadline") {
            //Assign deadline task
            taskList.add(new Deadline(task[TASK_DESCRIPTION], task[TASK_DO_BY]));
            ui.printTaskAssignment(taskList, taskList.size() - 1);

        } else if (commandType == "event") {
            //Assign event task
            taskList.add(new Event(task[TASK_DESCRIPTION], task[TASK_DO_BY]));
            ui.printTaskAssignment(taskList, taskList.size() - 1);

        } else if (commandType == "todo") {
            //Assign todo task
            if (task[TASK_DESCRIPTION].length() < 1) {
                throw new StringIndexOutOfBoundsException();
            }
            taskList.add(new Todo(task[TASK_DESCRIPTION]));
            ui.printTaskAssignment(taskList, taskList.size() - 1);
        }
    }
}
