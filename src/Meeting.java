//Carl Owen
//Lab 2
//Meeting Class another sub-class of Event that represents the start and end times

import java.time.LocalDateTime;
import java.time.Duration;

public class Meeting extends Event implements Completable
{
    //endDateTime: when the meeting ends
    private LocalDateTime endDateTime;

    //Location: where the meeting takes place
    private String location;

    //Complete, as true if the meeting is complete, false otherwise
    private boolean complete;

    //Constructor: creates a Meeting event
    public Meeting(String name, LocalDateTime start, LocalDateTime end, String location)
    {
        super(name, start);  // Calls the Event constructor for start time
        this.endDateTime = end;  // Sets the meeting's end time
        this.location = location;  // Sets the meeting location
        this.complete = false;  // Initially, the meeting is not completed
    }

    //Marks the meeting as complete
    @Override
    public void complete()
    {
        this.complete = true;
    }

    //Returns true if the meeting is complete
    @Override
    public boolean isComplete()
    {
        return this.complete;
    }

    //Returns the end time of the meeting
    public LocalDateTime getEndTime()
    {
        return endDateTime;
    }

    //Updates the end time of the meeting
    public void setEndTime(LocalDateTime end)
    {
        this.endDateTime = end;
    }

    //Returns the location of the meeting
    public String getLocation()
    {
        return location;
    }

    //Updates the location of the meeting
    public void setLocation(String location)
    {
        this.location = location;
    }

    //Returns the duration of the meeting (from start to end)
    public Duration getDuration()
    {
        return Duration.between(super.getDateTime(), endDateTime);
    }

    //Returns the type of event (used in the GUI for display)
    @Override
    public String getEventType()
    {
        return "Meeting";
    }
}

