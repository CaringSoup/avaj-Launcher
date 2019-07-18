package com.gabriel.classes.aircraft;

import com.gabriel.classes.weather.Coordinates;
import com.gabriel.classes.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super (name, coordinates);
	}

//	public void updateConditons () {
//		weatherTower.getWeather(coordinates);
//	}

	public void registerTower (WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		MyLogger.getMyLogger().Log("Helicopter#" + this.name + "(" + this.id + "): has registered from the tower");
	}

	public	void	updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
					MyLogger.getMyLogger().Log("Helicopter#" + this.name + "(" + this.id + "): Looks like great weather for flying today son!");
				break;
			case "RAIN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
				MyLogger.getMyLogger().Log("Helicopter#" + this.name + "(" + this.id + "): I hope you brought a rainjacket... Those doors are for show only.");
				break;
			case "FOG":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
				MyLogger.getMyLogger().Log("Helicopter#" + this.name + "(" + this.id + "): Ohhhhhhhh they said fog not frog... whoops!");
				break;
			case "SNOW":
				this.coordinates.setHeight(this.coordinates.getHeight() - 12);
				MyLogger.getMyLogger().Log("Helicopter#" + this.name + "(" + this.id + "): I don't suppose any of you know any Christmas songs?");
				break;
			default:
				MyLogger.getMyLogger().Log("Helicopter#" + this.name + "(" + this.id + "): Faulty weather tower I guess?");
				break;
		}
		if (this.coordinates.getHeight() > 100) {
			this.coordinates.setHeight(100);
		} else if (coordinates.getHeight() <= 0) {
			weatherTower.unregister(this);
			MyLogger.getMyLogger().Log("Helicopter#" + this.name + "(" + this.id + "): has landed");
			MyLogger.getMyLogger().Log("Helicopter#" + this.name + "(" + this.id + "): has unregistered from the tower");
		}
	}
}