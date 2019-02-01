package mars.rockets;

import mars.Rocket;

public class U2 extends Rocket {

    public U2(double cost, double weight, double cargo) {
        super(cost, weight, cargo);
    }

    @Override
    public boolean launch(){
        boolean result = false;
        double launch = (0.04 * (getWeight() / getCargo()))*100;
        if(launch != 4){
            result = true;
        }
        return result;
    }

    @Override
    public boolean land() {
        boolean result = false;
        double launch = (0.08 * (getWeight() / getCargo()))*100;
        if(launch != 8){
            result = true;
        }
        return result;
    }
}
