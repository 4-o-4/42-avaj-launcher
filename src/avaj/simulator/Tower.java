package avaj.simulator;

import java.util.List;
import java.util.ArrayList;

public abstract class Tower {
    private final List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {

    }

    protected void conditionsChanged() {
        observers.get(1).updateConditions();
    }
}