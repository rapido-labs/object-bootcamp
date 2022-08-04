package bike.rapido.paathashala.parkinglot;

public class SecurityPerson implements ParkingLotObserver {

    @Override
    public void notifyLotFull() {
        System.out.println("Notified security person");
    }
}
