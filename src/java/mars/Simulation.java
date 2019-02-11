package mars;

import mars.rockets.U1;
import mars.rockets.U2;
import mars.utils.FileMars;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final double costU1 = 100;
    private final double weightU1 = 10000;
    private final double cargoU1 = 18000;
    private final double costU2 = 120;
    private final double weightU2 = 18000;
    private final double cargoU2 = 29000;

    private List<Rocket> rockets;

    public Simulation() {
        rockets = new ArrayList<>();
    }

    public List<Item> loadItems(String phase){
        FileMars fileMars = new FileMars();
        List<Item> items = new ArrayList<>();
        List<String> itemsDataList = fileMars.readFile(phase);
        for (String itemData : itemsDataList) {
            String[] itemsData = itemData.split("=");
            Item item = new Item(itemsData[0], Integer.parseInt(itemsData[1]));
            items.add(item);
        }
        return items;
    }

    public void loadU1(List<Item> items){
        rockets.clear();
        Rocket u1 = new U1(costU1, weightU1, cargoU1);
        loadRockets(u1, costU1, weightU1, cargoU1, items);
    }

    public void loadU2(List<Item> items){
        rockets.clear();
        Rocket u2 = new U2(costU2, weightU2, cargoU2);
        loadRockets(u2, costU2, weightU2, cargoU2, items);
    }

    private void loadRockets(Rocket rocket, double cost, double weight, double cargo, List<Item> items){
        for (Item item : items) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rockets.add(rocket);
                rocket = getRocketIntance(rocket, cost, weight, cargo);
            }
        }
    }

    private Rocket getRocketIntance(Rocket rocket, double cost, double weight, double cargo) {
        if(rocket instanceof U1){
            rocket = new U1(cost, weight, cargo);
        }else {
            rocket = new U2(cost, weight, cargo);
        }
        return rocket;
    }

    public double runSimulation(){
        double totalBudget = 0;
        for (int count = 0; count < rockets.size(); count++){
            if(!rockets.get(count).launch() || !rockets.get(count).land()){
                rockets.add(rockets.get(count));
                totalBudget = totalBudget + rockets.get(count).getCost();
            }else {
                totalBudget = totalBudget + rockets.get(count).getCost();
            }
        }
        return totalBudget;
    }
}
