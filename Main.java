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
        TimeSpan tSpan2 = new TimeSpan(19.60,20.60);

        emp1.addShift(3, tSpan, 0);
        emp2.addShift(3, tSpan, 0);
        emp2.removeShift(3, tSpan, 0);
        emp2.addShift(3, tSpan2, 0);
        mSch1.add(3, tSpan);

        ArrayList<Object> list = emp1.getDaySchedule(3,0); 
        System.out.println("Beginning list: " + list);

        list = emp1.getDaySchedule(3,1);
        System.out.println("Shifts:" + list);
        mSch1.generateSchedule(employeesList);
        System.out.println("Shifts:" + list);

        emp1.printSchedule();
        emp2.printSchedule();

        Setup stp = new Setup();
        stp.createEmployee(employeesList);

        System.out.println(employeesList);
    }
}
