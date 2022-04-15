package avaj.simulator.air;

import avaj.simulator.WeatherTower;
import avaj.simulator.tower.Flyable;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregister(this);
            coordinates.setHeight(0);
            weatherTower.write(String.format("%s: приземлился - долгота: %d, широта: %d, высота: %d\n",
                    this, coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight()));
        }
        else {
            String weather = weatherTower.getWeather(coordinates);
            if ("RAIN".equals(weather)) {
                coordinates.setHeight(coordinates.getHeight() - 5);
                weatherTower.write(this + ": идет дождь.\n");
            }
            else if ("FOG".equals(weather)) {
                coordinates.setHeight(coordinates.getHeight() - 3);
                weatherTower.write(this + ": туман.\n");
            }
            else if ("SUN".equals(weather)) {
                coordinates.setLongitude(coordinates.getLongitude() + 2);
                coordinates.setHeight(coordinates.getHeight() + 4);
                weatherTower.write(this + ": солнце.\n");
            }
            else if ("SNOW".equals(weather)) {
                coordinates.setHeight(coordinates.getHeight() - 15);
                weatherTower.write(this + ": идет снег.\n");
            }
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        weatherTower.write("Tower says: " + this + " registered to weather tower.\n");
    }

    @Override
    public String toString() {
        return "Baloon#" + name + '(' + id + ')';
    }
}
