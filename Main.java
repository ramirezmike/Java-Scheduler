import java.util.ArrayList;
import java.util.List;

public class Main 
{
    public static void main (String[] args) 
    {
        ArrayList<Object> employeesList = new ArrayList<Object>(2);

        Employee emp1 = new Employee("Michael", "Ramirez", 30, 40);
        Employee emp2 = new Employee("Krystal", "Ramirez", 30, 40);
        employeesList.add(emp1);
        employeesList.add(emp2);
        MasterSchedule mSch1 = new MasterSchedule();

        TimeSpan tSpan = new TimeSpan(9.60,10.60);

        emp1.addAvailability(3, tSpan);
        mSch1.add(3, tSpan);

        ArrayList<Object> list = emp1.getAvailabilityOnDay(3); 
        System.out.println("Begining list: " + list);

        list = emp1.getShiftsOnDay(3);
        System.out.println("Shifts:" + list);
        mSch1.generateSchedule(employeesList);
        System.out.println("Shifts:" + list);
    }
}
