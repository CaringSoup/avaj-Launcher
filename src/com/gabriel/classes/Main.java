package com.gabriel.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gabriel.classes.aircraft.AircraftFactory;
import com.gabriel.classes.aircraft.Flyable;
import com.gabriel.classes.aircraft.MyLogger;
import com.gabriel.classes.weather.WeatherTower;

public class Main {
    private static WeatherTower weatherTower = new WeatherTower();
    private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] args) {

		String divider = new String();
		for (int i = 0; i < 80; i++)
			divider += "-";
		
		MyLogger.getMyLogger().Log(divider);
		MyLogger.getMyLogger().Log("\n\n\t\t\tSIMULATION Start\n\n");
		MyLogger.getMyLogger().Log(divider);
		
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (line != null) {
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations <= 0) {
                    System.out.println("Invalid simulations count " + simulations);
                    System.exit(1);
                }

                while ((line = reader.readLine()) != null) {
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
                    Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                    Integer.parseInt(line.split(" ")[4]));
                    flyables.add(flyable);
                }

                for (Flyable flyable : flyables) {
                    flyable.registerTower(weatherTower);
                }

                for (int i = 1; i <= simulations; i++) {
                    weatherTower.changeWeather();
                }
			}
			reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Couldn't find file " + args[0]);
        }
        catch (IOException e) {
            System.out.println("The was an error reading the file " + args[0]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Specify simulation file");
		}
		MyLogger.getMyLogger().Log("\n\n\t\t\tSIMULATION END\n\n");
	}
}