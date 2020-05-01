import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.assertEquals;

public class FlightMangerTest {

    private Flight flight;
    private Plane plane;
    private Passenger passenger;
    private FlightManger flightManger;


    @Before
    public void before(){
        passenger = new Passenger("Bob", 3);
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane,"FR756", "EDI", "GLA", "18:00:00");
        flightManger = new FlightManger(flight);
    }

    @Test
    public void canGetFlightMangerInfo(){
        flight.addPassenger(passenger);
        assertEquals(250, flightManger.getReservedWeight());
        assertEquals(plane, flightManger.getPlane());
        assertEquals(1, flightManger.getPassengers().size());
    }

    @Test
    public void canGetBagCount(){
        flight.addPassenger(passenger);
        assertEquals(3, flightManger.getBagCount());
    }

    @Test
    public void canRemaingWeight(){
        flight.addPassenger(passenger);
        assertEquals(247, flightManger.getAvailableWeight());
    }

    @Test
    public void whatHappensToFullPlane(){
        for (int i = 0; i < 200; i++) {
            flight.addPassenger(passenger);
        }
        assertEquals(249, flightManger.getBagCount());
        assertEquals(1, flightManger.getAvailableWeight());
    }
}
