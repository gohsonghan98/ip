import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    public static final String TASK_SYMBOL = "E";
    public String at;

    public Event(String taskEntry, String at) {
        super(taskEntry);
        this.at = at;
    }

    @Override
    public String getTaskSymbol() {
        return TASK_SYMBOL;
    }

    @Override
    public String toString() {
        return super.toString() + " (at: " + getDateOutputFormat() + ")";
    }

    //Format: yyyy-mm-dd
    @Override
    public String getDate() {
        return at;
    }

    //Format: MMM dd yyyy
    public String getDateOutputFormat(){
        LocalDate date = LocalDate.parse(at);
        String dateOutputFormat = date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return dateOutputFormat;
    }
}
