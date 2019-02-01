package mars.rockets;

import mars.Rocket;

public class U1 extends Rocket {

    public U1(double cost, double weight, double cargo) {
        super(cost, weight, cargo);
    }

    @Override
    public boolean launch(){
        boolean result = false;
        double launch = (0.05 * (getWeight() / getCargo()))*100;
        if(launch != 5){
            result = true;
        }
        return result;
    }

    @Override
    public boolean land() {
        boolean result = false;
        double launch = (0.01 * (getWeight() / getCargo()))*100;
        if(launch != 1){
            result = true;
        }
        return result;
    }
}
