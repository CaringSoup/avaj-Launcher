package za.co.gabriel.classes.aircrafts;

import za.co.gabriel.classes.weather.Coordinates;

public abstract class Aircraft
{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    public Aircraft (String name, Coordinates coordinates) {
        this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();
    }

    private long nextId () {
        return idCounter++;
    }

    public Coordinates getCoordinates() {
		return this.coordinates;
	}
}