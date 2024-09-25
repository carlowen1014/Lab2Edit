//Carl Owen
//Lab 2
//EventListPanel class that holds multiple events in GUI

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EventListPanel extends JPanel
{
    private ArrayList<Event> events;  //List to hold events

    public EventListPanel()
    {
        events = new ArrayList<>();  //Initialize the events list
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  // Use vertical layout
    }

    //Method to add an event to the list and the panel
    public void addEvent(Event event)
    {
        events.add(event);  //Adds event to the list

        //Creates an EventPanel for the new event and add it to this panel
        EventPanel eventPanel = new EventPanel(event);
        this.add(eventPanel);  //Adds the EventPanel to the EventListPanel
        this.revalidate();  //Refreshes the layout to show the new event
        this.repaint();     //Repaints to update the visual display
    }

    //Other methods to display, sort, or filter events can be added here
}

