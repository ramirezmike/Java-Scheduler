import java.util.ArrayList;
import java.util.List;

public class Main 
{
    public static void main (String[] args) 
    {

        Schedule sch1 = new Schedule();

        TimeSpan tSpan = new TimeSpan(8.40,10.30);
        TimeSpan tSpan1 = new TimeSpan(10.35,15.40);

        sch1.add(3, tSpan);
        sch1.add(3, tSpan1);

        ArrayList<Object> list = sch1.getDayList(3);
        System.out.println(list);

        sch1.remove(3, tSpan);
        System.out.println(list);
    }
}
