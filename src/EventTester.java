//Carl Owen
//Lab 2
//EventTester class
//MY COMMIT HISTORY MAY NOT BE REFLECTED BECAUSE THIS IS MY SECOND REPISOTORY FOR THE LAB ASSIGNMENT
//I INITTIALLY FORGOT TO ADD THIS CLASS ASWELL AS THE ADDEVENT CLASS

import java.time.LocalDateTime;
import java.time.Duration;

public class EventTester
{

    public static void main(String[] args)
    {
        testDeadline();
        testMeeting();
        testEventComparison();
    }

    //Test the Deadline class functionality
    public static void testDeadline()
    {
        LocalDateTime deadlineTime = LocalDateTime.now().plusDays(1);
        Deadline deadline = new Deadline("Project Submission", deadlineTime);

        System.out.println("Testing Deadline:");
        System.out.println("Name: " + deadline.getName());
        System.out.println("DateTime: " + deadline.getDateTime());
        System.out.println("Is Complete: " + deadline.isComplete());

        deadline.complete();  //Marked as complete
        System.out.println("Is Complete after completing: " + deadline.isComplete());
        System.out.println();
    }

    //Test the Meeting class functionality
    public static void testMeeting() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusHours(2);
        String location = "Conference Room A";
        Meeting meeting = new Meeting("Team Meeting", start, end, location);

        System.out.println("Testing Meeting:");
        System.out.println("Name: " + meeting.getName());
        System.out.println("Start DateTime: " + meeting.getDateTime());
        System.out.println("End DateTime: " + meeting.getEndTime());
        System.out.println("Location: " + meeting.getLocation());
        System.out.println("Is Complete: " + meeting.isComplete());
        System.out.println("Duration: " + meeting.getDuration().toHours() + " hours");

        meeting.complete();  //Mark the meeting as complete
        System.out.println("Is Complete after completing: " + meeting.isComplete());
        System.out.println();
    }

    //Tests comparison between two events based on their date and time
    public static void testEventComparison()
    {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime future = LocalDateTime.now().plusDays(1);

        Deadline deadline1 = new Deadline("Submit Assignment", now.plusHours(5));
        Deadline deadline2 = new Deadline("Submit Project", future);

        System.out.println("Testing Event Comparison:");
        System.out.println("Comparing deadline1 and deadline2: " + deadline1.compareTo(deadline2));
        System.out.println("Expect negative if deadline1 is before deadline2, positive if after.");
        System.out.println();
    }
}

