import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Setup
{
    public void createEmployees(ArrayList<Object> empList)
    {
        String prompt = "How many employees do you want to add?";
        int numberOfEmps = Integer.parseInt(getInput(prompt));
        for (int i = 0; i < numberOfEmps; i++)
        {
            System.out.println("Employee Number " + i);
            System.out.println("-----------------------");
            try{
                empList.add(makeEmp());
            }catch(Exception e){
                System.out.println("Employee wasn't properly entered.");
            }
        }
    }

    public void removeEmployee(ArrayList<Object> empList)
    {
        // if no employees, need to return or something
        printEmployees(empList);          
        String prompt = "Which employee would you like to remove?";
        int empChoice = Integer.parseInt(getInput(prompt));
        empList.remove(empChoice);
    }

    public void clearEmpSchedule(ArrayList<Object> empList)
    {
        printEmployees(empList);          
        String prompt = "Which employee?";
        int empChoice = Integer.parseInt(getInput(prompt));
        System.out.println("0 Availability 1 Shift 2 Request");
        int schChoice = Integer.parseInt(getInput("What kind of shift?"));

        Employee emp = (Employee) empList.get(empChoice);
        emp.clearSchedule(schChoice);
        System.out.println("Schedule cleared.");
    }

    public void addMasterShift(MasterSchedule mSch)
    {
        System.out.println("0 Mon 1 Tue 2 Wed 3 Thr 4 Fri 5 Sat 6 Sun");
        int day = Integer.parseInt(getInput("Which day?"));
        float start = Float.parseFloat(getInput("Start time?"));
        float end = Float.parseFloat(getInput("End time?"));

        TimeSpan tSpan = new TimeSpan(start, end);
        mSch.add(day, tSpan);
    }

    public void addToEmpSchedule(ArrayList<Object> empList)
    {
        printEmployees(empList);        
        int empChoice = Integer.parseInt(getInput("Which employee?"));
        System.out.println("0 Availability 1 Shift 2 Request");
        int schChoice = Integer.parseInt(getInput("What kind of shift?"));
        System.out.println("0 Mon 1 Tue 2 Wed 3 Thr 4 Fri 5 Sat 6 Sun");
        int day = Integer.parseInt(getInput("Which day?"));
        float start = Float.parseFloat(getInput("Start time?"));
        float end = Float.parseFloat(getInput("End time?"));

        TimeSpan tSpan = new TimeSpan(start, end);
        Employee emp = (Employee) empList.get(empChoice);
        try{
            emp.addShift(day, tSpan, schChoice);
        }catch(Exception e){System.out.println("Schedule Error in addToEmpSchedule.");}
    }

    public void removeFromEmpSchedule(ArrayList<Object> empList)
    {
        printEmployees(empList);        
        int empChoice = Integer.parseInt(getInput("Which employee?"));
        System.out.println("0 Availability 1 Shift 2 Request");
        int schChoice = Integer.parseInt(getInput("What kind of shift?"));
        System.out.println("0 Mon 1 Tue 2 Wed 3 Thr 4 Fri 5 Sat 6 Sun");
        int day = Integer.parseInt(getInput("Which day?"));

        Employee emp = (Employee) empList.get(empChoice);
        ArrayList<Object> list = emp.getDaySchedule(day, schChoice);
        int i = 0;
        for (Object obj : list)
        {
            TimeSpan tSpan = (TimeSpan) obj;  
            System.out.println("+++++++++++++++++++++");
            System.out.print("Shift " + i + "    ");
            System.out.print(tSpan.getTimeIn() + "    ");
            System.out.println(tSpan.getTimeOut());
            i++;
        }
        int shiftSelection = Integer.parseInt(getInput("Remove which shift?"));
        TimeSpan span = (TimeSpan)list.get(shiftSelection);
        emp.removeShift(day, span, schChoice);
    }

    public void printEmployees(ArrayList<Object> empList)
    {
        int i = 0;
        for (Object obj : empList)
        {
            Employee emp = (Employee)obj;
    //        System.out.println(i + " " + emp.getFirstName() + " " + emp.getLastName());
            System.out.print("EMPLOYEE #" + i);
            emp.printSchedule();
            i++;
        }
    }

    private Employee makeEmp()
    {
        String prompt = "What is the employee's First Name?"; 
        String fn = getInput(prompt);
        prompt = "What is the employee's Last Name?"; 
        String ln = getInput(prompt);
        prompt = "What is the employee's Min Hrs?"; 
        int mn = Integer.parseInt(getInput(prompt));
        prompt = "What is the employee's Max Hrs?"; 
        int mx = Integer.parseInt(getInput(prompt));

        Employee emp = new Employee(fn, ln, mn, mx);
        return emp;
    }

    public void printOptions(int menu)
    {
        switch(menu)
        {
            case 0:
                System.out.println("---Master Schedule Menu---");
                System.out.println("These are your options:");
                System.out.println("0 Generate Schedule");
                System.out.println("1 Print Master Schedule");
                System.out.println("2 Add Shift to Master Schedule");
                break;
            case 1:
                System.out.println("---Employee Menu---");
                System.out.println("These are your options:");
                System.out.println("0 Add Emp");
                System.out.println("1 Add Sch to Emp");
                System.out.println("2 Print Emp List");
                System.out.println("3 Remove Sch from Emp");
                System.out.println("4 Remove Employee");
                System.out.println("5 Clear Schedule");
                System.out.println("100 Exit");
                break;
            default:
                break;
        }
    }

    public String getInput(String prompt)
    {
        String input = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
            input = line.readLine();
            if (input.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return input;
    }

    public void clearScreen()
    {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
