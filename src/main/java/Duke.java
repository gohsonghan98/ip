import java.util.Scanner;

public class Duke {
    private static int textCount;
    private final static int MAX_TASK = 100;
    private static String[] taskList = new String[MAX_TASK];
    private static int[] taskListStatus = new int[MAX_TASK];

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
        Duke.executeCommand();
    }

    // Recognise command passed to Duke
    public static void executeCommand() {
        // Execute different response for different types of command
        String line;
        Scanner in;
        int taskNumber;
        while (true) {
            in = new Scanner(System.in);
            line = in.nextLine();
            if (line.equalsIgnoreCase("bye")) {
                break;
            }
            if (line.equalsIgnoreCase("list")) {
                displayList();
                continue;
            }
            if (line.contains("done")) {
                taskNumber = Integer.parseInt(line.replace("done", " ").trim());
                setTaskToDone(taskNumber - 1);
                continue;
            }
            storeText(line);
        }

        System.out.println("\t____________________________________________________________");
        System.out.println("\tBye. Hope to see you again soon!");
        System.out.println("\t____________________________________________________________");
    }

    public static void storeText(String text) {
        taskList[textCount] = text;
        System.out.println("\t____________________________________________________________");
        System.out.println("\tAdded: " + text);
        System.out.println("\t____________________________________________________________");
        textCount++;
    }

    public static void displayList() {
        int index = 1;
        System.out.println("\t____________________________________________________________");
        System.out.println("\tHere are the tasks in your list:");
        for (String listTask : taskList) {
            if (listTask == null) {
                break;
            }
            System.out.println("\t" + index + "." + "[" + getStatusIcon(index) + "] " + listTask);
            index++;
        }
        System.out.println("\t____________________________________________________________");
    }

    public static String getStatusIcon(int index) {
        if (taskListStatus[index - 1] == 1) {
            return "\u2713";
        } else {
            return "\u2718";
        }
    }

    public static void setTaskToDone(int taskNumber) {
        taskListStatus[taskNumber] = 1;
        System.out.println("\t____________________________________________________________");
        System.out.println("\tNice! I've marked this task as done:");
        System.out.println("\t[" + getStatusIcon(1) + "] " + taskList[taskNumber]);
        System.out.println("\t____________________________________________________________");
    }

}
