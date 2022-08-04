package bike.rapido.paathashala.parkinglot;

import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class ParkingLotNotificationsTest {


    @Test
    public void shouldLetParkingLotOwnerKnowWhenLotIsFull() {
        ParkingLotOwner parkingLotOwnerMock = Mockito.mock(ParkingLotOwner.class);
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.register(parkingLotOwnerMock);
        Car car = new Car();

        boolean parked = parkingLot.park(car);

        assertThat(parked, is(true));
        verify(parkingLotOwnerMock).notifyLotFull();
    }

    @Test
    public void shouldNotLetOwnerKnowWhenCarIsParkedAndStillHasMoreFreeSlots() {
        ParkingLotOwner parkingLotOwnerMock = Mockito.mock(ParkingLotOwner.class);
        ParkingLot parkingLot = new ParkingLot(5);
        parkingLot.register(parkingLotOwnerMock);

        Car car = new Car();

        boolean parked = parkingLot.park(car);

        assertThat(parked, is(true));
        verify(parkingLotOwnerMock, never()).notifyLotFull();
    }

    @Test
    public void shouldLetSecurityPersonKnowWhenLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        SecurityPerson securityPersonMock = Mockito.mock(SecurityPerson.class);
        parkingLot.register(securityPersonMock);
        Car car = new Car();

        boolean parked = parkingLot.park(car);

        assertThat(parked, is(true));
        verify(securityPersonMock).notifyLotFull();
    }

    @Test
    public void shouldNotLetSecurityPersonKnowWhenLotIsNotFilled() {
        ParkingLot parkingLot = new ParkingLot(5);
        SecurityPerson securityPersonMock = Mockito.mock(SecurityPerson.class);
        parkingLot.register(securityPersonMock);
        Car car = new Car();

        boolean parked = parkingLot.park(car);

        assertThat(parked, is(true));
        verify(securityPersonMock, never()).notifyLotFull();
    }
}
