import java.time.LocalDateTime;

public class Deadline extends Event implements Completable {
    // complete: true if the deadline is completed, false otherwise
    private boolean complete;

    // Constructor: creates a Deadline event
    public Deadline(String name, LocalDateTime deadline) {
        super(name, deadline); // Calls the Event constructor
        this.complete = false;  // Initially, the deadline is not completed
    }

    // Marks the deadline as complete
    @Override
    public void complete() {
        this.complete = true;
    }

    // Returns true if the deadline is complete, false otherwise
    @Override
    public boolean isComplete() {
        return this.complete;
    }

    // Returns the type of event (used in the GUI for display)
    @Override
    public String getEventType() {
        return "Deadline";
    }
}
