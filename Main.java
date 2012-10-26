import java.util.ArrayList;
import java.util.List;

public class Main 
{
    public static void main (String[] args) 
    {
        Employee emp1 = new Employee("Michael", "Ramirez", 30, 40);

        TimeSpan tSpan = new TimeSpan(99.60,10.30);
        TimeSpan tSpan1 = new TimeSpan(10.35,15.40);

        emp1.addAvailability(3, tSpan);
        emp1.addAvailability(3, tSpan1);

        ArrayList<Object> list = emp1.getAvailabilityOnDay(3); 
        System.out.println(list);

        emp1.removeAvailability(3, tSpan);
        System.out.println(list);
    }
}
