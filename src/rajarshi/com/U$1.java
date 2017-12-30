package rajarshi.com;

import java.text.DecimalFormat;
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
        mRandomDouble = getRandomDouble();
    }

    /**
     * For methods {@link #launch()} and {@link #land()}:
     * 
     * @return a boolean value of exploding based on a random number using the probability equation for each.
     * {@link Rocket#launch()} and {@link Rocket#land()}
     */
    @Override
    public boolean launch() {
        //TODO: correct me if I'm wrong getting the logic correct.
        double probability = 0.05 * getResult();
        return mRandomDouble >= probability;
    }

    @Override
    public boolean land() {
        //TODO: correct me if wrong.
        double probability = 0.01 * getResult();
        return mRandomDouble >= probability;
    }

    /**
     * Generate a random double and get the value.
     */
    private double getRandomDouble() {
        // Format the decimal value to return 2 decimal values
        DecimalFormat df = new DecimalFormat("#.##");
        // Fail Safe method: add 0.01 so that random number doesn't return 0.
        return Double.parseDouble(df.format(new Random().nextDouble()));
    }

    /**
     * Same calculations every time! A method that can be save typing.
     *
     * @return the result of {@link Rocket#getCurrentRocketWeight()} divided by {@link Rocket#getCargoLimit()}
     */
    private double getResult() {
        return getCurrentRocketWeight() / getCargoLimit();
    }
}
