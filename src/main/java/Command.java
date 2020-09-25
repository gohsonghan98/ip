public abstract class Command {
    public static boolean isExit = false;
    public String[] task = new String[2];
    public Command(){
    }
    public boolean isExit(){
        return isExit;
    }
    public abstract void execute(TaskList taskList, Ui ui);
}
