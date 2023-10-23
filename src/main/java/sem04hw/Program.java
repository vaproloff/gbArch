package sem04hw;

import java.util.Date;

public class Program {

    /**
     * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус в час пик".
     * <p>
     * 1.  Предусловия.
     * 2.  Постусловия.
     * 3.  Инвариант.
     * 4.  Определить абстрактные и конкретные классы.
     * 5.  Определить интерфейсы.
     * 6.  Реализовать наследование.
     * 7.  Выявить компоненты.
     * 8.  Разработать Диаграмму компонент использую нотацию UML 2.0. Общая без деталей.
     * <p>
     * Домашнее задание:
     * 1. Доработать комплекс "Покупка онлайн билетов на автобус в час пик", наполнить его жизнью,
     * добавить список клиентов и билетов. Продемонстрировать работу приложения в методе main.
     * 2. Переработать один из модулей (на выбор TicketProvider, CustomerProvider)
     * с точки зрения контрактного программирования.
     * 3. Разработать Диаграмму компонент комплекса используя нотацию UML 2.0. Общая, без деталей.
     * Достаточно выполнить одну любую задачу на выбор.
     */

    public static void main(String[] args) {
        Core core = new Core();
        MobileApp mobileApp1 = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());
        mobileApp1.signIn("customer_2", "password_2");

        for (Ticket ticket : mobileApp1.getTickets()) {
            System.out.println(ticket);
        }
        System.out.println();

        Ticket ticket1 = mobileApp1.buyTicket("1000000000000099");
        for (Ticket ticket : mobileApp1.getTickets()) {
            System.out.println(ticket);
        }
        System.out.println();

        BusStation busStation1 = new BusStation(core.getTicketProvider());
        busStation1.checkTicket(ticket1.getQrcode());

        System.out.println(ticket1);
    }

}
