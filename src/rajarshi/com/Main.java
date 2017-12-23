package rajarshi.com;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Test if everything is going as planned.
        // Create a ArrayList of Item
        ArrayList<Item> itemArrayList = new ArrayList<>();
        itemArrayList.add(new Item("test 1", 101));
        itemArrayList.add(new Item("test 2", 99));

        // Create a rocket object
        Rocket rocket = new Rocket(50, 150);

        // Create a for loop to get the values
        for (Item item : itemArrayList) {
            System.out.println("This is " + item.getName() +
                    "\nRocket can carry: " + rocket.getMaxLimit() +
                    "(including it's own weight of " + rocket.getRocketWeight() + ")" +
                    "\nGiven cargo weight: " + item.getWeight() +
                    "\nTotal Rocket Weight: " + rocket.carry(item) +
                    "\nCan it carry? " + rocket.canCarry(item));
            System.out.println();
        }

    }
}
