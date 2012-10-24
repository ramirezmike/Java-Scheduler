public class Main 
{
    public static void main (String[] args) 
    {
        Schedule sch1 = new Schedule();

        TimeSpan tSpan = new TimeSpan(8.40,10.30);
        TimeSpan tSpan1 = new TimeSpan(10.30,15.40);
        sch1.add(3, tSpan1);
        sch1.add(3, tSpan);
    }
}
