package za.co.gabriel.classes.aircrafts;

import java.io.BufferedWriter;

public final class MyLogger {
    public static MyLogger logger = null;
    private List<String> aString = new ArrayList<String>();

	private MyLogger(){}

    public static MyLogger getMyLogger()
    {
        if (logger == null)
            logger = new MyLogger();
        return logger;
    }

    public void Log(String val)
    {
		this.LogConsole(val);
        aString.add(val);
    }

	public void LogConsole(String val)
	{
		System.out.println(val);
	}

    public void Print()
    {
        try
        {
            BufferedWriter x = new BufferedWriter(new FileWriter("Simulation.txt"));
            for (String s: aString)
            {
                x.write(s);
                x.write("\n");
            }
            x.close();
        } 
        catch (Exception e)
        {
            System.console().printf("%s\n", e.toString());
        }
    }
}