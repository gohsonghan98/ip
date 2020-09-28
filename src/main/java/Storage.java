import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represents a space to store and load files for Duke.
 */
public class Storage {
    public static File f;
    public static File dir;
    public static FileWriter fw;
    public static Ui ui;

    public Storage(String filePath, String fileDirectory) {
        ui = new Ui();
        f = new File(filePath);
        dir = new File(fileDirectory);
    }

    /**
     * Loads tasks from saved file to task list.
     *
     * @param taskList
     */
    public void load(TaskList taskList) {
        if (f.exists()) {
            try {
                readFile(taskList);
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
        }
    }

    /**
     * Transfer task records from file to task list.
     *
     * @param taskList task list to store task records from file.
     * @throws FileNotFoundException File not found.
     */
    private void readFile(TaskList taskList) throws FileNotFoundException {
        String textInput;
        Scanner s = new Scanner(f);
        String[] taskArray = new String[4];
        int taskTypeIndex = 0;
        int taskStatusIndex = 1;
        int descriptionIndex = 2;
        int doByIndex = 3;
        //Format of text: T | 1 | read book
        while (s.hasNext()) {
            textInput = s.nextLine();
            taskArray = textInput.split(" \\| ");
            if (taskArray[taskTypeIndex].equalsIgnoreCase("T")) {
                //Create Todo task
                taskList.add(new Todo(taskArray[descriptionIndex]));
                taskList.get(taskList.size() - 1).setLoadStatus(taskArray[taskStatusIndex]);
            }
            if (taskArray[taskTypeIndex].equalsIgnoreCase("D")) {
                //Create Deadline Task
                taskList.add(new Deadline(taskArray[descriptionIndex], taskArray[doByIndex]));
                taskList.get(taskList.size() - 1).setLoadStatus(taskArray[taskStatusIndex]);
            }
            if (taskArray[taskTypeIndex].equalsIgnoreCase("E")) {
                //Create Event Task
                taskList.add(new Event(taskArray[descriptionIndex], taskArray[doByIndex]));
                taskList.get(taskList.size() - 1).setLoadStatus(taskArray[taskStatusIndex]);
            }
        }
    }

    //Write task list back to file
    public void writeFile(TaskList taskList) throws IOException {
        try {
            fw = new FileWriter(f);
        } catch (IOException e) {
            ui.printSaveError();
        }
        Task a;
        for (int i = 0; i < taskList.size(); i++) {
            a = taskList.get(i);
            if (a.getTaskSymbol().equals("T")) {
                fw.write(a.getTaskSymbol() + " | " + a.getStatusNumber() + " | " + a.toString());
                fw.write("\n");
            }
            if (a.getTaskSymbol().equals("D")) {
                fw.write(a.getTaskSymbol() + " | " + a.getStatusNumber() + " | " + a.taskEntry + " | " +
                        a.getDate());
                fw.write("\n");
            }
            if (a.getTaskSymbol().equals("E")) {
                fw.write(a.getTaskSymbol() + " | " + a.getStatusNumber() + " | " + a.taskEntry + " | " +
                        a.getDate());
                fw.write("\n");
            }
        }
        fw.close();
    }
}
