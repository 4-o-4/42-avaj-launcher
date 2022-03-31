package avaj.simulator;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        if ("RAIN".equals(weather)) {
            System.out.println(this + ": Идет дождь.");
            coordinates.setLongitude(coordinates.getLongitude() + 5);
        } else {
            System.out.println("----> " + weather);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        System.out.println("Tower says: " + this + "registered to weather tower.");

        weatherTower.register(this);
    }

    @Override
    public String toString() {
        return "Helicopter#" + name + '(' + id + ')';
    }
}
