import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Duke {
    private static int taskCount;
    private final static int MAX_TASK = 100;
    private static Task[] taskList = new Task[MAX_TASK];
    private final static String FILE_PATH = "data/duke.txt";
    public static File f = new File(FILE_PATH);

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("\t____________________________________________________________");
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
        System.out.println("\t____________________________________________________________");
        //Load saved tasks from file
        if(f.exists()){
            try{
                loadProgress();
            } catch (FileNotFoundException e){
                System.out.println("\tFile not found!");
            }
        } else {
            try {
                f.createNewFile();
            } catch (IOException e){
                System.out.println("\tFile not created");
            }
        }

        Duke.executeCommand();

        //Save taskList to file
        try{
            writeToFile(FILE_PATH);
        } catch (IOException e) {
            System.out.println("\tError saving tasks!");
        }
    }

    // Recognise command passed to Duke
    public static void executeCommand() {
        // Execute different response for different types of command
        String line;
        Scanner in = new Scanner(System.in);
        int taskNumber;
        while (true) {
            line = in.nextLine();
            if (line.equalsIgnoreCase("bye")) {
                break;
            }
            if (line.equalsIgnoreCase("list")) {
                displayList();
                continue;
            }
            if (line.contains("done")) {
                taskNumber = Integer.parseInt(line.replaceAll("[^\\d]", " ").trim());
                taskList[taskNumber - 1].setDone();
                continue;
            }
            try {
                storeText(line);
            } catch (DukeException e) {
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-()");
            } catch (StringIndexOutOfBoundsException e) {
                if (line.startsWith("deadline")) {
                    System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
                } else if (line.startsWith("event")) {
                    System.out.println("☹ OOPS!!! The description of a event cannot be empty.");
                } else if (line.startsWith("todo")) {
                    System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                }
            }
        }

        System.out.println("\t____________________________________________________________");
        System.out.println("\t Bye. Hope to see you again soon!");
        System.out.println("\t____________________________________________________________");
    }

    public static void storeText(String text) throws DukeException {
        String task;
        String at;
        String by;

        //Assign deadline task
        if (text.startsWith("deadline")) {
            task = text.substring(9, text.indexOf(" \\by"));
            by = text.substring(text.indexOf("\\by") + 4, text.length());
            taskList[taskCount] = new Deadline(task, by);
            printTaskAssignment(taskCount);
            taskCount++;

        } else if (text.startsWith("event")) {
            //Assign event task
            task = text.substring(6, text.indexOf(" \\at"));
            at = text.substring(text.indexOf("\\at") + 4, text.length());
            taskList[taskCount] = new Event(task, at);
            printTaskAssignment(taskCount);
            taskCount++;

        } else if (text.startsWith("todo")) {
            //Assign todos task
            task = text.replace("todo", "");
            if (task.length() < 1) {
                throw new StringIndexOutOfBoundsException();
            }
            taskList[taskCount] = new Todo(task);
            printTaskAssignment(taskCount);
            taskCount++;
        } else {
            throw new DukeException();
        }
    }

    public static void displayList() {
        int index = 1;
        System.out.println("\t____________________________________________________________");
        System.out.println("\t Here are the tasks in your list:");
        for (Task listTask : taskList) {
            if (listTask == null) {
                break;
            }
            System.out.println("\t " + index + "." + "[" + listTask.getTaskSymbol() + "]" + "["
                    + listTask.getStatusIcon() + "] " + listTask);
            index++;
        }
        System.out.println("\t____________________________________________________________");
    }

    public static void printTaskAssignment(int index) {
        int taskIndex = index + 1;
        System.out.println("\t____________________________________________________________");
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t\t" + "[" + taskList[index].getTaskSymbol() + "]" + "[" + taskList[index].getStatusIcon()
                + "]" + " " + taskList[index]);
        System.out.println("\t Now you have " + taskIndex + " tasks in the list.");
        System.out.println("\t____________________________________________________________");
    }

/*    private static void printFileContents(String filePath) throws FileNotFoundException {
        File f = new File(FILE_PATH);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            System.out.println(s.nextLine());
        }
    }*/

    public static void loadProgress() throws FileNotFoundException{
        //File contains something
        String textInput;
        Scanner s = new Scanner(f);
        String[] taskArray = new String[4];
        //Format of text: T | 1 | read book
        while(s.hasNext()){
            textInput = s.nextLine();
            taskArray = textInput.split(" \\| ");
            if(taskArray[0].equalsIgnoreCase("T")){
                //Create Todo task
                taskList[taskCount] = new Todo(taskArray[2]);
                taskList[taskCount].setLoadStatus(taskArray[1]);
                taskCount++;
            }
            if(taskArray[0].equalsIgnoreCase("D")){
                //Create Deadline Task
                taskList[taskCount] = new Deadline(taskArray[2],taskArray[3]);
                taskList[taskCount].setLoadStatus(taskArray[1]);
                taskCount++;
            }
            if(taskArray[0].equalsIgnoreCase("E")){
                //Create Event Task
                taskList[taskCount] = new Event(taskArray[2],taskArray[3]);
                taskList[taskCount].setLoadStatus(taskArray[1]);
                taskCount++;
            }
        }
    }

    private static void writeToFile(String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        Task a;
        for(int i = 0; i<taskCount; i++) {
            a = taskList[i];
            if(a.getTaskSymbol().equals("T")){
                fw.write(a.getTaskSymbol() + " | " + a.getStatusNumber() + " | " + a.toString());
                fw.write("\n");
            }
            if(a.getTaskSymbol().equals("D")){
                fw.write(a.getTaskSymbol() + " | " + a.getStatusNumber() + " | " + a.toString() + " | " +
                        a.getDate());
                fw.write("\n");
            }
            if(a.getTaskSymbol().equals("E")){
                fw.write(a.getTaskSymbol() + " | " + a.getStatusNumber() + " | " + a.toString() + " | " +
                        a.getDate());
                fw.write("\n");
            }
        }
        fw.close();
    }
}
