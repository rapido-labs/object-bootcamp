package bike.rapido.paathashala.parkinglot;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingLotNotificationsTest {


    @Test
    public void shouldLetParkingLotOwnerKnowWhenLotIsFull() {
        ParkingLotOwner lotOwner = new ParkingLotOwner();
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.register(lotOwner);
        Car car = new Car();

        boolean parked = parkingLot.park(car);

        assertThat(parked, is(true));
        assertThat(lotOwner.isLotFull(), is(true));
    }

    @Test
    public void shouldNotLetOwnerKnowWhenCarIsParkedAndStillHasMoreFreeSlots() {
        ParkingLotOwner lotOwner = new ParkingLotOwner();
        ParkingLot parkingLot = new ParkingLot(5);
        parkingLot.register(lotOwner);

        Car car = new Car();

        boolean parked = parkingLot.park(car);

        assertThat(parked, is(true));
        assertThat(lotOwner.isLotFull(), is(false));
    }

    @Test
    public void shouldLetSecurityPersonKnowWhenLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        SecurityPerson securityPerson = new SecurityPerson();
        parkingLot.register(securityPerson);
        Car car = new Car();

        boolean parked = parkingLot.park(car);

        assertThat(parked, is(true));
        assertThat(securityPerson.isLotFull(), is(true));
    }

    @Test
    public void shouldNotLetSecurityPersonKnowWhenLotIsNotFilled() {
        ParkingLot parkingLot = new ParkingLot(5);
        SecurityPerson securityPerson = new SecurityPerson();
        parkingLot.register(securityPerson);
        Car car = new Car();

        boolean parked = parkingLot.park(car);

        assertThat(parked, is(true));
        assertThat(securityPerson.isLotFull(), is(false));
    }
}
