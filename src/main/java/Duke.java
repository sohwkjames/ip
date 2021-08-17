import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {

        Operations operations = new Operations();
        Interactor interactor = new Interactor();
        TaskList taskList = new TaskList(new ArrayList<Task>());

        operations.setDatabase(taskList);
        interactor.setOperations(operations);
        interactor.setExitKeyword("bye");
        interactor.start();
    }
}
