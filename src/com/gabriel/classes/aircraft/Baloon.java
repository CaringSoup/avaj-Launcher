package com.gabriel.classes.aircraft;

import com.gabriel.classes.weather.Coordinates;
import com.gabriel.classes.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    public WeatherTower weatherTower;
	
	Baloon(String name, Coordinates coordinates) {
		super (name, coordinates);
	}

//	public void updateConditons () {
//		weatherTower.getWeather(coordinates);
//	}

	public void registerTower (WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		MyLogger.getMyLogger().Log("Baloon#" + this.name + "(" + this.id + "): has registered from the tower");
	}

	public	void	updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
					MyLogger.getMyLogger().Log("Baloon#" + this.name + "(" + this.id + "): It's too fuckin' hot for this shit.");
				break;
			case "RAIN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
				MyLogger.getMyLogger().Log("Baloon#" + this.name + "(" + this.id + "): Fuck, these are my new boots!");
				break;
			case "FOG":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
				MyLogger.getMyLogger().Log("Baloon#" + this.name + "(" + this.id + "): You know last time I tried to catch some fog... but I mist!");
				break;
			case "SNOW":
				this.coordinates.setHeight(this.coordinates.getHeight() - 12);
				MyLogger.getMyLogger().Log("Baloon#" + this.name + "(" + this.id + "): D-d-d-d-does a-a...... does a-....");
				break;
			default:
				MyLogger.getMyLogger().Log("Baloon#" + this.name + "(" + this.id + "): Faulty weather tower I guess?");
				break;
		}
		if (this.coordinates.getHeight() > 100) {
			this.coordinates.setHeight(100);
		} else if (coordinates.getHeight() <= 0) {
			weatherTower.unregister(this);
			MyLogger.getMyLogger().Log("Baloon#" + this.name + "(" + this.id + "): has landed");
			MyLogger.getMyLogger().Log("Baloon#" + this.name + "(" + this.id + "): has unregistered from the tower");
		}
	}
}