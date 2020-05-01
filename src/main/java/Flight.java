import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Flight {

    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private String destinationAirport;
    private String departureAirport;
    private Date dateTime;
    private ArrayList<Integer> seatNumbers;


    public Flight(Plane plane, String flightNumber, String destinationAirport, String departureAirport, String time) {
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destinationAirport = destinationAirport;
        this.departureAirport = departureAirport;

        try {
            dateTime = new SimpleDateFormat("HH:mm").parse(time);

        } catch (ParseException e){
            System.out.println(e.getMessage());
        }

        int numbers = this.plane.getCapacity();
        seatNumbers = new ArrayList<>();
        for (int i = 1; i <= numbers; i++) {

            seatNumbers.add(i);
        }
        Collections.shuffle(seatNumbers);
        this.passengers = new ArrayList<Passenger>();
    }

    public Plane getPlane() {
        return plane;
    }

    public void addPassenger(Passenger passenger) {
        if(getEmptySeats() > 0) {
            FlightManger flightManger = new FlightManger(this);
            if (flightManger.getAvailableWeight() > passenger.getBags()) {
                this.passengers.add(passenger);
                passenger.setFlight(this);
                passenger.setSeatNumber(this.getSeatNumber());
            }
        }
    }

    private int getSeatNumber() {

        int randomSeat = seatNumbers.get(0);
        seatNumbers.remove(0);
        return randomSeat;
    }

    public int getPassengerCount() {
        return this.passengers.size();
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getFlightTime() {
        DateFormat flightTime = new SimpleDateFormat("HH:mm", Locale.getDefault());
        String newTime;
        return newTime = flightTime.format(this.dateTime);
    }

    public int getEmptySeats() {
        return plane.getCapacity() - passengers.size();
    }
}
