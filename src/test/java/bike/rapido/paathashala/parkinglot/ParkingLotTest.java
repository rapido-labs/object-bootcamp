package bike.rapido.paathashala.parkinglot;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingLotTest {

    @Test
    public void shouldParkMyCar() {
        Car car = new Car();
        boolean parkedSuccessfully = new ParkingLot(5).park(car);

        assertThat(parkedSuccessfully, is(true));
    }

    @Test
    public void shouldUnparkMyCar() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(5);
        parkingLot.park(car);

        boolean unparkedSuccessfully = parkingLot.unpark(car);

        assertThat(unparkedSuccessfully, is(true));
    }

    @Test
    public void shouldNotBeAbleToUnparkACarWhichWasNeverParked() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(5);

        boolean unparkedSuccessfully = parkingLot.unpark(car);

        assertThat(unparkedSuccessfully, is(false));
    }

    @Test
    public void shouldNotBeAbleToParkTheSameCarTwiceWithOutUnparking() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(5);

        boolean parked = parkingLot.park(car);
        assertThat(parked, is(true));

        boolean parkedAgain = parkingLot.park(car);
        assertThat(parkedAgain, is(false));
    }

}
