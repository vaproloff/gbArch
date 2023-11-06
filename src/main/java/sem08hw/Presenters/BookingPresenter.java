package sem08hw.Presenters;

import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }
    public void updateTables(){
        view.showTables(model.loadTables());
    }

    private void showReservationTableResult(int reservationNo){
        view.showReservationTableResult(reservationNo);
    }

    @Override
    public void onReservationTable(Date reservationDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(reservationDate, tableNo, name);
            showReservationTableResult(reservationNo);
        }
        catch (RuntimeException e){
            showReservationTableResult(-1);
        }
    }

    @Override
    public void onReservationChanged(int oldReservationNo, Date reservationDate, int tableNo, String name) {
        try {
            int newReservationNo = model.changeReservationTable(oldReservationNo, reservationDate, tableNo, name);
            showReservationTableResult(newReservationNo);
        }
        catch (RuntimeException e){
            showReservationTableResult(-1);
        }
    }
}
