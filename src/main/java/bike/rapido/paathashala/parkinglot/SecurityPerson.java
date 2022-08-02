package bike.rapido.paathashala.parkinglot;

public class SecurityPerson implements ParkingLotObserver {

    private boolean lotFull;

    public boolean isLotFull() {
        return lotFull;
    }

    @Override
    public void notifyLotFull() {
        this.lotFull = true;
    }
}
