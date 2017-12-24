package rajarshi.com;

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
        mRandomDouble = setRandomDouble();
    }

    @Override
    public boolean launch() {
        //TODO: correct me.
        double probability = 0.04 * getCurrentRocketWeight() / getCargoLimit();
        return mRandomDouble <= probability;
    }

    @Override
    public boolean land() {
        //TODO: correct me.
        double probability = 0.08 * getCurrentRocketWeight() / getCargoLimit();
        return mRandomDouble <= probability;
    }

    private double setRandomDouble() {
        return new Random().nextDouble();
    }
}
