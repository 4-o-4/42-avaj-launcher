package avaj.simulator;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {

    }

    public static WeatherProvider getProvider() {
        return null;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return null;
    }
}
