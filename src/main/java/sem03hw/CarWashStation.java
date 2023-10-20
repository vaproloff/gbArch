package sem03hw;

import java.util.HashMap;
import java.util.Map;

public class CarWashStation implements CarWashing {

    private final Map<CarType, Double> carWashPrices = new HashMap<>();

    @Override
    public void washCar(CarType carType) {
        if (this.carWashPrices.containsKey(carType)) {
            double price = this.carWashPrices.get(carType);
            System.out.println("Car washing...");
            System.out.println("Price:" + price);
        } else {
            System.out.println("Unacceptable car type.");
        }
    }

    public void setCarWashPrice(CarType carType, double carWashPrice) {
        if (this.carWashPrices.get(carType) != null) {
            this.carWashPrices.replace(carType, carWashPrice);
        } else {
            this.carWashPrices.put(carType, carWashPrice);
        }
    }
}
