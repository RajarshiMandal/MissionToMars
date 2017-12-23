package rajarshi.com;

/**
 * The Rocket class that implements {@link SpaceShip} interface and thus has to
 * override methods.
 */
public class Rocket implements SpaceShip {

    private int mRocketWeight; // Weight of the rocket
    private int mMaxLimit; // Maximum weight it can carry
    private int mCurrentRocketWeight; // Current weight of the rocket including Item weight.

    /**
     * The constructor of the Rocket Object that takes in 2 parameters.
     *
     * @param rocketWeight is the weight of the rocket itself
     * @param maxLimit     is the weight of a rocket can carry including it's own weight.
     */
    Rocket(int rocketWeight, int maxLimit) {
        mRocketWeight = rocketWeight;
        mMaxLimit = maxLimit;
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
     * @return {@link #mCurrentRocketWeight} for easy access.
     */
    @Override
    public int carry(Item weight) {
        // Calculate the total weight of the Rocket including the weight of the items it's carrying.
        return mCurrentRocketWeight = mRocketWeight + weight.getWeight();
    }

    /**
     * @return true if the {@link #mCurrentRocketWeight} doesn't exceeds rocket's
     * {@link #mMaxLimit} or false is so happens.
     */
    @Override
    public boolean canCarry(Item item) {
        return mCurrentRocketWeight <= mMaxLimit;
    }

    // Public method to @return {@link #mRocketWeight}
    int getRocketWeight() {
        return mRocketWeight;
    }

    // Public method to @return {@link #mMaxLimit}
    int getMaxLimit() {
        return mMaxLimit;
    }

    // Public method to @return {@link #mCurrentRocketWeight}
    public int getCurrentRocketWeight() {
        return mCurrentRocketWeight;
    }
}
