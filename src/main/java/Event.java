public class Event extends Deadline{
    String symbol = "[E]";
    String endTime = "";

    public Event() {
    }

    @Override
    public String getEndTime() {
        return endTime;
    }

    @Override
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
