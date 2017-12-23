package raju.com;

public class Rocket implements SpaceShip {

    int mRocketWeight; // Weight of the rocket
    int mCargoLimit; // Maximum weight it can carry
    int mCurrentCargoWeight;

    public Rocket(int rocketWeight, int maxWeight) {
        mRocketWeight = rocketWeight;
        mCargoLimit = maxWeight;
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
        return mCurrentCargoWeight <= mCargoLimit;
    }

    @Override
    public int carry(Item weight) {
        // Calculate the total weight of the Rocket including the weight of the items it carry.
        return mCurrentCargoWeight = mRocketWeight + weight.getWeight();
    }

}
