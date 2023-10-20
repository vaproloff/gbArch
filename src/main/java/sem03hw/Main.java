package sem03hw;

import java.awt.*;

public class Main {

    /**
     * 1. Спроектировать абстрактный класс «Car» у которого должны
     * быть свойства: марка, модель, цвет, тип кузова, число колёс, тип
     * топлива, тип коробки передач, объём двигателя; методы:
     * движение, обслуживание, переключение передач, включение
     * фар, включение дворников.
     * <p>
     * 2. Создать конкретный автомобиль путём наследования класса
     * «Car».
     * <p>
     * 3. Расширить абстрактный класс «Car», добавить метод: подметать
     * улицу. Создать конкретный автомобиль путём наследования
     * класса «Car». Провести проверку принципа SRP.
     * <p>
     * 4. Расширить абстрактный класс «Car», добавить метод:
     * включение противотуманных фар, перевозка груза. Провести
     * проверку принципа OCP.
     * <p>
     * 5. Создать конкретный автомобиль путём наследования класса
     * «Car», определить число колёс = 3. Провести проверку принципа LSP.
     * <p>
     * 6. Создать конкретный автомобиль путём наследования класса
     * «Car», определить метод «движение» - «полёт». Провести
     * проверку принципа LSP.
     * <p>
     * 7. Создать интерфейс «Заправочная станция», создать метод:
     * заправка топливом.
     * <p>
     * 8. Имплементировать метод интерфейса «Заправочная станция» в
     * конкретный класс «Car».
     * <p>
     * 9. Добавить в интерфейс «Заправочная станция» методы: протирка
     * лобового стекла, протирка фар, протирка зеркал.
     * <p>
     * 10. Имплементировать все методы интерфейса «Заправочная
     * станция» в конкретный класс «Car». Провести проверку
     * принципа ISP. Создать дополнительный/е интерфейсы и
     * имплементировать их в конкретный класс «Car». Провести
     * проверку принципа ISP.
     * <p>
     * 11. Создать путём наследования класса «Car» два
     * автомобиля: с бензиновым и дизельным двигателями,
     * имплементировать метод «Заправка топливом» интерфейса
     * «Заправочная станция». Реализовать заправку каждого
     * автомобиля подходящим топливом. Провести проверку принципа DIP.
     * <p>
     * TODO: Домашнее задание:
     * Доработать приложение, спроектированное на семинаре. Добавить тип, описывающий "автомойку".
     * Продемонстрировать работу получившейся программы,
     * создать несколько типов автомобилей,
     * загнать каждый автомобиль на заправку, а затем и на автомойку.
     */
    public static void main(String[] args) {

        RefuelingStation refuelingStation1 = new RefuelingStation();

        TyreFittingStation tyreFittingStation1 = new TyreFittingStation();
        tyreFittingStation1.setTyreFitPrice(CarType.Sedan, 1000);
        tyreFittingStation1.setTyreFitPrice(CarType.Sport, 1500);
        tyreFittingStation1.setTyreFitPrice(CarType.Special, 2000);

        CarWashStation carWashStation1 = new CarWashStation();
        carWashStation1.setCarWashPrice(CarType.Sedan, 1500);
        carWashStation1.setCarWashPrice(CarType.Sport, 2500);
        carWashStation1.setCarWashPrice(CarType.Special, 5000);

        SportCar sportCar1 = new SportCar("BMW", "M8", Color.BLUE, FuelType.Gasoline);
        SedanCar sedanCar1 = new SedanCar("Volkswagen", "Polo", Color.WHITE, FuelType.Gasoline);
        HarvesterCar harvesterCar1 = new HarvesterCar("CAT", "Pillar 180", Color.BLACK);

        sportCar1.setRefuelingStation(refuelingStation1);
        sportCar1.fuel();
        sedanCar1.setRefuelingStation(refuelingStation1);
        sedanCar1.fuel();
        harvesterCar1.setRefuelingStation(refuelingStation1);
        harvesterCar1.fuel();

        sportCar1.setTyreFittingStation(tyreFittingStation1);
        sportCar1.fitTyres();
        sedanCar1.setTyreFittingStation(tyreFittingStation1);
        sedanCar1.fitTyres();
        harvesterCar1.setTyreFittingStation(tyreFittingStation1);
        harvesterCar1.fitTyres();

        sportCar1.setCarWashingStation(carWashStation1);
        sportCar1.washCar();
        sedanCar1.setCarWashingStation(carWashStation1);
        sedanCar1.washCar();
        harvesterCar1.setCarWashingStation(carWashStation1);
        harvesterCar1.washCar();

    }

}
