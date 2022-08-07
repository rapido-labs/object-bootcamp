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
            if (parkingLot.hasFreeSlots()) {
                int parkingLotId = parkingLot.getId();
                if (parkingLot.park(car))
                    return Optional.of(new ParkingTicket(parkingLotId));
            }
        }
        return Optional.empty();
    }

    public boolean unPark(Car car) {
        Optional<ParkingLot> parkingLot = parkingLots.stream()
                .filter((lot) -> lot.isCarParked(car))
                .findFirst();
        return parkingLot.map(lot -> lot.unpark(car)).orElse(false);
    }
}
