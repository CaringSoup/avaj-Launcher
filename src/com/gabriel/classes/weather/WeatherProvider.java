package com.gabriel.classes.weather;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

	private WeatherProvider() {
	}
	
	public static WeatherProvider	getProvider() {
		return weatherProvider;
	}
	
	public String	getCurrentWeather(Coordinates coordinates) {
		return (weather[ThreadLocalRandom.current().nextInt(0, weather.length)]);
	}
}