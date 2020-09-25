public class AddCommand extends Command {
    public String commandType = null;
    @Override
    public void execute(TaskList taskList, Ui ui){
        if (commandType == "deadline") {
            //MAYBE COMMENT ON THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            taskList.add(new Deadline(task[0], task[1]));
            ui.printTaskAssignment(taskList, taskList.size() - 1);

        } else if (commandType == "event") {
            //Assign event task
            taskList.add(new Event(task[0], task[1]));
            ui.printTaskAssignment(taskList, taskList.size() - 1);

        } else if (commandType == "todo") {
            //Assign todos task
            if (task[0].length() < 1) {
                throw new StringIndexOutOfBoundsException();
            }
            taskList.add(new Todo(task[0]));
            ui.printTaskAssignment(taskList, taskList.size() - 1);
        }
    }
}
