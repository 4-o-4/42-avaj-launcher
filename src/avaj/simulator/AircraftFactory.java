package avaj.simulator;

import java.util.Locale;

public abstract class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

        if (type.toLowerCase(Locale.ROOT).equals("helicopter")) {
            return new Helicopter(name, new Coordinates(longitude, latitude, height));
        }

        return null;
    }
}
