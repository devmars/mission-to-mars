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

    private boolean getProbabilityExplotion(double probability){
        boolean result = false;
        double numero = (Math.random() * 1);
        double launchExplotion = (probability * (getWeight() / getCargo()));
        if(numero < launchExplotion){
            result = true;
        }
        return result;
    }
}
