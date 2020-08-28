package spacechallenge;

public abstract class Rocket implements SpaceShip {
    protected int currentWeight;
    protected int maxWeight;
    private int cost;

    public Rocket(int maxWeight, int cost) {
        currentWeight = 0;
        this.maxWeight = maxWeight;
        this.cost = cost;
    }

    @Override
    public boolean canCarry(Item item) {

        if (item.getWeight() < maxWeight - currentWeight) {
            return true;

        }
        return false;
    }

    @Override
    public void carry(Item item) {
        currentWeight += item.getWeight();

    }

    public int getCost() {
        return cost;
    }
}
