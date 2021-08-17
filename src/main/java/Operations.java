public class Operations {

    TaskList database;

    public Operations(){}

    public void setDatabase(TaskList database) {
        this.database = database;
    }

    public TaskList getDatabase() {
        return database;
    }

    public void addToDatabase(Task task) {
        this.database.addTask(task);
    }

    public void addToDatabase(Todo todo) {
        this.database.addTask(todo);
    }

    public void addToDatabase(Event event) {
        this.database.addTask(event);
    }

    public void addToDatabase(Deadline deadline) {
        this.database.addTask(deadline);
    }

    public void printDatabase(){
        for(int i=0; i < database.size(); i++){
            System.out.println(i +  ": " + database.getTask(i).getFormattedString());
        }
    }

    public Task getTask(int i){
        return database.getTask(i);
    }

    public void setDone(int i) {
        getTask(i).toggleDone();
    }
}
