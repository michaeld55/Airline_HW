import java.util.ArrayList;

public class FlightManger {

    private final Plane plane;
    private final ArrayList<Passenger> passengers;

    public FlightManger(Flight flight){
        this.plane = flight.getPlane();
        this.passengers = flight.getPassengers();
    }

    public int getReservedWeight(){
        return plane.getWeightLimit() / 2;
    }

    public Plane getPlane() {
        return plane;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public int getBagCount(){
        int total = 0;
        for (Passenger passenger: passengers) {
            total += passenger.getBags();
        }
        return total;
    }

    public int getAvailableWeight() {
        return getReservedWeight() - getBagCount();
    }
}
