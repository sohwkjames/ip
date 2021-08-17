public class Operations {
    TaskList database;
    public Operations(){

    }

    public TaskList getDatabase() {
        return database;
    }

    public void setDatabase(TaskList database) {
        this.database = database;
    }

    public boolean addTaskToDatabase(String message) {
        Task task = stringToTask(message);
        database.addTask(task);
        return true;
    }

    public Task stringToTask(String message) {
        Task task = new Task(false, message);
        return task;
    }

    public void printDatabase(){
        System.out.println(database);
    }
}
