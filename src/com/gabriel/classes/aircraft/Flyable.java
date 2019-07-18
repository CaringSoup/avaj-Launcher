package com.gabriel.classes.aircraft;

import com.gabriel.classes.weather.WeatherTower;

public interface Flyable {
	
	void updateConditions();
	void registerTower(WeatherTower weatherTower);
}