package com.gabriel.classes.aircraft;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public final class MyLogger {
    public static MyLogger logger = null;
//    private List<String> aString = new ArrayList<String>();

	private MyLogger(){}

    public static MyLogger getMyLogger()
    {
        if (logger == null)
            logger = new MyLogger();
        return logger;
    }

    public void Log(String val) {
        try {
            FileWriter logWriter = new FileWriter("Simulation.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(logWriter);
            bufferedWriter.write(val + "\n");
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Log file was not found");
        } catch (IOException e) {
            System.out.println("Unable to write to log file");
            System.exit(2);

        }
    }

//	public void LogConsole(String val)
//	{
//		System.out.println(val);
//	}
//
//    public void Print()
//    {
//        try
//        {
//            BufferedWriter x = new BufferedWriter(new FileWriter("Simulation.txt"));
//            for (String s: aString)
//            {
//                x.write(s);
//                x.write("\n");
//            }
//            x.close();
//        }
//        catch (Exception e)
//        {
//            System.console().printf("%s\n", e.toString());
//        }
//    }
}