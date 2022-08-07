package bike.rapido.paathashala.parkinglot;

public class SecurityPerson implements ParkingLotObserver {

    @Override
    public void notifyLotFull() {
        System.out.println("Notified security person when lot is full");
    }

    @Override
    public void notifyLotHasSpace() {
        System.out.println("Notified security person when lot has space");
    }
}
