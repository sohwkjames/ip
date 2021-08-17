import java.util.Scanner;
import java.util.HashMap;

public class Interactor {

    Operations operations;
    private String exitKeyword = "";
    private String doneKeyword = "";
    private String todoKeyword = "todo";
    private String eventKeyword = "event";
    private String deadlineKeyword = "deadline";

    public Interactor() {}

    public void setOperations(Operations operations) {
        this.operations = operations;
    }

    public void setExitKeyword(String exitKeyword){
        this.exitKeyword = exitKeyword;
    }

    public void setDoneKeyword(String doneKeyword) {
        this.doneKeyword = doneKeyword;
    }


    public void start(){
        printGreeting();
        printExitKeyword();

        boolean toContinue = true;

        Scanner scanner = new Scanner(System.in);

        while (true){
            String currentInput = scanner.nextLine();

            if (currentInput.equals(exitKeyword)){
                printGoodbye();
                break;
            }
            if (currentInput.equals("list")){
                operations.printDatabase();
                break;
            }
            // When user toggles done-ness of task
            if (beginsWith(currentInput, doneKeyword)){
                int i = getNumberFromInput(currentInput);
                operations.setDone(i);
                operations.printDatabase();
            }

            //*** check for Todo, deadline, event creations ***
            if (beginsWith(currentInput, todoKeyword)){
                Todo todo = handleTodoCreation(currentInput);
                operations.addToDatabase(todo);
            }

            if (beginsWith(currentInput, deadlineKeyword)){
                Deadline deadline = handleDeadlineCreation(currentInput);
                operations.addToDatabase(deadline);
            }

//            if (beginsWith(currentInput, this.eventKeyword)){
//                Event event = handleEventCreation(currentInput);
//                operations.addToDatabase(event);
//            }

            else{
                System.out.println("Pls enter a proper command");
                operations.printDatabase();
            }
        }
    }

    private Todo handleTodoCreation(String currentInput) {
        // currentInput in the form "todo borrow book"
        String [] arr = currentInput.split(" ", 2); // 2 indicates we expect 2 values in array
        String description = arr[1];
        return new Todo(description);
    }

    private Deadline handleDeadlineCreation(String currentInput) {
        String [] arr = currentInput.split(" ", 2); // 2 indicates we expect 2 values in array
        String [] splitArr = arr[1].split("/", 0);
        String description = splitArr[0];
        String endTime = splitArr[1];
        return new Deadline(false, description, endTime);
    }

//    private Event handleEventCreation(String currentInput) {
//    }

    private int getNumberFromInput(String currentInput) {
        // takes: "someLongString 4". returns: 4
        String [] arr = currentInput.split(" ", 0);
        return Integer.parseInt(arr[1]);
    }

    private static boolean beginsWith(String longerString, String shorterString) {
        if (shorterString.length() > longerString.length()){
            return false;
        }
        // returns true if longerString begins with shorterString
        // beginsWith("done 4", "done") should return True.
        int length = shorterString.length();
        String slicedString = longerString.substring(0, length);
        if (slicedString.equals(shorterString)){
            return true;
        }
        else {return false;}
    }

    private void printExitKeyword() {
        String message = String.format("Please type %s if you want to exit.", this.exitKeyword);
        System.out.println(message);
    }

    private void printGreeting(){
        System.out.println("Dunder Mifflin, this is Pam");
    }

    private void printGoodbye(){
        System.out.println("Okay bye");
    }

}