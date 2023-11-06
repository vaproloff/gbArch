package sem08hw.Presenters;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date reservtionDate, int tableNo, String name);

    void onReservationChanged(int oldReservationNo, Date reservationDate, int tableNo, String name);
}
