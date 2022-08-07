package bike.rapido.paathashala.parkinglot;

import java.util.ArrayList;

public class Attendee {
    private ArrayList<ParkingLot> parkingLots;

    public Attendee(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if(parkingLot.hasFreeSlots()){
                if(parkingLot.park(car))
                return new ParkingTicket(parkingLot.getId());
            }
        }
        return null;
    }
}
