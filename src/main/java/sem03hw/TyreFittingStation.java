package sem03hw;

import java.util.HashMap;
import java.util.Map;

public class TyreFittingStation implements TyresFitting{

    private final Map<CarType, Double> tyreFitPrices = new HashMap<>();

    @Override
    public void fitTyres(int wheelsCount, CarType carType) {
        if (this.tyreFitPrices.containsKey(carType)) {
            double price = this.tyreFitPrices.get(carType);
            System.out.println("Tyres fitting...");
            System.out.println("Total price:" + price);
        } else {
            System.out.println("Unacceptable car type.");
        }
    }

    public void setTyreFitPrice(CarType carType, double tyreFitPrice) {
        if (this.tyreFitPrices.get(carType) != null) {
            this.tyreFitPrices.replace(carType, tyreFitPrice);
        } else {
            this.tyreFitPrices.put(carType, tyreFitPrice);
        }
    }

    private double calculateTyresFit(int wheelsCount, double price) {
        return wheelsCount * price;
    }
}
