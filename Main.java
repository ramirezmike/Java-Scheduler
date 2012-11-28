import java.util.ArrayList;
import java.util.List;

public class Main 
{
    public static void main (String[] args) 
    {
        ArrayList<Object> employeesList = new ArrayList<Object>();

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

        boolean running = true;
        Setup stp = new Setup();
        while (running)
        {
            stp.printOptions();
            int choice = Integer.parseInt(stp.getInput("What do you want to do?"));
            switch(choice)
            {
                case 0:
                    stp.createEmployees(employeesList);
                    System.out.println(employeesList);
                    break;
                case 100:
                    running = false;
                    break;
                default:
                    System.out.println("Please choose an option.");
                    break;
            }
        }
    }
}
