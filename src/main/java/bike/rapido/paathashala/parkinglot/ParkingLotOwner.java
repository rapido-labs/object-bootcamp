package bike.rapido.paathashala.parkinglot;

public class ParkingLotOwner implements ParkingLotObserver {
    private boolean lotFull;

    public boolean isLotFull() {
        return lotFull;
    }

    public void notifyLotFull() {
        this.lotFull = true;
    }
}
