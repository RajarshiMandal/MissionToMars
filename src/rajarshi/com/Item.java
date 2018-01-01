package rajarshi.com;

/**
 * Item class that includes a Name and Weight that will represent an item to be carried by the rockets.
 */
public class Item {

    private String mName; // Stores the name of the items
    private int mWeight; // Stores the weight of the items

    /**
     * The Constructor
     *
     * @param name   is the name of the items.
     * @param weight is the weight of each items.
     */
    Item(String name, int weight) {
        mName = name;
        mWeight = weight;
    }

    /*
     * All the getter methods to return that particular variable of the Object Item.
     */
    public String getName() {
        return mName;
    }

    public int getWeight() {
        return mWeight;
    }

    public int setWeight(int weight) {
        return mWeight = weight;
    }

}
