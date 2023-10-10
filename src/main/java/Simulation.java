import java.util.*;
import java.io.*;

class Simulation {
    public List<Item> loadItems(String fileName) {
        List<Item> items = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("=");
                String name = parts[0];
                int weight = Integer.parseInt(parts[1]);
                Item item = new Item(name, weight);
                items.add(item);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Nie znaleziono pliku");
        }
        return items;
    }

    public List<U1> loadU1(List<Item> items) {
        List<U1> rockets = new ArrayList<>();
        U1 rocket = new U1();
        for (Item item : items) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rockets.add(rocket);
                rocket = new U1();
                rocket.carry(item);
            }
        }
        rockets.add(rocket);
        return rockets;
    }

    public List<U2> loadU2(List<Item> items) {
        List<U2> rockets = new ArrayList<>();
        U2 rocket = new U2();
        for (Item item : items) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rockets.add(rocket);
                rocket = new U2();
                rocket.carry(item);
            }
        }
        rockets.add(rocket);
        return rockets;
    }

    public int runSimulation(List<? extends Rocket> rockets) {
        int totalBudget = 0;
        for (Rocket rocket : rockets) {
            totalBudget += rocket.getRocketCost();
            while (!rocket.launch() || !rocket.land()) {
                totalBudget += rocket.getRocketCost();
            }
        }
        return totalBudget;
    }
}