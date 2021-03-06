import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Represents a class that converts String inputs to Command object.
 */
public class Parser {
    //Handles Todo, Deadline, Event, delete, done, list, bye commands
    public Parser() {
    }

    /**
     * Returns a <code>Command</code> object based on String input.
     *
     * @param fullCommand String input given by user.
     * @return Command type object.
     * @throws DukeException Invalid String input.
     */
    public static Command parse(String fullCommand) throws DukeException {
        if (fullCommand.startsWith("list")) {
            ListCommand c = new ListCommand();
            return c;
        } else if (fullCommand.startsWith("bye")) {
            ExitCommand c = new ExitCommand();
            return c;
        } else if (fullCommand.startsWith("delete")) {
            DeleteCommand c = new DeleteCommand();
            c.taskNumber = Integer.parseInt(fullCommand.replaceAll("[^\\d]", " ").trim()) - 1;
            return c;
        } else if (fullCommand.startsWith("done")) {
            DoneCommand c = new DoneCommand();
            c.taskNumber = Integer.parseInt(fullCommand.replaceAll("[^\\d]", " ").trim()) - 1;
            return c;
        } else if (fullCommand.startsWith("event")) {
            AddCommand c = new AddCommand();
            c.task = fullCommand.split(" \\\\at ");
            //Check if date format is valid
            try{
                LocalDate.parse(c.task[1]);
                c.task[0] = c.task[0].replace("event ", "");
                c.commandType = "event";
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format, please use the following format: YYYY-MM-DD");
            }
            return c;
        } else if (fullCommand.startsWith("deadline")) {
            AddCommand c = new AddCommand();
            c.task = fullCommand.split(" \\\\by ");
            //Check if date format is valid
            try{
                LocalDate.parse(c.task[1]);
                c.task[0] = c.task[0].replace("deadline ", "");
                c.commandType = "deadline";
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format, please use the following format: YYYY-MM-DD");
            }
            return c;
        } else if (fullCommand.startsWith("todo")) {
            AddCommand c = new AddCommand();
            if (fullCommand.length() <= 5) {
                throw new DukeException();
            }
            c.task[0] = fullCommand.replace("todo ", "");
            c.commandType = "todo";
            return c;
        } else if (fullCommand.startsWith("find")) {
            FindCommand c = new FindCommand();
            c.task[0] = fullCommand.replace("find ", "");
            c.commandType = "find";
            return c;
        } else {
            throw new DukeException();
        }
    }
}
