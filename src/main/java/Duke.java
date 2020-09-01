import java.util.Scanner;

public class Duke {
    private static int taskCount;
    private final static int MAX_TASK = 100;
    private static Task[] taskList = new Task[MAX_TASK];

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
                taskNumber = Integer.parseInt(line.replaceAll("[^\\d]", " ").trim());
                taskList[taskNumber - 1].setDone();
                continue;
            }
            storeText(line);
        }

        System.out.println("\t____________________________________________________________");
        System.out.println("\t Bye. Hope to see you again soon!");
        System.out.println("\t____________________________________________________________");
    }

    public static void storeText(String text) {
        String task;
        String at;
        String by;

        //Assign deadline task
        if(text.startsWith("deadline")){
            task = text.substring(9,text.indexOf(" \\by"));
            by = text.substring(text.indexOf("\\by") + 4, text.length());
            taskList[taskCount] = new Deadline(task, by);
            printTaskAssignment(taskCount);
            taskCount++;

        }   else if(text.startsWith("event")){
            //Assign event task
            task = text.substring(6,text.indexOf(" \\at"));
            at = text.substring(text.indexOf("\\at") + 4, text.length());
            taskList[taskCount] = new Event(task, at);
            printTaskAssignment(taskCount);
            taskCount++;

        }   else if (text.startsWith("todo")){
            //Assign todos task
            task = text.replace("todo ", "");
            taskList[taskCount] = new Todo(task);
            printTaskAssignment(taskCount);
            taskCount++;
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
            System.out.println("\t " + index + "." + "[" + listTask.getTaskSymbol() + "]" + "[" + listTask.getStatusIcon() + "] " + listTask);
            index++;
        }
        System.out.println("\t____________________________________________________________");
    }

    public static void printTaskAssignment(int index){
        int taskIndex = index + 1;
        System.out.println("\t____________________________________________________________");
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t\t" + "[" + taskList[index].getTaskSymbol() + "]" + "[" + taskList[index].getStatusIcon() + "]" +
                " " + taskList[index]);
        System.out.println("\t Now you have " + taskIndex + " tasks in the list.");
        System.out.println("\t____________________________________________________________");
    }

}
