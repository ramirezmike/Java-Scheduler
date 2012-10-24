public class Main 
{
    public static void main (String[] args) 
    {
        MasterSchedule master = new MasterSchedule();

        TimeSpan tSpan = new TimeSpan(30,40);
        master.add(3,tSpan);
    }
}
