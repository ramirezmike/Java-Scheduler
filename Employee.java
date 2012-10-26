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
