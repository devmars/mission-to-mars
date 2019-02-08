package mars;

import mars.interfaces.SpaceShip;

public abstract class Rocket implements SpaceShip {
    protected double cost;
    protected double weight;
    protected double cargo;

    public Rocket(double cost, double weight, double cargo){
        this.cost = cost;
        this.weight = weight;
        this.cargo = cargo;
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
        return maxWeight() > item.getWeight();
    }

    @Override
    public void carry(Item item) {
        this.weight += item.getWeight();
    }

    public double maxWeight(){
        return cargo - weight;
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

    protected abstract boolean getProbabilityExplotion(double probability);
}
