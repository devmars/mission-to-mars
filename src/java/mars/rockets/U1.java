package mars.rockets;

import mars.Rocket;

public class U1 extends Rocket {

    public U1(double cost, double weight, double cargo) {
        super(cost, weight, cargo);
    }

    @Override
    public boolean launch(){
        boolean result = false;
        double numero = (Math.random() * 1);
        double launchExplotion = (0.05 * (getWeight() / getCargo()));
        if(numero < launchExplotion){
            result = true;
        }
        return result;
    }

    @Override
    public boolean land() {
        boolean result = false;
        double numero = (Math.random() * 1);
        double landExplotion = (0.01 * (getWeight() / getCargo()));
        if(numero < landExplotion){
            result = true;
        }
        return result;
    }
}
