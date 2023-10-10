import java.util.*;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();

        //Loading files
        List<Item> phase1Items = simulation.loadItems("src/main/resources/phase-1.txt");
        List<Item> phase2Items = simulation.loadItems("src/main/resources/phase-2.txt");

        // Load a fleet of U1 rockets for Phase-1 and for Phase-2
        List<U1> u1Phase1Rockets = simulation.loadU1(phase1Items);
        List<U1> u1Phase2Rockets = simulation.loadU1(phase2Items);

        // Run the simulation using the fleet of U1 rockets for Phase-1
        int u1Phase1Budget = simulation.runSimulation(u1Phase1Rockets);
        System.out.println("Total budget required for U1 Phase-1: $" + u1Phase1Budget);

        // Repeat the same for U1 rockets and display the total budget for Phase-2
        int u1Phase2Budget = simulation.runSimulation(u1Phase2Rockets);
        System.out.println("Total budget required for U1 Phase-2: $" + u1Phase2Budget);

        // Load a fleet of U2 rockets for Phase-1 and then for Phase-2
        List<U2> u2Phase1Rockets = simulation.loadU2(phase1Items);
        List<U2> u2Phase2Rockets = simulation.loadU2(phase2Items);

        // Run the simulation using the fleet of U2 rockets for Phase-1
        int u2Phase1Budget = simulation.runSimulation(u2Phase1Rockets);
        System.out.println("Total budget required for U2 Phase-1: $" + u2Phase1Budget);

        // Repeat the same for U2 rockets and display the total budget for Phase-2
        int u2Phase2Budget = simulation.runSimulation(u2Phase2Rockets);
        System.out.println("Total budget required for U2 Phase-2: $" + u2Phase2Budget);
    }
}