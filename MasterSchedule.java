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
        }   
        System.out.println("Master added shift");
    }   

    public void scheduleEmployee(int day, TimeSpan shiftTime, Employee emp) throws Exception
    {
        emp.addShift(day, shiftTime, 1);
    }

    public void print()
    {
        for (int i = 0; i < 7; i++)
        {
            System.out.println("++++++++++++++++++++++");
            System.out.println("On day " + i);
            ArrayList<Object> tempList = getDayList(i); 
            for (Object span : tempList)
            {
                TimeSpan tSpan = (TimeSpan) span;  
                System.out.println("------------------");
                System.out.println(tSpan.getTimeIn());
                System.out.println(tSpan.getTimeOut());

            }
        }
    }

    public void generateSchedule(ArrayList empList)
    {
        emptyScheduledSlots();

        for (int i = 0; i < 7; i++)
        {
            ArrayList<Object> dayList = getDayList(i);
            boolean scheduleChanged = true;
            while(scheduleChanged)
            {
                scheduleChanged = false;
                for (Object tempTime : dayList)
                {
                    TimeSpan span = (TimeSpan)tempTime;
                    for (Object temp : empList)
                    {
                        if (span.isFilled())
                            break;
                        Employee tempEmp = (Employee)temp;
                        if (!tempEmp.doesShiftExist(i, span, 0) || 
                                tempEmp.doesShiftExist(i, span, 1))
                           continue; 
                        try{
                            scheduleEmployee(i, span, tempEmp);
                            scheduleChanged = true;
                            span.setFilled();
                        }catch(Exception e)
                        {
                            System.out.println("Schedule Error in Generator.");
                        }
                        
                    }
                }
            }
        }
    }

    private void emptyScheduledSlots()
    {
        for (int i = 0; i < 7; i++)
        {
            ArrayList<Object> dayList = getDayList(i);
            for (Object temp : dayList)
            {
                TimeSpan span = (TimeSpan)temp; 
                span.setEmpty();
            }
        }
    }
}
