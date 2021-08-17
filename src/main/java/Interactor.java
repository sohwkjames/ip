import java.util.Scanner;

public class Interactor {

    Operations operations;
    String exitKeyword;

    public Interactor() {
    }

    public void setOperations(Operations operations) {
        this.operations = operations;
    }

    public void setExitKeyword(String exitKeyword){
        this.exitKeyword = exitKeyword;
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
            operations.addTaskToDatabase(currentInput);
            operations.printDatabase();
        }
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