package raju.com;

public class Item {
    private String mName;
    private int mWeight;

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
