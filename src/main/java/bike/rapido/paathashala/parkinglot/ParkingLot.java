package bike.rapido.paathashala.parkinglot;

import java.util.HashSet;

public class ParkingLot {

    private final HashSet<Car> parkedCars;
    private final int capacity;
    private final ParkingLotOwner lotOwner;

    public ParkingLot(int capacity, ParkingLotOwner lotOwner) {
        parkedCars = new HashSet<>(capacity);

        this.capacity = capacity;
        this.lotOwner = lotOwner;
    }

    public boolean park(Car car) {
        if (hasFreeSlots() && isCarNotParkedAlready(car)) {
            parkedCars.add(car);
            notifyOwnerIfLotIsFull();
            return true;
        }
        return false;
    }

    private boolean isCarNotParkedAlready(Car car) {
        return !parkedCars.contains(car);
    }

    private void notifyOwnerIfLotIsFull() {
        if (isLotFull()) {
            lotOwner.notifyLotFull();
        }
    }

    private boolean isLotFull() {
        return !hasFreeSlots();
    }

    private boolean hasFreeSlots() {
        return parkedCars.size() < capacity;
    }

    public boolean unpark(Car car) {
        return parkedCars.remove(car);
    }
}
