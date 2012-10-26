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
        if (inBeforeOut(tIn, tOut))
        {
            timeIn = timeCheck(tIn);
            timeOut = timeCheck(tOut);
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

    private double timeCheck(double time)
    {
        int timeInt = (int) time;
        double tempTime = time - timeInt; 
        System.out.println(tempTime);
        if (tempTime > 0.59)
            time = timeInt + 1;
        if (time > 24 || time < 0)
            time = 0;
        return time;
    }

    private boolean inBeforeOut(double tIn, double tOut)
    {
       return (tIn < tOut); 
    }
}
