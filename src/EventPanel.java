import java.time.LocalDateTime;
import javax.swing.*;
import java.awt.*;

public class EventPanel extends JPanel {
    private Event event;  // The event to display
    private JButton completeButton;  // Button to mark an event as complete

    // Constructor: creates a panel for an event
    public EventPanel(Event event) {
        this.event = event;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  // Vertical layout for labels

        // Display the event's name and start time
        JLabel nameLabel = new JLabel("Name: " + event.getName());
        JLabel dateTimeLabel = new JLabel("Date: " + event.getDateTime());
        add(nameLabel);
        add(dateTimeLabel);

        // If the event is a meeting, display the location and duration
        if (event instanceof Meeting) {
            Meeting meeting = (Meeting) event;
            JLabel locationLabel = new JLabel("Location: " + meeting.getLocation());
            JLabel durationLabel = new JLabel("Duration: " + meeting.getDuration().toMinutes() + " minutes");
            add(locationLabel);
            add(durationLabel);
        }

        // If the event can be completed (e.g., Deadline or Meeting), show the complete button
        if (event instanceof Completable) {
            Completable completableEvent = (Completable) event;
            completeButton = new JButton("Complete");
            completeButton.addActionListener(e -> {
                completableEvent.complete();  // Marks the event as complete
                completeButton.setEnabled(false);  // Disable the button after completion
            });
            add(completeButton);
        }

        updateUrgency();  // Set the background color based on the event's urgency
    }

    // Sets the background color based on how close or overdue the event is
    public void updateUrgency() {
        if (event.getDateTime().isBefore(LocalDateTime.now())) {
            setBackground(Color.RED);  // Red for overdue events
        } else if (event.getDateTime().isBefore(LocalDateTime.now().plusHours(1))) {
            setBackground(Color.YELLOW);  // Yellow for imminent events
        } else {
            setBackground(Color.GREEN);  // Green for distant events
        }
    }
}
