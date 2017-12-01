package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Simulation {
    public ArrayList<Item> loadItems(String fileName) throws IOException {
        ArrayList<Item> items = new ArrayList<>();

        File file = new File(fileName);

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split("=");

            Item item = new Item();
            item.name = split[0];
            item.weight = Integer.parseInt(split[1]);

            items.add(item);
        }

        return items;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        ArrayList<Rocket> rockets = new ArrayList<>();

        U1 rocket = null;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);

            if (rocket == null)
            {
                rocket = new U1();
            } else {
                if (!rocket.canCarry(item)) {
                    System.out.println("Current rocket cannot carry cargo.  Building new rocket.");

                    rockets.add(rocket);

                    rocket = new U1();
                }
            }

            rocket.carry(item);

            System.out.println("Loaded cargo in rocket.");
        }

        return rockets;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        ArrayList<Rocket> rockets = new ArrayList<>();

        U2 rocket = null;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);

            if (rocket == null)
            {
                rocket = new U2();
            } else {
                if (!rocket.canCarry(item)) {
                    System.out.println("Current rocket cannot carry cargo.  Building new rocket.");

                    rockets.add(rocket);

                    rocket = new U2();
                }
            }

            rocket.carry(item);

            System.out.println("Loaded cargo in rocket.");
        }

        return rockets;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {

        int budget = 0;

        for (int i = 0; i < rockets.size(); i++) {
            Rocket rocket = rockets.get(i);

            do {
                budget += rocket.cost;
            } while (!rocket.launch());

            do {
                budget += rocket.cost;
            } while (!rocket.land());
        }

        return budget;
    }
}
