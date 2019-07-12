package za.co.gabriel.classes.aircrafts;

import za.co.gabriel.classes.weather.WeatherTower;
import za.co.gabriel.classes.aircrafts.MyLogger;

public class jetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	jetPlane(String name, Coordinates coordinates) {
		super (name, coordinates);		
	}
	
	public void updateConditons () {
		weatherTower.getWeather(coordinates);
	}

	@Override
	public void registerTower (WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}

	@Override
	public	void	updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
				if (this.coordinates.getHeight() > 100)
					this.coordinates.setHeight(100);
					MyLogger.getMyLogger().Log("JetPlane#" + this.name + "(" + this.id + "): This is bikini weather. - Shortstraw");
				break;
			case "RAIN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
				MyLogger.getMyLogger().Log("JetPlane#" + this.name + "(" + this.id + "): IT'S RAINING MEN, HALLELUJAH. - The Weather Girls");
				break;
			case "FOG":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
				SMyLogger.getMyLogger().Log("JetPlane#" + this.name + "(" + this.id + "): I... I don't have a famous song for this type of weather.");
				break;
			case "SNOW":
				this.coordinates.setHeight(this.coordinates.getHeight() - 12);
				MyLogger.getMyLogger().Log("JetPlane#" + this.name + "(" + this.id + "): Deep beneath the cover of another perfect wonder where it's so white as snow. - Red Hot Chillie Peppers");
				break;
			default:
				MyLogger.getMyLogger().Log("JetPlane#" + this.name + "(" + this.id + "): Faulty weather tower I guess?");
				break;
		}
	}
}