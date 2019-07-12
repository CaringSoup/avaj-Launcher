package za.co.gabriel.classes.aircrafts;

import za.co.gabriel.classes.weather.WeatherTower;

public interface Flyable {
	
	public void updateConditions();
	public	void registerTower(WeatherTower weatherTower);
}