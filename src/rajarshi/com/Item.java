package rajarshi.com;

public class Item {

    private String mName;
    private int mWeight;

    /**
     * The Constructor
     *
     * @param name   is the name of the items
     * @param weight is the weight of each items
     */
    Item(String name, int weight) {
        mName = name;
        mWeight = weight;
    }

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
