package rajarshi.com;

/**
 * The Rocket class that implements {@link SpaceShip} interface and thus has to
 * override methods.
 */
public class Rocket implements SpaceShip {

    private int mRocketWeight; // Weight of the rocket
    private int mCargoLimit; // Maximum weight it can carry
    private int mCurrentRocketWeight; // Current weight of the rocket including Item weight.

    /**
     * The constructor of the Rocket Object that takes in 2 parameters.
     *
     * @param rocketWeight is the weight of the rocket itself
     * @param cargoLimit     is the weight of a rocket can carry including it's own weight.
     */
    Rocket(int rocketWeight, int cargoLimit) {
        mRocketWeight = rocketWeight;
        mCargoLimit = cargoLimit - rocketWeight;
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
    public int carry(Item item) {
        // Calculate the total weight of the Rocket including the weight of the items it's carrying.
        return mCurrentRocketWeight = item.getWeight() + mRocketWeight;
    }

    /**
     * @return true if the {@link #mCurrentRocketWeight} doesn't exceeds rocket's
     * total weight of the rocket
     */
    @Override
    public boolean canCarry(Item item) {
        return mCurrentRocketWeight <= (mCargoLimit + mRocketWeight);
    }

    /*
     * Public methods to get the value of the member variables
     */
    int getRocketWeight() {
        return mRocketWeight;
    }

    int getCargoLimit() {
        return mCargoLimit;
    }


    public int getCurrentRocketWeight() {
        return mCurrentRocketWeight;
    }
}
