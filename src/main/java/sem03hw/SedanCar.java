package sem03hw;

import java.awt.*;

public class SedanCar extends Car implements FogLightsToggling {
    public SedanCar(String brand, String model, Color color, FuelType fuelType) {
        super(brand, model, color);
        this.fuelType = fuelType;
        this.carType = CarType.Sedan;
        this.wheelsCount = 4;
    }

    @Override
    public void move() {
        System.out.println("Sedan car is moving...");
    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean toggleFogLights() {
        this.fogLights = !this.fogLights;
        return this.fogLights;
    }
}
