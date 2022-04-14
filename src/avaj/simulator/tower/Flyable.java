package avaj.simulator.tower;

import avaj.simulator.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}
