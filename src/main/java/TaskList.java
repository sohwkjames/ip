import java.util.ArrayList;
public class TaskList {

    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean addTask(Task task){
        this.tasks.add(task);
        return true;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void printAllTasks(){
        System.out.println(this.tasks);
    }
}
