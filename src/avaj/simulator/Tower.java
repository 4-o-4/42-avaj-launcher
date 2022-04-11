package avaj.simulator;

import java.util.LinkedList;
import java.util.List;

public abstract class Tower {
    private final List<Flyable> observers = new LinkedList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {

    }

    protected void conditionsChanged() {
        observers.forEach(Flyable::updateConditions);
    }
}