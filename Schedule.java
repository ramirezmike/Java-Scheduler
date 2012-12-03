import java.util.ArrayList;
import java.util.List;

public class Schedule 
{
    private ArrayList<ArrayList<Object>> schList = new ArrayList<ArrayList<Object>>(7);

    public Schedule()
    {
        for (int i = 0;i<7;i++)
        {
            schList.add(new ArrayList<Object>());
        }
    }
    
    public void add(int day, TimeSpan shiftTime) throws Exception
    {
        ArrayList<Object> tempList = getDayList(day);
        if (!shiftExists(shiftTime, tempList))
        {
            tempList.add(shiftTime);
            for (Object span : tempList)
            {
                TimeSpan temp = (TimeSpan)span;
            }
        }
        else
        {
            System.out.println("Shift exists");
            throw new Exception();
        }
    }

    public void remove(int day, TimeSpan shiftTime)
    {
        ArrayList<Object> tempList = getDayList(day);
        tempList.remove(shiftTime);
        System.out.println("Removed shift");
    }

    public void clear()
    {
        for (int i = 0; i < 7; i++)
        {
            ArrayList<Object> dayList = getDayList(i);
            ArrayList<Object> tempList = new ArrayList<Object>(dayList);
            for (Object obj : tempList)
            {
                TimeSpan span = (TimeSpan) obj;
                dayList.remove(span);
            }
        }

    }

// following may be removed if there's 
// no need for public access to schedule
    public ArrayList<Object> getDayList(int day)     
    {
        return schList.get(day);
    }

    public boolean isShiftWithinShift(TimeSpan shiftOne, TimeSpan shiftTwo)
    {
       return (shiftOne.getTimeIn() >= shiftTwo.getTimeIn() && shiftOne.getTimeOut() <= shiftTwo.getTimeOut()); 
    }
    
    private boolean shiftExists(TimeSpan shiftTime, ArrayList<Object>dayList)
    {
        if (dayList.isEmpty())         
        {
            System.out.println("Daylist is empty");
            return false;
        }
        for (Object span : dayList)
        {
            TimeSpan tempSpan = (TimeSpan)span;
            if (doShiftsOverlap(shiftTime,tempSpan) || doShiftsOverlap(tempSpan,shiftTime)) 
            {
                System.out.println("Two shifts are overlapping");
                return true;
            }
        }
        return false;
    }
    
    private boolean doShiftsOverlap(TimeSpan shiftOne, TimeSpan shiftTwo)
    {
       if (shiftOne.getTimeIn() >= shiftTwo.getTimeIn() && shiftOne.getTimeIn() <= shiftTwo.getTimeOut()) 
            return true;
       else if (shiftOne.getTimeOut() <= shiftTwo.getTimeOut() && shiftOne.getTimeOut() >= shiftTwo.getTimeIn())
            return true;
       else
            return false;
    }
}
