package raju.com;

public interface SpaceShip {
    /**
     * @return true or false indicating if the launch was successful or if the rocket has crashed
     */
    boolean launch();

    /**
     * @return either true or false based on the success of the landing.
     */
    boolean land();

    /**
     * Takes an Item as an argument and
     *
     * @return true if the rocket can carry such item or false if it will exceed the weight limit
     */
    boolean canCarry(Item items);


    int carry(Item weight);
}
