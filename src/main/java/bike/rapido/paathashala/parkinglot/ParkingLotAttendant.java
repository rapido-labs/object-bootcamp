package bike.rapido.paathashala.parkinglot;

import java.util.ArrayList;
import java.util.Optional;

public class ParkingLotAttendant {
    private ArrayList<ParkingLot> parkingLots;

    public ParkingLotAttendant(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Optional<ParkingTicket> park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if(parkingLot.hasFreeSlots()){
                if(parkingLot.park(car))
                return Optional.of(new ParkingTicket(parkingLot.getId()));
            }
        }
      return Optional.empty();
    }
}
