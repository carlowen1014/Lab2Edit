import java.time.LocalDateTime;

public abstract class Event implements Comparable<Event> {
    // name: the name of the event (like "Meeting" or "Deadline")
    private String name;

    // dateTime: when the event starts
    private LocalDateTime dateTime;

    // Constructor to initialize an event with a name and a starting time
    public Event(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    // Getter for the event name
    public String getName() {
        return name;
    }

    // Getter for the event start time
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    // Setter to update the start time of the event
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    // Setter to update the name of the event
    public void setName(String name) {
        this.name = name;
    }

    // This compares two events by their dateTime, to sort them
    @Override
    public int compareTo(Event e) {
        return this.dateTime.compareTo(e.getDateTime());
    }

    // Abstract method that will be implemented in subclasses (Deadline, Meeting)
    public abstract String getEventType();
}

