package mars.rockets;

import mars.Rocket;

public class U2 extends Rocket {

    public U2(double cost, double weight, double cargo) {
        super(cost, weight, cargo);
    }

    @Override
    public boolean launch(){
        boolean result = false;
        double numero = (Math.random() * 1);
        double launchExplotion = (0.04 * (getWeight() / getCargo()));
        if(numero < launchExplotion){
            result = true;
        }
        return result;
    }

    @Override
    public boolean land() {
        boolean result = false;
        double numero = (Math.random() * 1);
        double launchExplotion = (0.08 * (getWeight() / getCargo()));
        if(numero < launchExplotion){
            result = true;
        }
        return result;
    }
}
