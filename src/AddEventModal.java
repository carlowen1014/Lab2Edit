//Carl Owen
//Lab 2
//AddEvent class that gives you the capacity to add a specfic event by date and time
//MY COMMIT HISTORY MAY NOT BE REFLECTED BECAUSE THIS IS MY SECOND REPISOTORY FOR THE LAB ASSIGNMENT
//I INITTIALLY FORGOT TO ADD THIS CLASS ALONG WITH THE TESTER CLASS

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class AddEventModal extends JDialog
{
    private EventListPanel eventListPanel;  //ReferenceS to the EventListPanel
    private JComboBox<String> eventTypeDropDown;
    private JTextField nameField, locationField;
    private JTextField dateTimeField, endDateTimeField;

    public AddEventModal(JFrame parent, EventListPanel eventListPanel)
    {
        super(parent, "Add New Event", true);  //Set modal dialog
        this.eventListPanel = eventListPanel;

        //Layout for the dialog
        setLayout(new GridLayout(6, 2));

        //Event Type dropdown (Meeting or Deadline)
        eventTypeDropDown = new JComboBox<>(new String[]{"Deadline", "Meeting"});
        add(new JLabel("Event Type:"));
        add(eventTypeDropDown);

        //Name input
        nameField = new JTextField();
        add(new JLabel("Event Name:"));
        add(nameField);

        //Date/Time input for start (for both Deadline and Meeting)
        dateTimeField = new JTextField("2024-09-26T10:00"); //Example default value
        add(new JLabel("Date and Time (yyyy-MM-ddTHH:mm):"));
        add(dateTimeField);

        //Location input for Meeting (only visible if "Meeting" is selected)
        locationField = new JTextField();
        add(new JLabel("Location (for Meeting):"));
        add(locationField);

        //End date/time input for Meeting
        endDateTimeField = new JTextField("2024-09-26T12:00");
        add(new JLabel("End Time (for Meeting):"));
        add(endDateTimeField);

        //Button to submit the new event
        JButton submitButton = new JButton("Add Event");
        submitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                addEvent();
            }
        });
        add(submitButton);

        setSize(400, 300);
        setLocationRelativeTo(parent);  // Center the dialog relative to parent frame
    }

    //Method to add the event to the EventListPanel
    private void addEvent()
    {
        String eventType = (String) eventTypeDropDown.getSelectedItem();
        String name = nameField.getText();
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeField.getText());

        if ("Deadline".equals(eventType))
        {
            Deadline deadline = new Deadline(name, dateTime);
            eventListPanel.addEvent(deadline);  //Add Deadline event to EventListPanel
        } else if ("Meeting".equals(eventType))
        {
            LocalDateTime endDateTime = LocalDateTime.parse(endDateTimeField.getText());
            String location = locationField.getText();
            Meeting meeting = new Meeting(name, dateTime, endDateTime, location);
            eventListPanel.addEvent(meeting);  //Add Meeting event to EventListPanel
        }

        dispose();  //Close dialog
    }
}
