package avaj.simulator;

public abstract class Aircraft {
    private static long idCounter;
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = ++idCounter;
    }

    private long nextId() {
        return id;
    }

    public long getIdCounter() {
        return idCounter;
    }
}
