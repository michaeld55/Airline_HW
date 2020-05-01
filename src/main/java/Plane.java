import java.util.ArrayList;

public class Plane {

    private PlaneType planeType;


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