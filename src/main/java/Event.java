public class Event extends Task{
    public static final String TASK_SYMBOL = "E";
    public String at;

    public Event(String taskEntry, String at){
        super(taskEntry);
        this.at = at;
    }

    @Override
    public String getTaskSymbol(){
        return TASK_SYMBOL;
    }

    @Override
    public String toString(){
        return super.toString() + " (at: " + at + ")";
    }
}
