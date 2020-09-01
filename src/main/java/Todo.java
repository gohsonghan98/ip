public class Todo extends Task{
    public static final String TASK_SYMBOL = "T";

    public Todo(String taskEntry){
        super(taskEntry);
    }

    @Override
    public String getTaskSymbol(){
        return TASK_SYMBOL;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
