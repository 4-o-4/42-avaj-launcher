package avaj.simulator;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Simulator {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("[Error] - Программа принимаеть один и только один аргумент");
        } else {
            try {
                BufferedReader fr = new BufferedReader(new FileReader(args[0]));
                String line = fr.readLine();
                int count = Integer.parseInt(line);
                System.out.println("-------\nint: " + count + "\n-------");

                Flyable f = null;
                WeatherTower t = new WeatherTower();

                while ((line = fr.readLine()) != null) {
                    String[] l = line.split(" ");
                    f = AircraftFactory.newAircraft(l[0], l[1], Integer.parseInt(l[2]), Integer.parseInt(l[3]), Integer.parseInt(l[4]));
                    if (f != null) {
                        f.registerTower(t);
                    }
                }
                System.out.println("\n-------");
                for (int i = 0; i < count && f != null; i++) {
                    t.changeWeather();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
