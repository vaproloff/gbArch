package sem08hw.Models;

import sem08hw.Presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {
        if (tables == null){
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables){
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(tableNo, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }

    public int changeReservationTable(int oldReservationNo, Date reservationDate, int tableNo, String name){
        for (Table table : this.tables) {
            Collection<Reservation> tableReservations = table.getReservations();
            for (Reservation reservation : tableReservations) {
                if (reservation.getId() == oldReservationNo) {
                    tableReservations.remove(reservation);
                    return this.reservationTable(reservationDate, tableNo, name);
                }
            }
        }
        return -1;
    }
}
