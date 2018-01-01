package rajarshi.com;

/**
 * SpaceShip Interface that includes the definitions of the required methods to build anything that is, well,
 * a spaceship.
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
     * A method that takes Item objects and updates the current weight loaded into the Rocket.
     *
     * @param weight is the weight of the object.
     * @return an integer value of the current weight of the rocket including the weight of the given item.
     */
    int carry(Item weight);

    /**
     * Takes an Item as an argument
     *
     * @return true if the rocket can carry such item or false if it will exceed the weight limit.
     */
    boolean canCarry(Item items);
}
