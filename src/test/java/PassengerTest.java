import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;

    @Before
    public void before(){
        passenger = new Passenger("Bob", 3);
    }

    @Test
    public void canGetInfo(){
        assertEquals("Bob", passenger.getName());
        assertEquals(3, passenger.getBags());

    }

}
