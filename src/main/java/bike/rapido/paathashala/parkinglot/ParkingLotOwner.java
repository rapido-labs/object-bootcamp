package bike.rapido.paathashala.parkinglot;

public class ParkingLotOwner implements ParkingLotObserver {

    @Override
    public void notifyLotFull() {
        System.out.println("Notified Parking Lot Owner when lot is full");
    }

    @Override
    public void notifyLotHasSpace() {
        System.out.println("Notified Parking Lot Owner when lot has space");
    }
}
