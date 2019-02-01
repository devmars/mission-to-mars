package mars;

import mars.interfaces.SpaceShip;

public abstract class Rocket implements SpaceShip {
    protected int cost;
    protected int weight;
    protected int cargo;

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
        // implement code here
        return false;
    }

    @Override
    public void carry(Item item) {
        //implement code here
    }

}
