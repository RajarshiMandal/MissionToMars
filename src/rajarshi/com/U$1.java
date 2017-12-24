package rajarshi.com;

import java.util.Random;

/**
 * Rocket prototype =           U$1
 * Rocket cost =                $100 Million
 * Rocket weight =              10 Tonnes
 * Max weight (with cargo) =    18 Tonnes
 * Chance of launch explosion = 5% * (cargo carried / cargo limit)
 * Chance of landing crash =    1% * (cargo carried / cargo limit)
 */
public class U$1 extends Rocket {

    private double mRandomDouble; // Variable for a random double.

    /**
     * Calling the constructor of the {@link Rocket} class that also takes the same parameters, and create
     * U$1 rocket constructor.
     */
    U$1(int rocketWeight, int maxWeight) {
        super(rocketWeight, maxWeight);
        mRandomDouble = setRandomDouble();
    }

    /**
     * @return a boolean value to see if the probability calculation is working or not by overriding the methods of
     * {@link Rocket#launch()} and {@link Rocket#land()}
     */
    @Override
    public boolean launch() {
        //TODO: correct me if I'm wrong setting the equation of probability.
        double probability = 0.05 * getCurrentRocketWeight() / getCargoLimit();
        return mRandomDouble >= probability;
    }

    @Override
    public boolean land() {
        //TODO: correct me if I'm wrong.
        double probability = 0.01 * getCurrentRocketWeight() / getCargoLimit();
        return mRandomDouble <= probability;
    }

    /*
     * Generate a random double.
     */
    private double setRandomDouble() {
        return new Random().nextDouble();
    }
}
