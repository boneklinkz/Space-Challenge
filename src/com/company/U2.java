package com.company;

public class U2 extends Rocket{
    U2() {
        cost = 120000000;
        maxCargoWeight = 11000;
    }

    @Override
    public boolean launch() {
        launchExplosionChance = 4 * (cargoWeight / maxCargoWeight);

        int random = getRandomNumber(100);

        if (launchExplosionChance > random) {
            System.out.println("Rocket failed to launch.");

            return false;
        }

        System.out.println("Rocket successfully launched.");

        return true;
    }

    @Override
    public boolean land() {
        landingCrashChange = 8 * (cargoWeight / maxCargoWeight);

        int random = getRandomNumber(100);

        if (landingCrashChange > random) {
            System.out.println("Rocket failed to land.");

            return false;
        }

        System.out.println("Rocket successfully landed.");

        return true;
    }
}
