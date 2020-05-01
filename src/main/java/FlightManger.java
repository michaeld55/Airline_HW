import java.util.ArrayList;

public class FlightManger {

    private int reservedWeight;
    private Plane plane;
    private ArrayList<Passenger> passengers;

    public FlightManger(Flight flight){
        this.plane = flight.getPlane();
        this.passengers = flight.getPassengers();
    }

    public int getReservedWeight(){
        reservedWeight = plane.getWeightLimit() / 2;
        return reservedWeight;
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
