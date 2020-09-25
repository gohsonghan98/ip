import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    public static final String DIVIDER = ("\t____________________________________________________________");
    public static final String FILE_NOT_FOUND = ("\t File not found!");
    public static final String FILE_CREATED = ("\t New file created automatically.");
    public static final String FILE_NOT_CREATED = ("\t Error! File could not created.");
    public static final String SAVE_ERROR = ("\t Error saving tasks!");
    public static final String TASK_LIST_HEADER = ("\t Here are the tasks in your list:");
    public static final String NO_TASK = ("\t ☹ OOPS!!! I'm sorry, but there is no task in that entry :-()");
    public static final String INVALID_INPUT = ("\t ☹ OOPS!!! I'm sorry, but I don't know what that means :-()");
    public static final String EMPTY_DEADLINE = ("\t ☹ OOPS!!! The description of a deadline cannot be empty.");
    public static final String EMPTY_EVENT = ("\t ☹ OOPS!!! The description of a event cannot be empty.");
    public static final String EMPTY_TODO = ("\t ☹ OOPS!!! The description of a todo cannot be empty.");
    public static final String BYE_MESSAGE = ("\t Bye. Hope to see you again soon!");
    public static final String LOGO = (" ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n");
    public Scanner in = new Scanner(System.in);

    public Ui() {
    }

    public void printWelcome() {
        System.out.println("Hello from\n" + LOGO);
        printDivider();
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
        printDivider();
    }

    public void printFileNotFound() {
        System.out.println(FILE_NOT_FOUND);
    }

    public void printFileCreated() {
        System.out.println(FILE_CREATED);
    }

    public void printFileNotCreated() {
        System.out.println(FILE_NOT_CREATED);
    }

    public void printSaveError() {
        System.out.println(SAVE_ERROR);
    }

    public void printDivider() {
        System.out.println(DIVIDER);
    }

    public void printNoTask() {
        System.out.println(NO_TASK);
    }

    public void printInvalidInput() {
        System.out.println(INVALID_INPUT);
    }

    public void printEmptyDeadline() {
        System.out.println(EMPTY_DEADLINE);
    }

    public void printEmptyEvent() {
        System.out.println(EMPTY_EVENT);
    }

    public void printEmptyTodo() {
        System.out.println(EMPTY_TODO);
    }

    public void printByeMessage() {
        printDivider();
        System.out.println(BYE_MESSAGE);
        printDivider();
    }

    public void printTaskRemove(Task taskRemoved) {
        System.out.println("\t Noted. I've removed this task:");
        System.out.println("\t\t" + "[" + taskRemoved.getTaskSymbol() + "]" + "[" +
                taskRemoved.getStatusIcon() + "]" + " " + taskRemoved);
    }

    public void printTaskListHeader() {
        System.out.println(TASK_LIST_HEADER);
    }

    public void displayList(ArrayList<Task> taskList) {
        int index = 1;
        printDivider();
        printTaskListHeader();
        for (Task listTask : taskList) {
            if (listTask == null) {
                break;
            }
            System.out.println("\t " + index + "." + "[" + listTask.getTaskSymbol() + "]" + "["
                    + listTask.getStatusIcon() + "] " + listTask);
            index++;
        }
        printDivider();
    }

    public void printTaskAssignment(ArrayList<Task> taskList, int index) {
        int taskIndex = index + 1;
        printDivider();
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t\t" + "[" + taskList.get(index).getTaskSymbol() + "]" + "[" +
                taskList.get(index).getStatusIcon() + "]" + " " + taskList.get(index));
        System.out.println("\t Now you have " + taskIndex + " tasks in the list.");
        printDivider();
    }

    public String readCommand() {
        //check this!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        return in.nextLine();

    }
}
