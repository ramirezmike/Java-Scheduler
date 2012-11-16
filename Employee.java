import java.util.ArrayList;
import java.util.List;

public class Employee 
{
    private Schedule availability;    
    private Schedule requestsOff;    
    private Schedule shiftsTaken;    
    private String firstName;
    private String lastName;
    private int maxHrs;
    private int minHrs;
    private int currentHrs;

    public Employee(String fName,String lName,int maxH,int minH)
    {
        firstName = fName;
        lastName = lName;
        maxHrs = maxH;
        minHrs = minH;

        availability = new Schedule();
        requestsOff = new Schedule();
        shiftsTaken = new Schedule();
    }

    public void addAvailability(int day, TimeSpan shiftTime)
    {
       availability.add(day, shiftTime); 
    }

    public void removeAvailability(int day, TimeSpan shiftTime)
    {
        availability.remove(day, shiftTime);
    }

    public boolean isAvailable(int day, TimeSpan shiftTime)
    {
        ArrayList<Object> availabilityOnDayList = getAvailabilityOnDay(day);
        for (Object obj : availabilityOnDayList)
        {
            TimeSpan span = (TimeSpan) obj;
            if (availability.isShiftWithinShift(shiftTime, span))
                return true;
        }
        return false;
    }

    public boolean isCurrentlyWorking(int day, TimeSpan shiftTime)
    {
        ArrayList<Object> shiftsTakenOnDayList = getShiftsOnDay(day);
        for (Object obj : shiftsTakenOnDayList)
        {
            TimeSpan span = (TimeSpan) obj;
            if (shiftsTaken.isShiftWithinShift(shiftTime, span))
                return true;
        }
        return false;
    }

    public ArrayList<Object> getAvailabilityOnDay(int day)
    {
        return availability.getDayList(day);
    }

    public void addRequest(int day, TimeSpan shiftTime)
    {
       requestsOff.add(day, shiftTime); 
    }

    public void addShiftTaken(int day, TimeSpan shiftTime)
    {
       shiftsTaken.add(day, shiftTime); 
    }
    
    public ArrayList<Object> getShiftsOnDay(int day)
    {
        return shiftsTaken.getDayList(day);
    }

// following 3 functions aren't functional yet.
    private boolean isOverMaxHrs()
    {
        return true;
    }

    private boolean isOverMinHrs()
    {
        return true;
    }

    public boolean doesShiftConflict(int day, TimeSpan shiftTime)
    {
        ArrayList<Object> shiftsOnDay = shiftsTaken.getDayList(day);     
        return true;
    }
    
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public int getMaxHrs()
    {
        return maxHrs;
    }

    public int getMinHrs()
    {
        return minHrs;
    }
}
