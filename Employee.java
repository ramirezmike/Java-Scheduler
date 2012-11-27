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
    private ArrayList<Object> scheduleHolder = new ArrayList<Object>(3);

    public Employee(String fName,String lName,int maxH,int minH)
    {
        firstName = fName;
        lastName = lName;
        maxHrs = maxH;
        minHrs = minH;

        availability = new Schedule();
        shiftsTaken = new Schedule();
        requestsOff = new Schedule();

        scheduleHolder.add(availability); //0
        scheduleHolder.add(shiftsTaken);  //1
        scheduleHolder.add(requestsOff);  //2
    }

    public void addShift(int day, TimeSpan shiftTime, int scheduleNumber)
    {
        Schedule temp = (Schedule)scheduleHolder.get(scheduleNumber);
        temp.add(day, shiftTime); 
        ArrayList<Object> list = temp.getDayList(day);
        System.out.println("Add. This is the " + scheduleNumber +" test: " + list);
    }

    public void removeShift(int day, TimeSpan shiftTime, int scheduleNumber)
    {
        Schedule temp = (Schedule)scheduleHolder.get(scheduleNumber);
        temp.remove(day, shiftTime); 
        ArrayList<Object> list = temp.getDayList(day);
        System.out.println("Remove. This is the " + scheduleNumber +" test: " + list);
    }

    public boolean doesShiftExist(int day, TimeSpan shiftTime, int scheduleNumber)
    {
        return true; 
    }

    public boolean isAvailable(int day, TimeSpan shiftTime)
    {
        ArrayList<Object> availabilityOnDayList = getDaySchedule(day,0);
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
        ArrayList<Object> shiftsTakenOnDayList = getDaySchedule(day,1);
        for (Object obj : shiftsTakenOnDayList)
        {
            TimeSpan span = (TimeSpan) obj;
            if (shiftsTaken.isShiftWithinShift(shiftTime, span))
                return true;
        }
        return false;
    }


    public ArrayList<Object> getDaySchedule(int day, int scheduleNumber)
    {
        Schedule temp = (Schedule)scheduleHolder.get(scheduleNumber);
        return temp.getDayList(day);
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
