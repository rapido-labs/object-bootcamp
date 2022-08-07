package bike.rapido.paathashala.parkinglot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ParkingLot {

    private final HashSet<Car> parkedCars;
    private final List<ParkingLotObserver> lotObservers;

    private final int capacity;

    public ParkingLot(int capacity) {
        parkedCars = new HashSet<>(capacity);
        lotObservers = new ArrayList<>();

        this.capacity = capacity;
    }

    public boolean park(Car car) {
        if (hasFreeSlots() && isCarNotParkedAlready(car)) {
            parkCar(car);
            notifyAllObserversIfLotFull();
            return true;
        }
        return false;
    }

    private void parkCar(Car car) {
        parkedCars.add(car);
    }

    private boolean isCarNotParkedAlready(Car car) {
        return !parkedCars.contains(car);
    }

    private void notifyAllObserversIfLotFull() {
        if (isLotFull()) {
            for (ParkingLotObserver lotObserver : lotObservers) {
                lotObserver.notifyLotFull();
            }
        }
    }

    private boolean isLotFull() {
        return !hasFreeSlots();
    }

    private boolean hasFreeSlots() {
        return parkedCars.size() < capacity;
    }

    public boolean unpark(Car car) {
        boolean lotFullBeforeUnparking = isLotFull();
        boolean unparked = parkedCars.remove(car);
        if (unparked && lotFullBeforeUnparking) {
            notifyAllObserversOnLotHasSpace();
        }
        return unparked;
    }

    private void notifyAllObserversOnLotHasSpace() {
        for (ParkingLotObserver lotObserver : lotObservers) {
            lotObserver.notifyLotHasSpace();
        }
    }

    public void register(ParkingLotObserver observer) {
        lotObservers.add(observer);
    }
}
