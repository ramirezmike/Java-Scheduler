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
    
    public void add(int day, TimeSpan shiftTime)
    {
        if (shiftExists())
        {
            ArrayList<Object> tempList = getDayList(day);
            tempList.add(shiftTime);
            for (Object span : tempList)
            {
                TimeSpan temp = (TimeSpan)span;
                System.out.println(temp.getTimeIn());
                System.out.println(temp.getTimeOut());
            }
        }
    }

    public void remove()
    {
        System.out.println("Removed shift");
    }

    public void clear()
    {
        System.out.println("Cleared shift");
    }

    public ArrayList<Object> getDayList(int day)
    {
        return schList.get(day);
    }
    
    private boolean shiftExists()
    {
        System.out.println("ShiftExists");
        return true;
    }
}
