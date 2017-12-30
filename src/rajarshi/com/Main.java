package rajarshi.com;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create a Simulation object
        Simulation simulation = new Simulation();

        // Load Items for Phase-1 and Phase-2
        List<Item> u1ItemsPhase1 = simulation.loadItems("phase-1.txt");
        List<Item> u1ItemsPhase2 = simulation.loadItems("phase-2.txt");

        // Load a fleet of U1 rockets for Phase-1 and then for Phase-2
        U$1 u$1 = new U$1(10000, 18000, 100, 0);
        List<U$1> u$1sForPhase1 = simulation.loadU$1(u1ItemsPhase1, u$1);
        List<U$1> u$1sForPhase2 = simulation.loadU$1(u1ItemsPhase2, u$1);

        // Run the simulation using the fleet of U1 rockets and display the total budget required.
        List<Rocket> rocketsU1s = new ArrayList<>();
        rocketsU1s.addAll(u$1sForPhase1);
        rocketsU1s.addAll(u$1sForPhase2);
        simulation.runSimulation(rocketsU1s);

        // Load Items for Phase-1 and Phase-2
        List<Item> u2ItemsPhase1 = simulation.loadItems("phase-1.txt");
        List<Item> u2ItemsPhase2 = simulation.loadItems("phase-2.txt");

        // Load a fleet of U2 rockets for Phase-1 and then for Phase-2
        U$2 u$2 = new U$2(18000, 29000, 120, 0);
        List<U$2> u$2sForPhase1 = simulation.loadU$2(u2ItemsPhase1, u$2);
        List<U$2> u$2sForPhase2 = simulation.loadU$2(u2ItemsPhase2, u$2);

        // Run the simulation using the fleet of U2 rockets and display the total budget required.
        List<Rocket> rocketsU2s = new ArrayList<>();
        rocketsU2s.addAll(u$2sForPhase1);
        rocketsU2s.addAll(u$2sForPhase2);
        simulation.runSimulation(rocketsU2s);

    }
}