package mars.rockets;

import mars.Rocket;

public class U1 extends Rocket {

    public U1(double cost, double weight, double cargo) {
        super(cost, weight, cargo);
    }

    @Override
    public boolean launch(){
        return getProbabilityExplotion(0.05);
    }

    @Override
    public boolean land() {
        return getProbabilityExplotion(0.01);
    }
}
