package sem08hw.Views;

import sem08hw.Models.Table;
import sem08hw.Presenters.View;
import sem08hw.Presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private Collection<ViewObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(ViewObserver observer) {
        observers.add(observer);
    }

    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table : tables){
            System.out.println(table);
        }
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0)
            System.out.printf("Столик успешно забронирован. Номер резерва #%d\n", reservationNo);
        else
            System.out.println("Невозможно забронировать столик.\nПовторите попытку позже.");
    }

    public void reservationTable(Date reservationDate, int tableNo, String name){
        for (ViewObserver observer : observers)
            observer.onReservationTable(reservationDate, tableNo, name);
    }

    public void changeReservationTable(int oldReservationNo, Date reservationDate, int tableNo, String name){
        for (ViewObserver observer : observers)
            observer.onReservationChanged(oldReservationNo, reservationDate, tableNo, name);
    }

}
