public class Deadline extends Task{
    public static final String TASK_SYMBOL = "D";
    public String by;

    public Deadline(String taskEntry, String by){
        super(taskEntry);
        this.by = by;
    }

    @Override
    public String getTaskSymbol(){
        return TASK_SYMBOL;
    }

    @Override
    public String toString(){
        return super.toString() + " (by: " + by + ")";
    }

}
