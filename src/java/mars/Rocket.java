package mars;

import mars.interfaces.SpaceShip;

public class Rocket implements SpaceShip {
    protected double cost;
    protected double weight;
    protected double cargo;

    public Rocket(double cost, double weight, double cargo){
        this.setCost(cost);
        this.setWeight(weight);
        this.setCargo(cargo);
    }

    @Override
    public boolean launch(){
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        boolean result = false;
        double maxWeight = maxWeight();
        if(maxWeight > item.getWeight()){
            result = true;
        }
        return result;
    }

    @Override
    public void carry(Item item) {
        this.setWeight(getWeight() + item.getWeight());
    }

    public double maxWeight(){
        return getCargo() - getWeight();
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCargo() {
        return cargo;
    }

    public void setCargo(double cargo) {
        this.cargo = cargo;
    }
}
