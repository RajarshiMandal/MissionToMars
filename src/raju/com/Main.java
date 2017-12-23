package raju.com;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Item item = new Item("tools", 101);
        Rocket rocket = new Rocket(50, 100);

        System.out.println("Rocket can carry: " + rocket.getMaxLimit() +
                "(including it's own weight of " + rocket.getRocketWeight() + ")" +
                "\nGiven cargo weight: " + item.getWeight() +
                "\nTotal Rocket Weight: " + rocket.carry(item) +
                "\nCan it carry? " + rocket.canCarry(item));

    }
}
