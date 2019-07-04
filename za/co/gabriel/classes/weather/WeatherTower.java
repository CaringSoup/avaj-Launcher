package za.co.gabriel.classes.weather;

public class WeatherTower {
	
	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}
	void	changeWeather() {
		this.conditionsChanged();
	}
}