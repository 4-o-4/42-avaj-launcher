package avaj.simulator.air;

import avaj.simulator.WeatherTower;
import avaj.simulator.tower.Flyable;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregister(this);
            coordinates.setHeight(0);
            System.out.printf("%s: приземлился - долгота: %d, широта: %d, высота: %d",
                this, coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());
        }
        else {
            String weather = weatherTower.getWeather(coordinates);
            if ("RAIN".equals(weather)) {
                coordinates.setLongitude(coordinates.getLongitude() + 5);
                System.out.println(this + ": идет дождь.");
            }
            else if ("FOG".equals(weather)) {
                coordinates.setLongitude(coordinates.getLongitude() + 1);
                System.out.println(this + ": туман.");
            }
            else if ("SUN".equals(weather)) {
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                coordinates.setHeight(coordinates.getHeight() - 2);
                System.out.println(this + ": солнце.");
            }
            else if ("SNOW".equals(weather)) {
                coordinates.setHeight(coordinates.getHeight() - 12);
                System.out.println(this + ": идет снег.");
            }
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);

        System.out.println("Tower says: " + this + " registered to weather tower.");
    }

    @Override
    public String toString() {
        return "Helicopter#" + name + '(' + id + ')';
    }
}
