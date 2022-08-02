package bike.rapido.paathashala.parkinglot;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingLotTest {

    private ParkingLotOwner lotOwner;
    private SecurityPerson securityPerson;

    @Before
    public void setUp() {
        lotOwner = new ParkingLotOwner();
        securityPerson = new SecurityPerson();
    }

    @Test
    public void shouldParkMyCar() {
        Car car = new Car();
        boolean parkedSuccessfully = new ParkingLot(5, lotOwner, securityPerson).park(car);

        assertThat(parkedSuccessfully, is(true));
    }

    @Test
    public void shouldUnparkMyCar() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(5, lotOwner, securityPerson);
        parkingLot.park(car);

        boolean unparkedSuccessfully = parkingLot.unpark(car);

        assertThat(unparkedSuccessfully, is(true));
    }

    @Test
    public void shouldNotBeAbleToUnparkACarWhichWasNeverParked() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(5, lotOwner, securityPerson);

        boolean unparkedSuccessfully = parkingLot.unpark(car);

        assertThat(unparkedSuccessfully, is(false));
    }

    @Test
    public void shouldNotBeAbleToParkTheSameCarTwiceWithOutUnparking() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(5, lotOwner, securityPerson);

        boolean parked = parkingLot.park(car);
        assertThat(parked, is(true));

        boolean parkedAgain = parkingLot.park(car);
        assertThat(parkedAgain, is(false));
    }

    @Test
    public void shouldLetParkingLotOwnerKnowWhenLotIsFull() {
        ParkingLotOwner lotOwner = new ParkingLotOwner();
        ParkingLot parkingLot = new ParkingLot(1, lotOwner, securityPerson);
        Car car = new Car();

        boolean parked = parkingLot.park(car);

        assertThat(parked, is(true));
        assertThat(lotOwner.isLotFull(), is(true));
    }

    @Test
    public void shouldNotLetOwnerKnowWhenCarIsParkedAndStillHasMoreFreeSlots() {
        ParkingLotOwner lotOwner = new ParkingLotOwner();
        ParkingLot parkingLot = new ParkingLot(5, lotOwner, securityPerson);
        Car car = new Car();

        boolean parked = parkingLot.park(car);

        assertThat(parked, is(true));
        assertThat(lotOwner.isLotFull(), is(false));
    }

    @Test
    public void shouldLetSecurityPersonKnowWhenLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1, new ParkingLotOwner(), securityPerson);
        Car car = new Car();

        boolean parked = parkingLot.park(car);

        assertThat(parked, is(true));
        assertThat(securityPerson.isLotFull(), is(true));
    }

    @Test
    public void shouldNotLetSecurityPersonKnowWhenLotIsNotFilled() {
        ParkingLot parkingLot = new ParkingLot(5, new ParkingLotOwner(), securityPerson);
        Car car = new Car();

        boolean parked = parkingLot.park(car);

        assertThat(parked, is(true));
        assertThat(securityPerson.isLotFull(), is(false));
    }
}
