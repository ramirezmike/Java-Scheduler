import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Setup
{
    public void createEmployees(ArrayList<Object> empList)
    {
        String prompt = "How many employees do you have?";
        int numberOfEmps = Integer.parseInt(getInput(prompt));
        for (int i = 0; i < numberOfEmps; i++)
        {
            System.out.println("Employee Number " + i);
            System.out.println("-----------------------");
            empList.add(makeEmp());
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

    public void printOptions()
    {
        System.out.println("These are your options:");
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
}
