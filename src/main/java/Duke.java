import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Duke {
    private static int taskCount;
    private static TaskList taskList = new TaskList();
    private final static String FILE_PATH = "data/duke.txt";
    private final static String DIR_PATH = "data/";
    public static File f = new File(FILE_PATH);
    public static File dir = new File(DIR_PATH);
    private static Ui ui = new Ui();

    public static void main(String[] args) {
        ui.printWelcome();

        //Load saved tasks from file
        /*if (f.exists()) {
            try {
                loadProgress();
            } catch (FileNotFoundException e) {
                ui.printFileNotFound();
            }
        } else {
            try {
                if (!dir.exists()) {
                    dir.mkdir();
                }
                f.createNewFile();
                ui.printFileCreated();
            } catch (IOException e) {
                ui.printFileNotCreated();
            }
        }*/

        Duke.run();
        //Save taskList to file
        /*try {
            writeToFile(FILE_PATH);
        } catch (IOException e) {
            ui.printSaveError();
        }*/
    }

    public static void run() {
        boolean isExit = false;
        while (!isExit) {
            String fullCommand = ui.readCommand();
            ui.printDivider(); // show the divider line ("_______")
            try {
                Command c = Parser.parse(fullCommand);
                c.execute(taskList, ui);
                isExit = c.isExit();
            } catch (DukeException e){
                if(fullCommand.startsWith("todo")){
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
            } catch (NumberFormatException e){
                ui.printNoTask();
            }
        }
    }

    /*public static void storeText(String text) throws DukeException {
        String task;
        String at;
        String by;

        //Assign deadline task
        if (text.startsWith("deadline")) {
            task = text.substring(9, text.indexOf(" \\by"));
            by = text.substring(text.indexOf("\\by") + 4, text.length());
            taskList.add(new Deadline(task, by));
            ui.printTaskAssignment(taskList, taskList.size() - 1);

        } else if (text.startsWith("event")) {
            //Assign event task
            task = text.substring(6, text.indexOf(" \\at"));
            at = text.substring(text.indexOf("\\at") + 4, text.length());
            taskList.add(new Event(task, at));
            ui.printTaskAssignment(taskList, taskList.size() - 1);

        } else if (text.startsWith("todo")) {
            //Assign todos task
            task = text.replace("todo", "");
            if (task.length() < 1) {
                throw new StringIndexOutOfBoundsException();
            }
            taskList.add(new Todo(task));
            ui.printTaskAssignment(taskList, taskList.size() - 1);

        } else {
            throw new DukeException();
        }
    }

    public static void loadProgress() throws FileNotFoundException {
        String textInput;
        Scanner s = new Scanner(f);
        String[] taskArray = new String[4];
        //Format of text: T | 1 | read book
        while (s.hasNext()) {
            textInput = s.nextLine();
            taskArray = textInput.split(" \\| ");
            if (taskArray[0].equalsIgnoreCase("T")) {
                //Create Todo task
                taskList.add(new Todo(taskArray[2]));
                taskList.get(taskCount).setLoadStatus(taskArray[1]);
                taskCount++;
            }
            if (taskArray[0].equalsIgnoreCase("D")) {
                //Create Deadline Task
                taskList.add(new Deadline(taskArray[2], taskArray[3]));
                taskList.get(taskCount).setLoadStatus(taskArray[1]);
                taskCount++;
            }
            if (taskArray[0].equalsIgnoreCase("E")) {
                //Create Event Task
                taskList.add(new Event(taskArray[2], taskArray[3]));
                taskList.get(taskCount).setLoadStatus(taskArray[1]);
                taskCount++;
            }
        }
    }

    private static void writeToFile(String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        Task a;
        for (int i = 0; i < taskList.size(); i++) {
            a = taskList.get(i);
            if (a.getTaskSymbol().equals("T")) {
                fw.write(a.getTaskSymbol() + " | " + a.getStatusNumber() + " | " + a.toString());
                fw.write("\n");
            }
            if (a.getTaskSymbol().equals("D")) {
                fw.write(a.getTaskSymbol() + " | " + a.getStatusNumber() + " | " + a.toString() + " | " +
                        a.getDate());
                fw.write("\n");
            }
            if (a.getTaskSymbol().equals("E")) {
                fw.write(a.getTaskSymbol() + " | " + a.getStatusNumber() + " | " + a.toString() + " | " +
                        a.getDate());
                fw.write("\n");
            }
        }
        fw.close();
    }*/
}
