package avaj.simulator.air;

import avaj.simulator.exception.NumberCheckException;
import avaj.simulator.tower.Flyable;

public abstract class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        return switch (type) {
            case "baloon" -> new Baloon(name, new Coordinates(longitude, latitude, height));
            case "helicopter" -> new Helicopter(name, new Coordinates(longitude, latitude, height));
            case "jetplane" -> new JetPlane(name, new Coordinates(longitude, latitude, height));
            default -> throw new NumberCheckException(" - ...");
        };
    }
}
