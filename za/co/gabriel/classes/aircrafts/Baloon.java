package za.co.gabriel.classes.aircrafts;

import za.co.gabriel.classes.weather.WeatherTower;

public class Baloon extends Aircraft {
    public WeatherTower weatherTower;
	
	Baloon(String name, Coordinates coordinates) {
		super (name, coordinates);
	}

	public void updateConditons () {
		weatherTower.getWeather(coordinates);
	}

	public void registerTower (WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}

	public	void	updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
				if (this.coordinates.getHeight() > 100)
					this.coordinates.setHeight(100);
				WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + "): Perfect day for flying, I hope you brought some sunschreen.");
				break;
			case "RAIN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
				WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + "): Fuck, these are my new boots!");
				break;
			case "FOG":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
				WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + "): You know last time I tried to catch some fog... but I mist!");
				break;
			case "SNOW":
				this.coordinates.setHeight(this.coordinates.getHeight() - 12);
				WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + "): D-d-d-d-does a-a...... does a-....");
			break;
			default:
			WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + "): Faulty weather tower I guess?");
			break;
		}
	}
}