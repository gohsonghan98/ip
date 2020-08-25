import java.util.Scanner;

public class Duke {
    private static int textCount;
    final static int MAX_TASK = 100;
    private static String[] taskList = new String[MAX_TASK];

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
        Duke.commandEcho();
    }

    public static void commandEcho() {
        //different response for different types of command
        String line;
        Scanner in;
        while (true) {
            in = new Scanner(System.in);
            line = in.nextLine();
            if (line.equalsIgnoreCase("bye")) {
                break;
            }
            if (line.equalsIgnoreCase("list")){
                displayList();
                continue;
            }
            storeText(line);
        }

        System.out.println("\t____________________________________________________________");
        System.out.println("\tBye. Hope to see you again soon!");
        System.out.println("\t____________________________________________________________");
    }

    public static void storeText(String text){
        taskList[textCount] = text;
        System.out.println("\t____________________________________________________________");
        System.out.println("\tAdded: " + text);
        System.out.println("\t____________________________________________________________");
        textCount++;
    }

    public static void displayList(){
        int i = 1;
        System.out.println("\t____________________________________________________________");
        for(String listTask: taskList){
            if(listTask == null){
                break;
            }
            System.out.println("\t" + i +". "+ listTask);
            i++;
        }
        System.out.println("\t____________________________________________________________");
    }


}
