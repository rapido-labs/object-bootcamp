package bike.rapido.paathashala.parkinglot;

public class ParkingTicket {
    private int parkingLotId;

    public ParkingTicket(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getId() {
        return parkingLotId;
    }
}
