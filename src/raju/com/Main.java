package raju.com;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Item item = new Item("tools", 110);
        Rocket rocket = new Rocket(50, 150);

        System.out.println("Max weight it can carry:\t" + rocket.mCargoLimit +
                "\nCargo weight:\t" + item.getWeight() +
                "\nTotal weight:\t" + rocket.carry(item) +
                "\nCan it carry:\t" + rocket.canCarry(item));

    }
}
