import java.util.ArrayList;
import java.util.List;

public class MasterSchedule extends Schedule 
{
    public void add(int day, TimeSpan shiftTime)
    {   
        ArrayList<Object> tempList = getDayList(day);
        tempList.add(shiftTime);
        for (Object span : tempList)
        {   
            TimeSpan temp = (TimeSpan)span;
            System.out.println(temp.getTimeIn());
            System.out.println(temp.getTimeOut());
        }   
        System.out.println("Master added shift");
    }   

    public void scheduleEmployee(int day, TimeSpan shiftTime, Employee emp)
    {
        
    }
}
