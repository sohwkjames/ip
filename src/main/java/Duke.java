public class Duke {
    public static void main(String[] args) {

        Operations operations = new Operations();
        Interactor interactor = new Interactor();
        interactor.setOperations(operations);
        interactor.setExitKeyword("bye");
        interactor.start();


    }
}
