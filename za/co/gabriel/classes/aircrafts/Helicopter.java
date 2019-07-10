package za.co.gabriel.classes.aircrafts;

public class Helicopter extends Aircraft {
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
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
					System.out.println("Helicopter#" + this.name + "(" + this.id + "): Looks like great weather for flying today son!");
				break;
			case "RAIN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
				System.out.println("Helicopter#" + this.name + "(" + this.id + "): I hope you brought a rainjacket... Those doors are for show only.");
				break;
			case "FOG":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
				System.out.println("Helicopter#" + this.name + "(" + this.id + "): Ohhhhhhhh they said fog not frog... whoops!");
				break;
			case "SNOW":
				this.coordinates.setHeight(this.coordinates.getHeight() - 12);
				System.out.println("Helicopter#" + this.name + "(" + this.id + "): I don't suppose any of you know any Christmas songs?");
				break;
			default:
				System.out.println("Helicopter#" + this.name + "(" + this.id + "): Faulty weather tower I guess?");
				break;
		}
	}
}