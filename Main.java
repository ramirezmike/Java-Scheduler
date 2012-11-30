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
        boolean retry = true;
        String continueString = "";
        Setup stp = new Setup();
        while (running)
        {
            stp.clearScreen();
            System.out.println("---Main Menu---");
            System.out.print("0 Master Schedule Menu ");
            System.out.print("1 Employee Menu "); 
            System.out.println("100 Exit"); 
            // this needs a try block
            int choice; 
            try{
                choice = Integer.parseInt(stp.getInput("What do you want to do?"));
            }catch(Exception e){
                continue;
            }
            stp.clearScreen();
            stp.printOptions(choice);
            switch(choice)
            {
                case 0:
                    retry = true;
                    while (retry)
                    {
                        try{
                            choice = Integer.parseInt(stp.getInput("What do you want to do?"));
                        }catch(Exception e){
                            System.out.println("Please enter a digit corresponding to the menu."); 
                            continue;
                        }
                        switch(choice)
                        {
                            case 0:
                                stp.clearScreen();
                                mSch1.generateSchedule(employeesList);
                                retry = false;
                                continueString = stp.getInput("Enter anything to continue..");
                                break;
                            case 1:
                                stp.clearScreen();
                                mSch1.print();
                                retry = false;
                                continueString = stp.getInput("Enter anything to continue..");
                                break;
                            case 2:
                                stp.clearScreen();
                                stp.addMasterShift(mSch1);
                                retry = false;
                                continueString = stp.getInput("Enter anything to continue..");
                                break;
                            case 100:
                                retry = false;
                                break;
                            default:
                                System.out.println("Please choose an option.");
                                break;
                        }
                    }
                    break;
                case 1:
                    retry = true;
                    while (retry)
                    {
                        try{
                            choice = Integer.parseInt(stp.getInput("What do you want to do?"));
                        }catch(Exception e){
                            System.out.println("Please enter a digit corresponding to the menu.");  
                            continue;
                        }
                        switch(choice)
                        {
                            case 0:
                                stp.clearScreen();
                                stp.createEmployees(employeesList);
                                System.out.println(employeesList);
                                retry = false;
                                continueString = stp.getInput("Enter anything to continue..");
                                break;
                            case 1:
                                stp.clearScreen();
                                stp.addToEmpSchedule(employeesList);
                                retry = false;
                                continueString = stp.getInput("Enter anything to continue..");
                                break;
                            case 2:
                                stp.clearScreen();
                                stp.printEmployees(employeesList);
                                retry = false;
                                continueString = stp.getInput("Enter anything to continue..");
                                break;
                            case 3:
                                stp.clearScreen();
                                stp.removeFromEmpSchedule(employeesList);
                                retry = false;
                                continueString = stp.getInput("Enter anything to continue..");
                                break;
                            case 4:
                                stp.clearScreen();
                                stp.removeEmployee(employeesList);
                                retry = false;
                                continueString = stp.getInput("Enter anything to continue..");
                                break;
                            case 100:
                                retry = false;
                                break;
                            default:
                                System.out.println("Please choose an option.");
                                break;
                        }
                    }
                    break;
                case 100:
                    running = false;
                    break;
                default:
                    break;
            }
        }
    }
}
