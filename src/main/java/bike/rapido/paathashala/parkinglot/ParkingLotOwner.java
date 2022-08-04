package bike.rapido.paathashala.parkinglot;

public class ParkingLotOwner implements ParkingLotObserver {

    public void notifyLotFull() {
        System.out.println("Notified Parking Lot Owner");
    }
}
