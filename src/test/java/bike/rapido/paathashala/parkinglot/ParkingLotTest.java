package bike.rapido.paathashala.parkinglot;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingLotTest {

    private ParkingLotOwner lotOwner;

    @Before
    public void setUp() throws Exception {
        lotOwner = new ParkingLotOwner();
    }

    @Test
    public void shouldParkMyCar() {
        Car car = new Car();
        boolean parkedSuccessfully = new ParkingLot(5, lotOwner).park(car);

        assertThat(parkedSuccessfully, is(true));
    }

    @Test
    public void shouldUnparkMyCar() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(5, lotOwner);
        parkingLot.park(car);

        boolean unparkedSuccessfully = parkingLot.unpark(car);

        assertThat(unparkedSuccessfully, is(true));
    }

    @Test
    public void shouldNotBeAbleToUnparkACarWhichWasNeverParked() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(5, lotOwner);

        boolean unparkedSuccessfully = parkingLot.unpark(car);

        assertThat(unparkedSuccessfully, is(false));
    }

    @Test
    public void shouldNotBeAbleToParkTheSameCarTwiceWithOutUnparking() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(5, lotOwner);

        boolean parked = parkingLot.park(car);
        assertThat(parked, is(true));

        boolean parkedAgain = parkingLot.park(car);
        assertThat(parkedAgain, is(false));
    }

    @Test
    public void shouldLetParkingLotOwnerKnowWhenLotIsFull() {
        ParkingLotOwner lotOwner = new ParkingLotOwner();
        ParkingLot parkingLot = new ParkingLot(1, lotOwner);
        Car car = new Car();

        boolean parked = parkingLot.park(car);

        assertThat(parked, is(true));
        assertThat(lotOwner.isLotFull(), is(true));
    }

    @Test
    public void shouldNotLetOwnerKnowWhenCarIsParkedAndStillHasMoreFreeSlots() {
        ParkingLotOwner lotOwner = new ParkingLotOwner();
        ParkingLot parkingLot = new ParkingLot(5, lotOwner);
        Car car = new Car();

        boolean parked = parkingLot.park(car);

        assertThat(parked, is(true));
        assertThat(lotOwner.isLotFull(), is(false));
    }
}
