package bike.rapido.paathashala.parkinglot;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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
        Attendee attendee = new Attendee(parkingLots);
        Car firstCar = new Car();
        Car secondCar = new Car();
        attendee.park(firstCar);

        ParkingTicket parkingTicket = attendee.park(secondCar);

        assertThat(parkingTicket.getId(), is(secondLot.getId()));
    }
}

