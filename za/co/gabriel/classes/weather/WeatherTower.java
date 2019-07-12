package za.co.gabriel.classes.weather;

public class WeatherTower implements Tower {
	
	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}
	void	changeWeather() {
		this.conditionsChanged();
	}
}