package za.co.gabriel.classes.aircrafts;

import za.co.gabriel.classes.weather.*;

public abstract class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
		if (type == "Baloon"){
			return new Baloon(name, coordinates);
		}
		else if (type == "Helicopter") {
			return new Helicopter(name, coordinates);
		}
		else if (type == "JetPlane") {
			return new JetPlane(name, coordinates);
		}
		else return null;
	}
}