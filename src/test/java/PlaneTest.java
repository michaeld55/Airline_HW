import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {
    private Plane plane;

    private Passenger passenger;

    @Before
    public void before(){
        plane = new Plane(PlaneType.BOEING747);
        passenger = new Passenger("Bob", 3);
    }

    @Test
    public void canGetPlaneTypeInfo(){
        assertEquals(PlaneType.BOEING747, plane.getPlaneType());
        assertEquals(200, plane.getCapacity());
        assertEquals(500, plane.getWeightLimit());
    }


}
