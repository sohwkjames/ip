import java.util.Scanner;

public class Interactor {

    Operations operations;
    String exitKeyword = "";


    String doneKeyword = "";

    public Interactor() {
    }

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
        this.printGreeting();
        this.printExitKeyword();

        boolean toContinue = true;

        Scanner scanner = new Scanner(System.in);

        while (toContinue == true){
            String currentInput = scanner.nextLine();

            if (currentInput.equals(this.exitKeyword)){
                this.printGoodbye();
                break;
            }
            if (currentInput.equals("list")){
                operations.printDatabase();
                break;
            }
            // When user toggles done-ness of task
            if (beginsWith(currentInput, this.doneKeyword)){
                int i = getNumberFromInput(currentInput);
                operations.setDone(i);
                operations.printDatabase();

            }
            else{
                operations.addTaskToDatabase(currentInput);
                operations.printDatabase();
            }


            // Default case: add item to list


//            operations.addTaskToDatabase(currentInput);
//            operations.printDatabase();
        }
    }

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