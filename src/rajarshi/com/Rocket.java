package rajarshi.com;

/**
 * The Rocket class that implements {@link SpaceShip} interface and thus has to override methods.
 */
public class Rocket implements SpaceShip {

    private int mMaxWeight; // Maximum weight of the Rocket.
    private int mRocketWeight; // Weight of the rocket.
    private int mCost;
    private int mCargoLimit; // The max weight it can carry.
    private int mCurrentCargoWeight = 0; // Current weight of the Items.

    /**
     * The constructor of the Rocket Object.
     *
     * @param rocketWeight is the weight of the rocket itself
     * @param maxWeight    is the weight of the rocket it can carry including it's own weight.
     * @param cost         $ needed to build the Rocket.
     */
    Rocket(int rocketWeight, int maxWeight, int cost) {
        mRocketWeight = rocketWeight;
        mMaxWeight = maxWeight;
        mCost = cost;
        // Calculate the cargo limit.
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
     * Calculate the total weight of the {@link Item}s it's carrying and update the member variable accordingly.
     *
     * @return {@link #mCurrentCargoWeight} for easy access.
     */
    @Override
    public int carry(Item item) {
        return mCurrentCargoWeight += item.getWeight();
    }

    /**
     * Can the rocket carry the items weight?
     *
     * @return true if {@link #mCurrentCargoWeight} doesn't exceeds rocket's {@link #mCargoLimit} or else false.
     */
    @Override
    public boolean canCarry(Item item) {
        return (mCurrentCargoWeight + item.getWeight()) <= mCargoLimit;
    }

    /*
     * Public methods to get/set the values of the member variables from other classes.
     */
    int getCargoLimit() {
        return mCargoLimit;
    }

    int getCurrentCargoWeight() {
        return mCurrentCargoWeight;
    }

    public void setCurrentCargoWeight(int currentCargoWeight) {
        mCurrentCargoWeight = currentCargoWeight;
    }

    public int getCost() {
        return mCost;
    }

    public int getMaxWeight() {
        return mMaxWeight;
    }

    public int getRocketWeight() {
        return mRocketWeight;
    }
}