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
    }
}
