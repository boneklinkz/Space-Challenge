package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        Simulation simulation = new Simulation();
        ArrayList<Item> phase1 = simulation.loadItems("C:\\Users\\chris.judah\\IdeaProjects\\Space Challenge\\src\\com\\company\\phase-1.txt");
        ArrayList<Item> phase2 = simulation.loadItems("C:\\Users\\chris.judah\\IdeaProjects\\Space Challenge\\src\\com\\company\\phase-1.txt");

        ArrayList<Rocket> u1Phase1 = simulation.loadU1(phase1);
        ArrayList<Rocket> u1Phase2 = simulation.loadU2(phase2);

        long budget = simulation.runSimulation(u1Phase1);
        budget += simulation.runSimulation(u1Phase1);

        System.out.println("Total cost for U1 rockets: $" + budget + ".");

        ArrayList<Rocket> u2Phase1 = simulation.loadU1(phase1);
        ArrayList<Rocket> u2Phase2 = simulation.loadU2(phase2);

        budget = simulation.runSimulation(u2Phase1);
        budget += simulation.runSimulation(u2Phase2);

        System.out.println("Total cost for U2 rockets: $" + budget + ".");
    }
}

