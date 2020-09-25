import java.io.IOException;

public class Duke {
    private static TaskList taskList = new TaskList();
    private final static String FILE_PATH = "data/duke.txt";
    private final static String DIR_PATH = "data/";
    private static Ui ui = new Ui();
    private static Storage storage;

    public static void main(String[] args) {
        ui.printWelcome();
        storage = new Storage(FILE_PATH, DIR_PATH);
        storage.load(taskList);
        Duke.run();
    }

    public static void run() {
        boolean isExit = false;
        while (!isExit) {
            String fullCommand = ui.readCommand();
            ui.printDivider();
            //Convert command from String type to Command type
            try {
                Command c = Parser.parse(fullCommand);
                c.execute(taskList, ui);
                isExit = c.isExit();
            } catch (DukeException e) {
                if (fullCommand.startsWith("todo")) {
                    ui.printEmptyTodo();
                } else {
                    ui.printInvalidInput();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                if (fullCommand.startsWith("deadline")) {
                    ui.printEmptyDeadline();
                } else if (fullCommand.startsWith("event")) {
                    ui.printEmptyEvent();
                }
            } catch (NumberFormatException e) {
                ui.printNoTask();
            }
            //Write to file after every command input
            try {
                storage.writeFile(taskList);
            } catch (IOException e) {
                ui.printSaveError();
            }
        }
    }
}
