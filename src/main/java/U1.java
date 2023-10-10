class U1 extends Rocket {
    private static final double CHANCE_OF_LAUNCH_EXPLOSION = 0.05;
    private static final double CHANCE_OF_LANDING_CRASH = 0.01;

    public U1() {
        super(18_000, 10_000, 100);
    }

    @Override
    public boolean launch() {
        double randomNum = Math.random();
        double cargoCarried = this.getCurrentWeight() - getRocketWeight();
        double cargoLimit = getRocketMaxWeight() - getRocketWeight();
        double chanceOfExplosion = CHANCE_OF_LAUNCH_EXPLOSION * (cargoCarried / cargoLimit);
        return randomNum > chanceOfExplosion;
    }

    @Override
    public boolean land() {
        double randomNum = Math.random();
        double cargoCarried = this.getCurrentWeight() - getRocketWeight();
        double cargoLimit = getRocketMaxWeight() - getRocketWeight();
        double chanceOfCrash = CHANCE_OF_LANDING_CRASH * (cargoCarried / cargoLimit);
        return randomNum > chanceOfCrash;
    }
}