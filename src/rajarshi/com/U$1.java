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

    // Weight of the Cargo that it will carry.
    private int mCargoWeight;

    /**
     * Calling the constructor of the {@link Rocket} class to create U$1 rocket object.
     */
    U$1(int rocketWeight, int maxWeight, int cost, int cargoWeight) {
        // Super can take static methods or Variables
        super(rocketWeight, maxWeight, cost);
        mCargoWeight = cargoWeight;

    }

    /**
     * Chance of launch explosion calculation based on probability.
     *
     * @return a boolean value based on a random number using the probability equation.
     */
    @Override
    public boolean launch() {
        //TODO: correct me if I'm wrong getting the logic correct.
        int cargoLimit = getCargoLimit();
        // Using 5.0 instead of 0.05 to get a better result; the Random generated is multiplied by 100 too.
        double probability = 5.0 * mCargoWeight / cargoLimit;
        double random = getRandomDouble();
        return random >= probability;
    }

    /**
     * @return chance of landing crash.
     */
    @Override
    public boolean land() {
        //TODO: correct me if wrong.
        return getRandomDouble() >= (double) (mCargoWeight / getCargoLimit());
    }

    /**
     * Generate a random double and get the value.
     */
    private double getRandomDouble() {
        return (new Random().nextDouble() * 100);
    }
}
