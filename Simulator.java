package za.co.gabriel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.beans.property.FloatPropertyBase;
import za.co.gabriel.classes.aircrafts.AircraftFactory;
import za.co.gabriel.classes.weather.WeatherTower;
import za.co.gabriel.classes.aircrafts.Flyable;
import za.co.gabriel.classes.aircrafts.MyLogger;

public class Simulator {
    
    public static void main(String[] args) {
		WeatherTower weatherTower = new WeatherTower();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (line != null) {
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations < 0) {
                    System.out.println("Invalid simulations count " + simulations);
                    System.exit(1);
                }

                while ((line = reader.readLine()) != null) {
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
                    Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                    Integer.parseInt(line.split(" ")[4]));
                	weatherTower.register(flyable);
                }
                for (int i = 1; 1 <= simulations; i++) {
                    weatherTower.changeWeather();
                }
            }
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
        finally {
			//print to file
        }
    }
}