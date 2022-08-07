package bike.rapido.paathashala.parkinglot;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

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

    @Test
    public void shouldLetParkingLotOwnerKnowWhenTheLotHasSpaceAgain() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotOwner lotOwner = Mockito.mock(ParkingLotOwner.class);
        parkingLot.register(lotOwner);
        Car car = new Car();

        boolean parked = parkingLot.park(car);
        assertThat(parked, is(true));
        verify(lotOwner).notifyLotFull();

        parkingLot.unpark(car);
        verify(lotOwner).notifyLotHasSpace();
    }

    @Test
    public void shouldLetOnwerKnowOnLotHasSpaceOnlyOnceAfterLotIsFullAndACarIsUnparked() {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingLotOwner lotOwner = Mockito.mock(ParkingLotOwner.class);
        parkingLot.register(lotOwner);
        Car car1 = new Car();
        Car car2 = new Car();

        parkingLot.park(car1);
        parkingLot.park(car2);
        parkingLot.unpark(car1);
        parkingLot.unpark(car2);

        InOrder inOrder = Mockito.inOrder(lotOwner);

        inOrder.verify(lotOwner).notifyLotFull();
        inOrder.verify(lotOwner, times(1)).notifyLotHasSpace();
    }
}
