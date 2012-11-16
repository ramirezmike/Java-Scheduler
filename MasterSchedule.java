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
       emp.addShiftTaken(day, shiftTime); 
       //need to add mark to shift taken in master sch
    }

    public void generateSchedule(ArrayList empList)
    {
        ArrayList<Object> dayList = getDayList(3);
        boolean scheduleChanged = true;
        while(scheduleChanged)
        {
            scheduleChanged = false;
            for (Object tempTime : dayList)
            {
                TimeSpan span = (TimeSpan)tempTime;
                for (Object temp : empList)
                {
                    Employee tempEmp = (Employee)temp;
                    System.out.println(tempEmp.getFirstName());
                    if (tempEmp.isAvailable(3, span) && 
                            !tempEmp.isCurrentlyWorking(3,span))
                    {
                        scheduleEmployee(3, span, tempEmp);
                        scheduleChanged = true;
                    }
                }
            }
        }


        // Following is an outline of function idea
        /*
        boolean changes = true;
        while(changes)
        {
            changes = false;
            foreach(Employee e in employee)
                if(e is free)
                {
                    scheduleEmployee(e);
                    changes = true;
                }
        }
        */
    }
}
