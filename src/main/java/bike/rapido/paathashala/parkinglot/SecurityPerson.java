package bike.rapido.paathashala.parkinglot;

public class SecurityPerson {

    private boolean lotFull;

    public boolean isLotFull() {
        return lotFull;
    }

    public void notifyLotFull() {
        this.lotFull = true;
    }
}
