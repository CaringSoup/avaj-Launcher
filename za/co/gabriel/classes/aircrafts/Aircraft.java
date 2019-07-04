package za.co.gabriel.classes.aircrafts;

public class Aircraft
{
    private long id;
    private String name;
    private Coordinates coordinates;
    private long idCounter;

    public Aircraft (long id, String name, Coordinates coordinates, long idCounter)
    {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.idCounter = idCounter;
        this.id = nextId();
    }
}