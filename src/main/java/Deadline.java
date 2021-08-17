public class Deadline extends Task{
    String symbol = "[D]";
    String endTime;

    public Deadline(String endTime) {
        this.endTime = endTime;
    }

    public Deadline(boolean isDone, String description, String endTime) {
        super(isDone, description);
        this.endTime = endTime;
    }

    public Deadline() {

    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
