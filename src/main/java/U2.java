class U2 extends Rocket {
    private static final double CHANCE_OF_LAUNCH_EXPLOSION = 0.04;
    private static final double CHANCE_OF_LANDING_CRASH = 0.08;

    public U2() {
        super(29_000, 18_000, 120); // Rocket Max Weight, Rocket Weight, Rocket Cost
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