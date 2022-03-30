package avaj.simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("[Error] - Программа принимаеть один и только один аргумент");
        } else {
            try {
                BufferedReader fr = new BufferedReader(new FileReader(args[0]));
                String line = fr.readLine();
                System.out.println("-------\nint: " + Integer.parseInt(line) + "\n-------");

                WeatherTower t = new WeatherTower();

                while ((line = fr.readLine()) != null) {
                    String[] l = line.split(" ");
                    Flyable f = AircraftFactory.newAircraft(l[0], l[1], Integer.parseInt(l[2]), Integer.parseInt(l[3]), Integer.parseInt(l[4]));
                    if (f != null) {
                        f.registerTower(t);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
