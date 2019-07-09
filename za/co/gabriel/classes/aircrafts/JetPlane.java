package za.co.gabriel.classes.aircrafts;

public class jetPlane extends Aircraft {
	private WeatherTower weatherTower;

	jetPlane(String name, Coordinates coordinates) {
		super (name, coordinates);		
	}
	
//	public void updateConditons () {
//		weatherTower.getWeather(coordinates);
//	}

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
				writetofile("JetPlane#" + this.name + "(" + this.id + "): This is bikini weatherrrrr. - Shortstraw");
				break;
			case "RAIN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
				writetofile("JetPlane#" + this.name + "(" + this.id + "): IT'S RAINING MEN, HALLELUJAH. - The Weather Girls");
				break;
			case "FOG":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
				writetofile("JetPlane#" + this.name + "(" + this.id + "): I... I don't have a famous song for fog.");
				break;
			case "SNOW":
				this.coordinates.setHeight(this.coordinates.getHeight() - 12);
				writetofile("JetPlane#" + this.name + "(" + this.id + "): Deep beneath the cover of another perfect wonder where it's so white as snow. - Red Hot Chillie Peppers");
				break;
			default:
				writetofile("JetPlane#" + this.name + "(" + this.id + "): Faulty weather tower I guess?");
				break;
		}
	}
}