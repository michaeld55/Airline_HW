import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightTest {
    private Flight flight;
    private Passenger passenger;

    @Before
    public void before(){

        passenger = new Passenger("bob", 3);
        Plane plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane,"FR756", "EDI", "GLA", "18:00:00");
    }

    @Test
    public void canGetFlightInfo(){
        assertEquals("FR756", flight.getFlightNumber());
        assertEquals("EDI", flight.getDestinationAirport());
        assertEquals("GLA", flight.getDepartureAirport());
        assertEquals("18:00", flight.getFlightTime());
    }

    @Test
    public void planeStartsEmpty(){
        assertEquals(0, flight.getPassengerCount());
    }

    @Test
    public void canAddPassenger(){
        flight.addPassenger(passenger);
        assertEquals(1, flight.getPassengerCount());
        assertEquals(flight, passenger.getFlight());

        assert( passenger.getSeatNumber() > 0);
        assert( passenger.getSeatNumber() < 201);
    }

    @Test
    public void canGetReamingSeats(){
        flight.addPassenger(passenger);
        assertEquals(199, flight.getEmptySeats());
    }

    @Test
    public void cantAddToFullPlane(){

        for (int i = 0; i < 200; i++) {

            flight.addPassenger(passenger);
        }
        flight.addPassenger(passenger);
        flight.addPassenger(passenger);
        assertEquals(83, flight.getPassengerCount());
        assertEquals(117, flight.getEmptySeats());
    }

    @Test
    public void doesntDoubleBook(){
        for (int i = 0; i < 200; i++) {
            Passenger passenger1 = new Passenger("Joe", 1);
            flight.addPassenger(passenger1);
        }
        ArrayList<Passenger> testPassengers = flight.getPassengers();

        ArrayList<Integer> duplicateCheck = new ArrayList<>();
        for (Passenger passenger: testPassengers) {
            if(!duplicateCheck.contains(passenger.getSeatNumber())){
                duplicateCheck.add(passenger.getSeatNumber());
            }

        }

        assertEquals( testPassengers.size(), duplicateCheck.size());
        assertEquals(200, flight.getPassengerCount());
        assertEquals(0, flight.getEmptySeats());
    }
}
