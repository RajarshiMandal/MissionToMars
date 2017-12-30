package rajarshi.com;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * A Simulation class that is responsible for reading item data and filling up the rockets.
 */
public class Simulation {

    /**
     * A blank Constructor for this class; used to initialize the instances of this class.
     */
    Simulation() {
    }

    /**
     * This method loads all items from a text file and returns an ArrayList of Items.
     *
     * @param phaseTxtFile is the file that contain the Items for each phases.
     * @return the List of Items stored in an array.
     */
    List<Item> loadItems(String phaseTxtFile) {
        List<Item> mItemList = new ArrayList<>();

        try {
            // Ambiguous Method inside scanner!
            Scanner scanner = new Scanner(new FileReader(phaseTxtFile));
            while (scanner.hasNextLine()) {
                // Split the string into 2 and put them into an array.
                String[] stringArray = scanner.nextLine().split("=");
                // Get the array values and start adding it to ArrayList of Items
                String name = stringArray[0].trim();
                int weight = Integer.parseInt(stringArray[1].trim());
                mItemList.add(new Item(name, weight));
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return mItemList;
    }

    /**
     * This method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
     *
     * @param itemList is the List of Items that are stored in the ArrayList.
     * @param u$1      is the {@link U$1} object that this method will work upon. (Pass by Reference!)
     * @return the list of U$1 rockets loaded with Items.
     */
    List<U$1> loadU$1(List<Item> itemList, U$1 u$1) {
        List<U$1> u$1List = new ArrayList<>();

        while (!itemList.isEmpty()) {
            // Let's try something new instead of conventional for loop.
            for (ListIterator<Item> iterator = itemList.listIterator(); iterator.hasNext(); ) {
                Item item = iterator.next();
                // If can carry the weight of the Item...
                if (u$1.canCarry(item)) {
                    // Store it separately to {@link Rocket#mCurrentCargoWeight)...
                    u$1.carry(item);
                    // Remove the item from the Item ArrayList.
                    iterator.remove();
                } else {        // Only for performance for large ArrayLists, telling that...
                    continue;   // Don't go below, stay within the *if.
                }
                // Don't have to read all the contents of the Item ArrayList if the condition matches.
                if (u$1.getCurrentCargoWeight() == u$1.getCargoLimit()) {
                    break;
                }
            }
            // Add the items to the U$1 Rocket.
            u$1List.add(new U$1(u$1.getRocketWeight(), u$1.getMaxWeight(), u$1.getCost(), u$1.getCurrentCargoWeight()));
            // Clear the space for next items.
            u$1.setCurrentCargoWeight(0);
        }
        System.out.println("Total U1 Rockets loaded: " + u$1List.size() + ((u$1List.size() > 4) ? " for Phase 1" : " for Phase 2"));
        return u$1List;
    }

    /**
     * This method takes the ArrayList of Items returned from loadItems and starts creating U2 rockets.
     */
    List<U$2> loadU$2(List<Item> itemList, U$2 u$2) {
        List<U$2> u$2List = new ArrayList<>();

        while (!itemList.isEmpty()) {
            // Using the conventional for loop.
            for (int i = 0; i < itemList.size(); i++) {
                if (u$2.canCarry(itemList.get(i))) {
                    u$2.carry(itemList.get(i));
                    itemList.remove(i);
                } else {
                    continue;
                }
                if (u$2.getCurrentCargoWeight() == u$2.getCargoLimit()) {
                    break;
                }
            }

            u$2List.add(new U$2(u$2.getRocketWeight(), u$2.getMaxWeight(), u$2.getCost(), u$2.getCurrentCargoWeight()));
            u$2.setCurrentCargoWeight(0);
        }

        System.out.println("Total U2 Rockets: " + u$2List.size() + ((u$2List.size() > 4) ? " for Phase 1" : " for Phase 2"));
        return u$2List;
    }

    /**
     * Method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList
     */
    void runSimulation(List<Rocket> rockets) {

        int launchRocket = 0;
        int rocketFailed = 0;
        int cost = 0;

        while (!rockets.isEmpty()) {
            for (ListIterator<Rocket> iterator = rockets.listIterator(); iterator.hasNext(); ) {
                Rocket rocketAtI = iterator.next();
                // iterator.next() || iterator.previous() ? same : not same
                // Basically saving the values for those *unnecessary steps.
                Rocket rocketAtP = iterator.previous();
                // It's sceptical to learn using the debugger how the objects (the prototype rockets) withing the
                // List of Rockets did call their own land and launch methods
                if (rocketAtI.launch() && rocketAtI.land()) {
                    launchRocket++;
                    cost += iterator.next().getCost();
                    // Launched and landed successfully.
                    iterator.remove();

                } else {
                    launchRocket++;
                    rocketFailed++;
                    cost += iterator.next().getCost();
                    // Unnecessary steps...
                    // Well, something went Wrong and thus had to create a new Rocket.
                    iterator.remove();
                    iterator.add(rocketAtP);
                    // ...up to this but helpful for learning how ArrayList works.

                }
            }
        }
        System.out.println("Total Rockets launched: " + launchRocket);
        System.out.println("Total lost: " + rocketFailed);
        System.out.println("Total Cost: $" + cost + " Millions");
    }

}
