public class Parser {
    //handles Todo, Deadline, Event, delete, done, list, bye commands
    public Parser() {
    }

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
            c.task[0] = c.task[0].replace("event ", "");
            c.commandType = "event";
            return c;
        } else if (fullCommand.startsWith("deadline")) {
            AddCommand c = new AddCommand();
            c.task = fullCommand.split(" \\\\by ");
            c.task[0] = c.task[0].replace("deadline ", "");
            c.commandType = "deadline";
            return c;
        } else if (fullCommand.startsWith("todo")) {
            AddCommand c = new AddCommand();
            if (fullCommand.length() <= 5) {
                throw new DukeException();
            }
            c.task[0] = fullCommand.replace("todo ", "");
            c.commandType = "todo";
            return c;
        } else {
            throw new DukeException();
        }
    }
}
