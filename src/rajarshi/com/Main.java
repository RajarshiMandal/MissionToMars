package rajarshi.com;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Test if everything is going as planned.
        // Create a ArrayList of Item
        List<Item> arrayList = new ArrayList<>();
        arrayList.add(new Item("tools", 4000));
        arrayList.add(new Item("tools", 5000));
        arrayList.add(new Item("tools", 4000));

        // Create a rocket object
        U$1 rocketU1 = new U$1(10000, 18000);

        for (Item item : arrayList) {
            if (rocketU1.canCarry(item)) {
                System.out.println(rocketU1.carry(item) + " " + rocketU1.canCarry(item));
            }
        }
    }
}

