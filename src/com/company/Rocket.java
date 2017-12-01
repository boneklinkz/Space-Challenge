package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Rocket implements ISpaceShip {
    ArrayList<Item> cargo = new ArrayList<>();
    int cost;
    double cargoWeight;
    double maxCargoWeight;
    double launchExplosionChance;
    double landingCrashChange;

    Rocket() {
        cargoWeight = 0;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return cargoWeight + item.weight <= maxCargoWeight;
    }

    @Override
    public void carry(Item item) {

        cargo.add(item);

        cargoWeight += item.weight;
    }

    public int getRandomNumber(int range) {
        Random random = new Random();

        return random.nextInt(range) + 1;
    }
}
