package sem03hw;

import java.awt.*;

public class HarvesterCar extends Car {

    public HarvesterCar(String brand, String model, Color color) {
        super(brand, model, color);
        this.fuelType = FuelType.Diesel;
        this.carType = CarType.Special;
        this.wheelsCount = 6;
    }

    public void sweeping() {
        System.out.println("Harvester car is sweeping...");
    }

    @Override
    public void move() {
        System.out.println("Harvester car is moving...");
    }

    @Override
    public boolean gearShifting() {
        return false;
    }

}
