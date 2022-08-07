package bike.rapido.paathashala.parkinglot;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingLotAttendantTest {
    @Test
    public void shouldParkCarInTheFirstAvailableLot() {
        ParkingLot firstLot = new ParkingLot(1);
        ParkingLot secondLot = new ParkingLot(2);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {
            {
                add(firstLot);
                add(secondLot);
            }
        };
        ParkingLotAttendant attendee = new ParkingLotAttendant(parkingLots);
        Car firstCar = new Car();
        Car secondCar = new Car();
        attendee.park(firstCar);

        Optional<ParkingTicket> parkingTicket = attendee.park(secondCar);

        assertTrue(parkingTicket.isPresent());
        assertThat(parkingTicket.get().getLotId(), is(secondLot.getId()));
    }

    @Test
    public void shouldNotAllowToParkCarIfAllLotsAreFull() {
        ParkingLot firstLot = new ParkingLot(1);
            ParkingLot secondLot = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {
            {
                add(firstLot);
                add(secondLot);
            }
        };
        ParkingLotAttendant attendee = new ParkingLotAttendant(parkingLots);
        Car firstCar = new Car();
        Car secondCar = new Car();
        attendee.park(firstCar);
        attendee.park(secondCar);

        Optional<ParkingTicket> parkingTicket = attendee.park(new Car());

        assertFalse(parkingTicket.isPresent());
    }

    @Test
    public void shouldAllowCarToBeUnParkedFromParkingLotWhenPresent() {
        ParkingLot firstLot = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {
            {add(firstLot);}};
        ParkingLotAttendant attendee = new ParkingLotAttendant(parkingLots);
        Car firstCar = new Car();
        attendee.park(firstCar);

        boolean isUnParked = attendee.unPark(firstCar);

        assertTrue(isUnParked);
    }

    @Test
    public void shouldNotAllowCarToBeUnParkedFromParkingLotWhenNotPresent() {
        ParkingLot firstLot = new ParkingLot(1);
        ParkingLot secondLot = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {
            {add(firstLot);
            add(secondLot);}};
        ParkingLotAttendant attendee = new ParkingLotAttendant(parkingLots);
        Car firstCar = new Car();

        boolean isUnParked = attendee.unPark(firstCar);

        assertFalse(isUnParked);
    }
}

