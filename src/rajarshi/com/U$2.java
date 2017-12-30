package rajarshi.com;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Rocket prototype =           U$2
 * Rocket cost =                $120 Million
 * Rocket weight =              18 Tonnes
 * Max weight (with cargo) =    29 Tonnes
 * Chance of launch explosion = 4% * (cargo carried / cargo limit)
 * Chance of landing crash =    8% * (cargo carried / cargo limit)
 */
public class U$2 extends Rocket {

    private int mCargoWeight;

    U$2(int rocketWeight, int maxWeight, int cost, int cargoWeight) {
        super(rocketWeight, maxWeight, cost);
        mCargoWeight = cargoWeight;
    }

    @Override
    public boolean launch() {
        //TODO: wrong || right ? correction needed : never mind
        return getRandomDouble() >= (4.0 * getResult());
    }

    @Override
    public boolean land() {
        //TODO: correct me.
        return getRandomDouble() >= (4.0 * getResult());
    }

    private double getRandomDouble() {
        DecimalFormat df = new DecimalFormat("#.####");
        return Double.parseDouble(df.format(new Random().nextDouble() * 100));
    }

    private double getResult() {
        return (double) mCargoWeight / getCargoLimit();
    }
}
