public class Main 
{
    public static void main (String[] args) 
    {
        Schedule schOne = new Schedule();
        MasterSchedule master = new MasterSchedule();
        schOne.derp = 6;
        System.out.println(schOne.derp);
        schOne.add();
        master.derp = 9;
        System.out.println(master.derp);
        master.add();
    }
}
