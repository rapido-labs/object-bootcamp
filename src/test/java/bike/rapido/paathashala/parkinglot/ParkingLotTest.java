package bike.rapido.paathashala.parkinglot;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingLotTest {

    @Test
    public void shouldParkMyCar() {
        Car car = new Car();
        boolean parkedSuccessfully = new ParkingLot().park(car);

        assertThat(parkedSuccessfully, is(true));
    }
}
