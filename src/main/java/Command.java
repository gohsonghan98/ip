public abstract class Command {
    public static boolean isExit = false;
    public static final int TASK_DESCRIPTION = 0;
    public static final int TASK_DO_BY = 1;
    public String[] task = new String[2];

    public Command() {
    }

    public boolean isExit() {
        return isExit;
    }

    public abstract void execute(TaskList taskList, Ui ui);
}
