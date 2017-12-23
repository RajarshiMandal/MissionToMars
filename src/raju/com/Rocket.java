package raju.com;

public class Rocket implements SpaceShip {

    private int mRocketWeight; // Weight of the rocket
    private int mMaxLimit; // Maximum weight it can carry
    private int mCurrentRocketWeight;

    Rocket(int rocketWeight, int maxLimit) {
        mRocketWeight = rocketWeight;
        mMaxLimit = maxLimit + rocketWeight;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        // @return true if total weight is less than max weight it can carry or false.
        return mCurrentRocketWeight <= mMaxLimit;
    }

    @Override
    public int carry(Item weight) {
        // Calculate the total weight of the Rocket including the weight of the items it carry.
        return mCurrentRocketWeight = mRocketWeight + weight.getWeight();
    }

    int getRocketWeight() {
        return mRocketWeight;
    }

    int getMaxLimit() {
        return mMaxLimit;
    }

    public int getCurrentRocketWeight() {
        return mCurrentRocketWeight;
    }
}
