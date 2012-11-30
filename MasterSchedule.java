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
        emp.addShift(day, shiftTime, 1);
       //need to add mark to shift taken in master sch
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
                        Employee tempEmp = (Employee)temp;
                        System.out.println(tempEmp.getFirstName());
                        if (tempEmp.doesShiftExist(i, span, 0) && 
                                !tempEmp.doesShiftExist(i,span, 1))
                        {
                            scheduleEmployee(i, span, tempEmp);
                            System.out.println("Scheduled that shit..");
                            scheduleChanged = true;
                        }
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
