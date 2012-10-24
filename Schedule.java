import java.util.ArrayList;
import java.util.List;

public class Schedule 
{
    public int derp;
    private int[] scheduleArray = new int[7];
    private ArrayList<ArrayList<Object>> schList = new ArrayList<ArrayList<Object>>(7);
    private int herp;

    public Schedule()
    {
        for (int i = 0;i<7;i++)
        {
            schList.add(new ArrayList<Object>());
        }

        System.out.println(schList.size());

        ArrayList<Object> temp2 = schList.get(1);
        temp2.add("Tuesday");
        temp2.add(34.2 + 50);
        temp2.set(1,(Double)temp2.get(1) + 50);
        System.out.println(schList.get(1).get(0));
        System.out.println(schList.get(1).get(1));
        System.out.println(schList);
    }
    
    public void add()
    {
        System.out.println("Added shift");
        shiftExists();
    }

    public void remove()
    {
        System.out.println("Removed shift");
    }

    public void clear()
    {
        System.out.println("Cleared shift");
    }

    private boolean shiftExists()
    {
        System.out.println("ShiftExists");
        return true;
    }
}
