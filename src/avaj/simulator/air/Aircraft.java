package avaj.simulator.air;

public abstract class Aircraft {
    private static long idCounter;
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        return ++idCounter;
    }
}
