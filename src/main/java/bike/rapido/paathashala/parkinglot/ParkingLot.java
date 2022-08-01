package bike.rapido.paathashala.parkinglot;

import java.util.HashSet;

public class ParkingLot {

    private final HashSet<Car> parkedCars;

    public ParkingLot() {
        parkedCars = new HashSet<>();
    }

    public boolean park(Car car) {
        return parkedCars.add(car);
    }

    public boolean unpark(Car car) {
        return parkedCars.remove(car);
    }
}
