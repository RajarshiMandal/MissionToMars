package rajarshi.com;

import com.sun.istack.internal.NotNull;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * A Simulation class that is responsible for reading item data and filling up the rockets.
 */
public class Simulation {
    // Text File Locations
    private List<List<Item>> allItems = new ArrayList<>();

    /**
     * A Constructor for this class; used to initialize the instances of this class.
     *
     * @param phases are the text files for phases, separated by commas.
     */
    Simulation(String... phases) {
        for (String phase : phases) {
            // Get the array and add it to anther List{@link #allItems)
            allItems.add(loadItems(phase));
        }
    }

    /**
     * This method loads all items from a text file and returns an ArrayList of Items.
     *
     * @param txtFile is the phase that contain the Items for each phases.
     * @return the List of Items stored in an array.
     */
    private List<Item> loadItems(String txtFile) {
        // List to return.
        List<Item> mItemList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new FileReader(txtFile));
            while (scanner.hasNextLine()) {
                // Split the string into 2 and put them into an array.
                String[] stringArray = scanner.nextLine().split("=");
                // Get the array values and start adding it to ArrayList of Items
                String name = stringArray[0].trim();
                int weight = Integer.parseInt(stringArray[1].trim());
                mItemList.add(new Item(name, weight));
            }
            scanner.close();
        } catch (NullPointerException e) {
            System.err.println("Error: Wrong phase number");
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

        return mItemList;
    }

    /**
     * This method takes the ArrayList of Items returned from {@link #allItems} and starts creating U1 rockets.
     *
     * @param u$1 is the {@link U$1} object that this method will work upon. (Pass by Reference!)
     * @return the list of U$1 rockets loaded with Items.
     */
    @NotNull
    List<U$1> loadU$1(U$1 u$1) {
        // List to return
        List<U$1> u$1List = new ArrayList<>();
        // Get the phase count to display
        int phaseCount = 0;

        // Do the calculations for each List in {@link #allItems)
        for (List<Item> allItem : allItems) {
            // For displaying how many U1 rockets loaded.
            int rocketsLoaded = u$1List.size();
            // Copy each list to a new ArrayList to retain main List from being getting destroyed.
            List<Item> itemList = new ArrayList<>(allItem);

            // Load the items from store to U1s and make place for new items
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
                u$1List.add(new U$1(u$1.getRocketWeight(), u$1.getMaxWeight(),
                        u$1.getCost(), u$1.getCurrentCargoWeight()));
                // Clear the space for next items.
                u$1.setCurrentCargoWeight(0);
            }

            System.out.println("Total U$1 Rockets loaded for Phase " + (++phaseCount) + ": "
                    + (u$1List.size() - rocketsLoaded));
        }

        return u$1List;
    }

    /**
     * This method takes the ArrayList of Items returned from {@link #allItems} and starts creating {@link U$2} rockets.
     */
    @NotNull
    List<U$2> loadU$2(U$2 u$2) {
        List<U$2> u$2List = new ArrayList<>();
        int phaseCount = 0;

        for (List<Item> allItem : allItems) {
            int rocketsLoaded = u$2List.size();

            while (!allItem.isEmpty()) {
                // Using the conventional for loop.
                for (int i = 0; i < allItem.size(); i++) {
                    if (u$2.canCarry(allItem.get(i))) {
                        u$2.carry(allItem.get(i));
                        allItem.remove(i);
                    } else {
                        continue;
                    }
                    if (u$2.getCurrentCargoWeight() == u$2.getCargoLimit()) {
                        break;
                    }
                }

                u$2List.add(new U$2(u$2.getRocketWeight(), u$2.getMaxWeight(),
                        u$2.getCost(), u$2.getCurrentCargoWeight()));
                u$2.setCurrentCargoWeight(0);
            }

            System.out.println("Total U$2 Rockets loaded for Phase " + (++phaseCount) + ": "
                    + (u$2List.size() - rocketsLoaded));
        }

        return u$2List;
    }

    /**
     * Method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList
     * @param rocketPrototypes are the returned list of U$1 and/or U$2 Rockets.
     */
    @SafeVarargs
    final void runSimulation(List<? extends Rocket>... rocketPrototypes) {
        // Create Rocket List and add all the U1s and U2s.
        List<Rocket> rockets = new ArrayList<>();
        for (List rocketObjects : rocketPrototypes) {
            rockets.addAll(rocketObjects);
            String name = rockets.get(0).getClass().getSimpleName();
            //rockets.addAll(phase2Rockets);

            int launchRocket = 0; // Total number of rockets launched.
            int rocketFailed = 0; // Total number of rockets got destroyed.
            int cost = 0; // Total cost

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
            System.out.println();
            System.out.println("Total " + name + " launched: " + launchRocket);
            System.out.println("Total lost: " + rocketFailed);
            System.out.println("Total Cost: $" + cost + " Millions");
        }
    }

}
