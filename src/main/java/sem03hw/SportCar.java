package sem03hw;

import java.awt.*;

public class SportCar extends Car implements FogLightsToggling {
    public SportCar(String brand, String model, Color color, FuelType fuelType) {
        super(brand, model, color);
        this.fuelType = fuelType;
        this.carType = CarType.Sport;
        this.wheelsCount = 4;
    }

    @Override
    public void move() {
        System.out.println("Sport car is moving...");
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
