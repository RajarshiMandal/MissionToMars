package raju.com;

/**
 * SpaceShip Interface that includes the definitions of the required methods
 */
public interface SpaceShip {
    /**
     * @return true or false indicating if the launch was successful or not
     */
    boolean launch();

    /**
     * @return either true or false based on the success of the landing.
     */
    boolean land();

    /**
     * A method that takes an Item object and updates the current weight.
     * @param weight is the weight of the object.
     * @return an integer value of the current weight of the rocket.
     */
    int carry(Item weight);

    /**
     * Takes an Item as an argument and
     *
     * @return true if the rocket can carry such item or false if it will exceed the weight limit.
     */
    boolean canCarry(Item items);
}
