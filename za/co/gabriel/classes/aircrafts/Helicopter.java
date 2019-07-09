package za.co.gabriel.classes.aircrafts;

public class Helicopter extends Aircraft {
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super (name, coordinates);
	}

	public void updateConditons () {
		weatherTower.getWeather(coordinates);
	}

	public void registerTower (WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}
}