package avaj.simulator;

import avaj.simulator.air.Coordinates;
import avaj.simulator.tower.Tower;
import avaj.simulator.tower.WeatherProvider;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        conditionsChanged();
    }
}
