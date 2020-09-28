import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents an event task. An <code>Event</code> object correspond to
 * a task that has been assigned as an event.
 */
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

    /**
     * Returns date in MMM d yyyy format. Date is converted from MMM dd yyyy
     * to MMM d yyyy format.
     *
     * @return MMM d yyyy format
     */
    //Format: MMM dd yyyy
    public String getDateOutputFormat(){
        LocalDate date = LocalDate.parse(at);
        String dateOutputFormat = date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return dateOutputFormat;
    }
}
