public enum PlaneType {

    BOEING747(200, 500);

    private final int capacity, weightLimit;
    PlaneType(int capacity, int weightLimit) {
        this.capacity = capacity;
        this.weightLimit = weightLimit;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getWeightLimit() {
        return weightLimit;
    }
}
