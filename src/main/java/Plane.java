public class Plane {

    private final PlaneType planeType;


    public Plane(PlaneType planeType) {
        this.planeType = planeType;

    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public int getCapacity() {
        return planeType.getCapacity();
    }

    public int getWeightLimit() {
        return planeType.getWeightLimit();
    }


}
