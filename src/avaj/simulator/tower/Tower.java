package avaj.simulator.tower;

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

    protected void conditionsChanged()  {
        List<Flyable> _observers = new LinkedList<>(observers);
        _observers.forEach(Flyable::updateConditions);
    }

    public void write(String str) {
        try {
            writer.write(str);
            writer.flush();
        } catch (IOException ignored) {
        }
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException ignored) {
        }
    }

    public Boolean isNull() {
        return observers.isEmpty();
    }
}
