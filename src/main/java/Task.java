public class Task {
    boolean isDone;
    String description;

    public Task() {
    }

    public Task(boolean isDone, String description) {
        this.isDone = isDone;
        this.description = description;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getDescription() {
        return description;
    }

}
