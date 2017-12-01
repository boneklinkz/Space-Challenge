package com.company;

public class U1 extends Rocket{
    U1() {
        cost = 100000000;
        maxCargoWeight = 8000;
    }

    @Override
    public boolean launch() {
        launchExplosionChance = 8 * (cargoWeight / maxCargoWeight);

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
        landingCrashChange = 1 * (cargoWeight / maxCargoWeight);

        int random = getRandomNumber(100);

        if (landingCrashChange > random) {
            System.out.println("Rocket failed to land.");

            return false;
        }

        System.out.println("Rocket successfully landed.");

        return true;
    }
}
