import java.util.Scanner;

public class Interactor {
    public Interactor() {
    }
    Operations operations;

    public void setOperations(Operations operations) {
        this.operations = operations;
    }

    public void start(String exitOn){
        String message = String.format("Please type %s if you want to exit.", exitOn);
        Scanner scanner = new Scanner(System.in);
        while (true){
            String currentInput = scanner.nextLine();
            if (currentInput == exitOn){
                break;
            }
            String result = this.operations.echo(currentInput);
            System.out.println(result);
        }
    }
}
