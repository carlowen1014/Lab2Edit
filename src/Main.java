//Carl Owen
//Lab 2
//Main Class Event Planner GUI
import javax.swing.*;

public class EventPlanner {
    // The main method that runs the application
    public static void main(String[] args) {
        // Create the main window (JFrame)
        JFrame frame = new JFrame("Event Planner");

        // Create the EventListPanel and add it to the frame
        EventListPanel eventListPanel = new EventListPanel();
        addDefaultEvents(eventListPanel); // Adds some sample events

        // Set frame settings
        frame.add(eventListPanel);  // Add the event list to the window
        frame.setSize(600, 400);  // Set window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the app when the window is closed
        frame.setVisible(true);  // Make the window visible
    }

    // Adds some default events to show in the event panel
    public static void addDefaultEvents(EventListPanel eventListPanel) {
        LocalDateTime deadlineTime = LocalDateTime.now().plusDays(1);
        Deadline deadline = new Deadline("Project Submission", deadlineTime);

        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusHours(2);
        Meeting meeting = new Meeting("Team Meeting", start, end, "Conference Room A");

        eventListPanel.addEvent(deadline);  // Add the deadline event to the list
        eventListPanel.addEvent(meeting);  // Add the meeting event to the list
    }
}
