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

    private double mRandomDouble;

    U$2(int rocketWeight, int cargoLimit) {
        super(rocketWeight, cargoLimit);
        mRandomDouble = getRandomDouble();
    }

    @Override
    public boolean launch() {
        //TODO: correct me.
        double explosionProbability = 0.04 * getResult();
        return mRandomDouble >= explosionProbability;
    }

    @Override
    public boolean land() {
        //TODO: correct me.
        double crashProbability = 0.08 * getResult();
        return mRandomDouble >= crashProbability;
    }

    private double getRandomDouble() {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(new Random().nextDouble() + 0.01));
    }

    private double getResult() {
        return getCurrentRocketWeight() / getCargoLimit();
    }
}
