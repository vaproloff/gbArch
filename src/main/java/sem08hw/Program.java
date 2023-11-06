package sem08hw;

import sem08hw.Models.TableModel;
import sem08hw.Presenters.BookingPresenter;
import sem08hw.Presenters.Model;
import sem08hw.Views.BookingView;

import java.util.Date;

public class Program {

    //TODO: метод changeReservationTable должен заработать
    public static void main(String[] args) {
        Model model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateTables();

        view.reservationTable(new Date(), 3, "Станислав");
        view.changeReservationTable(1001, new Date(), 2, "Станислав");
    }

}
