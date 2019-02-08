package mars;

import mars.rockets.U1;
import mars.rockets.U2;
import mars.utils.Constans;
import mars.utils.FileMars;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private List<Rocket> rockets;

    public Simulation() {
        rockets = new ArrayList<>();
    }

    public List<Item> loadItems(String phase){
        FileMars fileMars = new FileMars();
        List<Item> items = new ArrayList<>();
        List<String> itemsdata = fileMars.readFile(phase);
        for (String anItemsdata : itemsdata) {
            String[] itemsData = anItemsdata.split("=");
            Item item = new Item(itemsData[0], Integer.parseInt(itemsData[1]));
            items.add(item);
        }
        return items;
    }

    public void loadU1(List<Item> items){
        rockets.clear();
        Rocket u1 = new U1(Constans.costU1, Constans.weightU1, Constans.cargoU1);
        loadRockets(u1, Constans.costU1, Constans.weightU1, Constans.cargoU1, items);
    }

    public void loadU2(List<Item> items){
        rockets.clear();
        Rocket u2 = new U2(Constans.costU2, Constans.weightU2, Constans.cargoU2);
        loadRockets(u2, Constans.costU2, Constans.weightU2, Constans.cargoU2, items);
    }

    private void loadRockets(Rocket rocket, double cost, double weight, double cargo, List<Item> items){
        for (Item item : items) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rockets.add(rocket);
                rocket = new U2(cost, weight, cargo);
            }
        }
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
