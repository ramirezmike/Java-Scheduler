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

    public void addShift(int day, TimeSpan shiftTime, int scheduleNumber) throws Exception
    {
        Schedule temp = (Schedule)scheduleHolder.get(scheduleNumber);
        temp.add(day, shiftTime); 
    }

    public void removeShift(int day, TimeSpan shiftTime, int scheduleNumber)
    {
        Schedule temp = (Schedule)scheduleHolder.get(scheduleNumber);
        temp.remove(day, shiftTime); 
    }

    public void clearSchedule(int scheduleNumber)
    {
        Schedule temp = (Schedule)scheduleHolder.get(scheduleNumber);
        temp.clear();
    }

    public boolean doesShiftExist(int day, TimeSpan shiftTime, int scheduleNumber)
    {
        Schedule tempSch = (Schedule)scheduleHolder.get(scheduleNumber);
        ArrayList<Object> list = getDaySchedule(day,scheduleNumber);
        for (Object obj : list)
        {
            TimeSpan span = (TimeSpan) obj;
            if (tempSch.isShiftWithinShift(shiftTime, span))
                return true;
        }
        return false;
    }

    public ArrayList<Object> getDaySchedule(int day, int scheduleNumber)
    {
        Schedule temp = (Schedule)scheduleHolder.get(scheduleNumber);
        return temp.getDayList(day);
    }

    public void printSchedule()
    {
        System.out.println("----------------------------------------------");
        System.out.println(firstName + " " + lastName);
        System.out.println("[Availability]");
        System.out.println("-----------------------");
        for (int i = 0; i < 7; i++)
        {
            ArrayList<Object> tempList = getDaySchedule(i,0);
            for (Object obj : tempList)
            {
               TimeSpan span = (TimeSpan) obj; 
               System.out.println("    Shift______");
               System.out.println("        Time In : " + span.getTimeIn());
               System.out.println("        Time Out: " + span.getTimeOut());
            }
        }

        System.out.println("[Shifts Taken]");
        System.out.println("-----------------------");
        for (int i = 0; i < 7; i++)
        {
            ArrayList<Object> tempList = getDaySchedule(i,1);
            for (Object obj : tempList)
            {
               TimeSpan span = (TimeSpan) obj; 
               System.out.println("    Shift______");
               System.out.println("        Time In : " + span.getTimeIn());
               System.out.println("        Time Out: " + span.getTimeOut());
            }
        }
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
