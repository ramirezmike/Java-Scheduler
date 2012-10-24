public class TimeSpan
{
    private double timeIn;
    private double timeOut;
    
    public TimeSpan(double tIn, double tOut)
    {
        setTime(tIn, tOut);
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
