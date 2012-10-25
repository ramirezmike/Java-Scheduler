public class TimeSpan
{
    private double timeIn;
    private double timeOut;
    private String position;
    private Employee scheduledEmp;
    
    public TimeSpan(double tIn, double tOut)
    {
        setTime(tIn, tOut);
    }

    public TimeSpan(double tIn, double tOut, String pos)
    {
        setTime(tIn, tOut);
        setPosition(pos);
    }

    public void setTime(double tIn, double tOut)
    {
        if (checkTimes(tIn, tOut))
        {
            timeIn = tIn;
            timeOut = tOut;
        }
        else
            System.out.println("Time in < Time Out");// implement error throw
    }

    public void setPosition(String pos)
    {
        position = pos;
    }

    public String getPosition()
    {
        return position;
    }
        
    public double getTimeIn()
    {
        return timeIn;
    }

    public double getTimeOut()
    {
        return timeOut;
    }

    private boolean checkTimes(double tIn, double tOut)
    {
       return (tIn < tOut); 
    }
}
