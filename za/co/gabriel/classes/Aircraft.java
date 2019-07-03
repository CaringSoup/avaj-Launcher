package za.co.gabriel.classes;

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
    }

    public long getid()
    {
        return this.id;
    }

    public String getname()
    {
        return this.name;
    }
    
    public Coordinates getcoordinates()
    {
        return this.coordinates;
    }

    public long getidCounter()
    {
        return this.idCounter;
    }
}