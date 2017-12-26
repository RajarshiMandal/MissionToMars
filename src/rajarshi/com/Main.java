package rajarshi.com;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Test if everything is going as planned.
        // Create a ArrayList of Item
        ArrayList<Item> itemArrayList = new ArrayList<>();
        itemArrayList.add(new Item("test 1", 8001));
        itemArrayList.add(new Item("test 2", 7999));

        // Create a rocket object
        Rocket rocketU1 = new Rocket(10000, 18000);

        // Create a for loop to get the values
        for (Item item : itemArrayList) {
            System.out.println("This is " + item.getName() +
                    "\nRocket can carry: " + rocketU1.getCargoLimit() +
                    " (excluding it's own weight of " + rocketU1.getRocketWeight() + ")" +
                    "\nGiven cargo weight: " + item.getWeight() +
                    "\nTotal Rocket Weight: " + rocketU1.carry(item) +
                    "\nCan it carry? " + rocketU1.canCarry(item) +
                    "\nLaunch chance: " + rocketU1.launch() +
                    "\nLand chance: " + rocketU1.land());
            System.out.println();
        }

    }
}
