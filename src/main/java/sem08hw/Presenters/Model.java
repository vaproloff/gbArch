package sem08hw.Presenters;

import sem08hw.Models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();

    int reservationTable(Date reservationDate, int tableNo, String name);

    int changeReservationTable(int oldReservationNo, Date reservationDate, int tableNo, String name);

}
