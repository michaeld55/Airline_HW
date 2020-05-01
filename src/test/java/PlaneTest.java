import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {
    private Plane plane;
    private Plane plane1;

    @Before
    public void before(){
        plane = new Plane(PlaneType.BOEING747);
        plane1 = new Plane(PlaneType.AIRBUSA380);

    }

    @Test
    public void canGetPlaneTypeInfo(){
        assertEquals(PlaneType.BOEING747, plane.getPlaneType());
        assertEquals(200, plane.getCapacity());
        assertEquals(500, plane.getWeightLimit());
        assertEquals(PlaneType.AIRBUSA380, plane1.getPlaneType());
        assertEquals(300, plane1.getCapacity());
        assertEquals(600, plane1.getWeightLimit());
    }


}
