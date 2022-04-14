package avaj.simulator.tower;

import avaj.simulator.air.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    /* Ленивый Singleton */
    public static synchronized WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather[(int) (Math.random() * weather.length)];
    }
}
