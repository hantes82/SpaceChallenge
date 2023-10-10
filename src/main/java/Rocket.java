class Rocket implements SpaceShip {
    private int currentWeight;
    private int rocketMaxWeight;
    private int rocketWeight;
    private int rocketCost;

    public Rocket(int rocketMaxWeight, int rocketWeight, int rocketCost) {
        this.rocketMaxWeight = rocketMaxWeight;
        this.rocketWeight = rocketWeight;
        this.rocketCost = rocketCost;
        this.currentWeight = rocketWeight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getRocketMaxWeight() {
        return rocketMaxWeight;
    }

    public int getRocketWeight() {
        return rocketWeight;
    }

    public int getRocketCost() {
        return rocketCost;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return (currentWeight + item.getWeight()) <= rocketMaxWeight;
    }

    @Override
    public void carry(Item item) {
        currentWeight += item.getWeight();
    }
}
