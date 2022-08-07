package bike.rapido.paathashala.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class ParkingLotAttendant {
    private ArrayList<ParkingLot> parkingLots;

    public ParkingLotAttendant(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Optional<ParkingTicket> park(Car car) {
        ParkingLot parkingLot = getParkingLotBasisEvenParkingDistribution();
        int parkingLotId = parkingLot.getId();
        if (parkingLot.park(car))
            return Optional.of(new ParkingTicket(parkingLotId));

        return Optional.empty();
    }

    private ParkingLot getParkingLotBasisEvenParkingDistribution() {
        parkingLots.sort(Comparator.comparingDouble(ParkingLot::getAvailabilityRatio));
        return parkingLots.get(0);
    }

    public boolean unPark(Car car) {
        Optional<ParkingLot> parkingLot = parkingLots.stream()
                .filter((lot) -> lot.isCarParked(car))
                .findFirst();
        return parkingLot.map(lot -> lot.unpark(car)).orElse(false);
    }
}
