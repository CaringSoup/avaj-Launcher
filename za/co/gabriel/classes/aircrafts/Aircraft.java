package za.co.gabriel.classes.aircrafts;

import za.co.gabriel.classes.Coordinates;

public abstract class Aircraft
{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    public Aircraft (String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId () {
        
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }
}