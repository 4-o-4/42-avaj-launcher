package avaj.simulator;

public class Coordinates {
    private int longitude; // долгота
    private int latitude;  // широта
    private int height;    // высота

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}
