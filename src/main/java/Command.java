/**
 * The <code>Command</code> abstract class is a base class for all types of command
 * which allow parsed input commands to be captured and executed.
 */
public abstract class Command {
    public static boolean isExit = false;
    public static final int TASK_DESCRIPTION = 0;
    public static final int TASK_DO_BY = 1;
    public String[] task = new String[2];

    public Command() {
    }

    /**
     * Returns exit status of Command object.
     *
     * @return exit status.
     */
    public boolean isExit() {
        return isExit;
    }

    public abstract void execute(TaskList taskList, Ui ui);
}
