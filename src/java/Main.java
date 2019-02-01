import mars.Item;
import mars.Simulation;
import mars.utils.Constans;

import java.util.List;

public class Main {
    public static void main(String[] args){
        Simulation simulation = new Simulation();

        List<Item> itemsPhase1 = simulation.loadItems(Constans.phase1);
        List<Item> itemsPhase2 = simulation.loadItems(Constans.phase2);

        simulation.loadU1(itemsPhase1);
        double totalBudgetPhase1U1 = simulation.runSimulation();
        System.out.println("The total budget required for the rocket U1 phase-1 is: $" + totalBudgetPhase1U1 + " Million\n");

        simulation.loadU1(itemsPhase2);
        double totalBudgetPhase2U1 = simulation.runSimulation();
        System.out.println("The total budget required for the rocket U1 phase-2 is: $" + totalBudgetPhase2U1 + " Million\n");

        simulation.loadU2(itemsPhase1);
        double totalBudgetPhase1U2 = simulation.runSimulation();
        System.out.println("The total budget required for the rocket U2 phase-1 is: $" + totalBudgetPhase1U2 + " Million\n");

        simulation.loadU1(itemsPhase2);
        double totalBudgetPhase2U2 = simulation.runSimulation();
        System.out.println("The total budget required for the rocket U2 phase-2 is: $" + totalBudgetPhase2U2 + " Million\n");
    }
}
