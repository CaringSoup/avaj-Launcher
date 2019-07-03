package za.co.gabriel.classes;

public class Coordinates
{
    private int latitude;
    private int longitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height)
    {
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
    }

    public int getLongitude()
    {
        return this.longitude;
    }

    public int getLatitude()
    {
        return this.latitude;
    }

    public int getHeight()
    {
        return this.height;
    }
}