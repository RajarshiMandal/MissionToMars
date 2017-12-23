package rajarshi.com;

/**
 * Item class that includes a String name and an int weight that will
 * represent an item to be carried by the rockets.
 */

public class Item {

    private String mName; // Stores the name of the items
    private int mWeight; // Stores the wieght of the items

    /**
     * The Constructor
     * @param name   is the name of the items.
     * @param weight is the weight of each items.
     */
    Item(String name, int weight) {
        mName = name;
        mWeight = weight;
    }

    /**
     * All the getter and setter methods to
     *
     * @return that perticular variable of the Object Item.
     */

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getWeight() {
        return mWeight;
    }

    public void setWeight(int mWeight) {
        this.mWeight = mWeight;
    }
}
