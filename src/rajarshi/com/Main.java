package rajarshi.com;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Creating a Simulation object and get the items for each Phase.
        Simulation simulation = new Simulation("phase-1.txt", "phase-2.txt");
        // Create a U1 rocket prototype
        // @param phaseNumber set to 0 as we are building it, no items loaded.
        U$1 u$1 = new U$1(10000, 18000, 100, 0);
        // Create a list of U1 rockets and load the items for each phase.
        List<U$1> u$1sPhase1 = simulation.loadU$1(u$1, 1);
        List<U$1> u$1sPhase2 = simulation.loadU$1(u$1, 2);
        // Get the list of rockets and run the simulation
        simulation.runSimulation(u$1sPhase1, u$1sPhase2);

        System.out.println();

        U$2 u$2 = new U$2(18000, 29000, 120, 0);
        List<U$2> u$2sPhase1 = simulation.loadU$2(u$2, 1);
        List<U$2> u$2sPhase2 = simulation.loadU$2(u$2, 2);
        simulation.runSimulation(u$2sPhase1, u$2sPhase2);

    }
}