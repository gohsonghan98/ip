import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a deadline task. A <code>Deadline</code> object correspond to
 * a task that has been assigned as a deadline.
 */
public class Deadline extends Task {
    public static final String TASK_SYMBOL = "D";
    public String by;

    public Deadline(String taskEntry, String by) {
        super(taskEntry);
        this.by = by;
    }

    @Override
    public String getTaskSymbol() {
        return TASK_SYMBOL;
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + getDateOutputFormat() + ")";
    }

    //Format: yyyy-mm-dd
    @Override
    public String getDate() {
        return by;
    }

    /**
     * Returns date in MMM d yyyy format. Date is converted from MMM dd yyyy
     * to MMM d yyyy format.
     *
     * @return MMM d yyyy format
     */
    //Format: MMM dd yyyy
    public String getDateOutputFormat(){
        LocalDate date = LocalDate.parse(by);
        String dateOutputFormat = date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return dateOutputFormat;
    }
}
