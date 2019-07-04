package za.co.gabriel.classes.aircrafts;

public class jetPlane extends Aircraft implements Flyable {
	private WeatherTower _weatherTower;

	jetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);		
    }
}