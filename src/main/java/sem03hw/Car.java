package sem03hw;

import java.awt.*;

public abstract class Car {

    /**
     * Заправить автомобиль
     */
    private Refueling refuelingStation;

    public void setRefuelingStation(Refueling refuelingStation) {
        this.refuelingStation = refuelingStation;
    }

    public void fuel() {
        if (this.refuelingStation != null) {
            this.refuelingStation.fuel(this.fuelType);
        }
    }

    /**
     * Шиномонтаж
     */
    private TyresFitting tyreFittingStation;

    public void setTyreFittingStation(TyresFitting tyreFittingStation) {
        this.tyreFittingStation = tyreFittingStation;
    }

    public void fitTyres() {
        if (this.tyreFittingStation != null) {
            this.tyreFittingStation.fitTyres(this.wheelsCount, this.carType);
        }
    }

    /**
     * Автомойка
     */
    private CarWashing carCarWashingStation;

    public void setCarWashingStation(CarWashing carCarWashingStation) {
        this.carCarWashingStation = carCarWashingStation;
    }

    public void washCar() {
        if (this.carCarWashingStation != null) {
            this.carCarWashingStation.washCar(this.carType);
        }
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    // Движение
    public abstract void move();

    // Переключение передач
    public abstract boolean gearShifting();

    // Переключение фар
    public boolean toggleHeadlights() {
        this.headlights = !this.headlights;
        return this.headlights;
    }

    // Включение дворников
    public boolean toggleWipers() {
        this.wipers = !this.wipers;
        return this.wipers;
    }

    //region Конструкторы

    public Car(String brand, String model, Color color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    //endregion

    //region Поля

    // Тип автомобиля
    protected CarType carType;

    // Марка автомобиля
    private String brand;

    // Модель автомобиля
    private String model;

    // Цвет автомобиля
    private Color color;

    // Тип автомобиля
    protected CarType type;

    // Число колес
    protected int wheelsCount;

    // Тип топлива
    protected FuelType fuelType;

    // Тип коробки передач
    private GearboxType gearboxType;

    // Объем двигателя
    private double engineCapacity;

    // Состояние фар
    private boolean headlights = false;

    // Состояние противотуманных фар
    protected boolean fogLights = false;

    // Состояние противотуманных фар
    private boolean wipers = false;

    //endregion

}
