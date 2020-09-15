public class Task{
    public String taskEntry;
    public boolean isDone;
    public String statusIcon;

    public Task(String taskEntry){
        this.taskEntry = taskEntry;
        isDone = false;
        statusIcon = "\u2718";
    }

    public void setDone(){
        isDone = true;
        statusIcon = "\u2713";
        System.out.println("\t____________________________________________________________");
        System.out.println("\t Nice! I've marked this task as done:");
        System.out.println("\t [" + statusIcon + "] " + taskEntry);
        System.out.println("\t____________________________________________________________");
    }

    public void setLoadStatus(String s){
        if(s == "1"){
            isDone = true;
        } else {
            isDone = false;
        }
    }

    @Override
    public String toString(){
        return taskEntry;
    }

    public String getStatusIcon(){
        return statusIcon;
    }

    public String getStatusNumber(){
        if(isDone){
            return "1";
        } else {
            return "0";
        }
    }

    public String getTaskSymbol(){
        return null;
    }

    public String getDate(){
        return null;
    }
}
