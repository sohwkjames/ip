public class Duke {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        Operations operations = new Operations();
        Interactor interactor = new Interactor();
        interactor.setOperations(operations);

        greeter.printGreeting();
        interactor.start("bye");
        greeter.printGoodbye();


    }
}
