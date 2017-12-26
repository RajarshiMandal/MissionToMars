package rajarshi.com;

/**
 * The Rocket class that implements {@link SpaceShip} interface and thus has to override methods.
 */
public class Rocket implements SpaceShip {

    private int mMaxWeight; // Maximum weight it can carry.
    private int mRocketWeight; // Weight of the rocket.
    private int mCargoLimit; // The max weight it can carry.
    private int mCurrentCargoWeight; // Current weight of the Item weight.

    /**
     * The constructor of the Rocket Object that takes in 2 parameters.
     *
     * @param rocketWeight is the weight of the rocket itself
     * @param maxWeight    is the weight of a rocket can carry including it's own weight.
     */
    Rocket(int rocketWeight, int maxWeight) {
        mRocketWeight = rocketWeight;
        mMaxWeight = maxWeight;
        mCargoLimit = maxWeight - rocketWeight;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    /**
     * Calculate the total weight of the items it's carrying and update the member variable accordingly.
     *
     * @return {@link #mCurrentCargoWeight} for easy access.
     */
    @Override
    public int carry(Item item) {
        return mCurrentCargoWeight += item.getWeight();
    }

    /**
     * @return true if {@link #mCurrentCargoWeight} doesn't exceeds rocket's {@link #mCargoLimit} else false.
     */
    @Override
    public boolean canCarry(Item item) {
        return mCurrentCargoWeight + item.getWeight() <= mCargoLimit;
    }

    /*
     * Public methods to get the value of the member variables
     */
    int getRocketWeight() {
        return mRocketWeight;
    }

    public int getMaxWeight() {
        return mMaxWeight;
    }

    int getCargoLimit() {
        return mCargoLimit;
    }

    int getCurrentCargoWeight() {
        return mCurrentCargoWeight;
    }
}
