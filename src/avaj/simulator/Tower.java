package avaj.simulator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public abstract class Tower {
    private final List<Flyable> observers = new LinkedList<>();
    private final BufferedWriter writer;

    {
        try {
            writer = new BufferedWriter(new FileWriter("simulation.txt"));
        } catch (Exception e) {
            throw new NullPointerException(" - ...");
        }
    }

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        observers.forEach(Flyable::updateConditions);
    }

    protected void write(String str) {
        try {
            writer.write(str);
            writer.flush();
        } catch (IOException ignored) {
        }
    }

    protected void close() {
        try {
            writer.close();
        } catch (IOException ignored) {
        }
    }
}
