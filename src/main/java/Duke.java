import java.util.Scanner;
public class Duke {
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

    public static void commandEcho () {
        //different response for different types of command
        String line;
        Scanner in;
        while(true){
            in = new Scanner(System.in);
            line = in.nextLine();
            if(line.equalsIgnoreCase("bye")){
                break;
            }
            System.out.println("\t____________________________________________________________");
            System.out.println("\t" + line);
            System.out.println("\t____________________________________________________________");
        }

        System.out.println("\t____________________________________________________________");
        System.out.println("\tBye. Hope to see you again soon!");
        System.out.println("\t____________________________________________________________");
    }
}
