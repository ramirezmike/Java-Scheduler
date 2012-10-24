public class Main 
{
    public static void main (String[] args) 
    {
        Employee Emp = new Employee("mike", "ramirez", 20, 40);
        System.out.println(Emp.getFirstName());
        Schedule schOne = new Schedule();
        MasterSchedule master = new MasterSchedule();
        schOne.derp = 6;
        System.out.println(schOne.derp);
        schOne.add();
        master.derp = 9;
        System.out.println(master.derp);
        master.add();

        TimeSpan time = new TimeSpan(50, 60);
        System.out.println(time.getTimeIn());

        TimeSpan time2 = new TimeSpan(50, 60, "BOH");
        System.out.println(time2.getTimeIn());
        System.out.println(time2.getPosition());
    }
}
