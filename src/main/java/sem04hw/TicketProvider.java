package sem04hw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TicketProvider {

    private final Database database;
    private final PaymentProvider paymentProvider;
    private final CustomerProvider customerProvider;


    public TicketProvider(Database database, PaymentProvider paymentProvider, CustomerProvider customerProvider) {
        this.database = database;
        this.paymentProvider = paymentProvider;
        this.customerProvider = customerProvider;
    }

    public Collection<Ticket> searchTicket(int clientId, Date date) {

        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getCustomerId() == clientId && ticket.getDate().equals(date))
                tickets.add(ticket);
        }
        return tickets;

    }

    public Ticket buyTicket(int clientId, String cardNo) {

        if (cardNo.length() != 16) {
            throw new RuntimeException("Invalid card number provided");
        }

        Customer customer = customerProvider.getCustomerById(clientId);
        if (customer == null) {
            throw new RuntimeException("No customer found with provided clientId");
        }

        Ticket ticket = new Ticket(clientId, database.getTicketAmount());
        if (ticket.getPrice() <= 0) {
            throw new RuntimeException("Unacceptable ticket price");
        }

        Order order = database.createTicketOrder(clientId, ticket);

        if (!paymentProvider.buyTicket(order.getId(), cardNo, ticket.getPrice())) {
            throw new RuntimeException("Unable to make this purchase");
        }

        customer.addTicket(ticket);

        return ticket;
    }

    public boolean checkTicket(String qrcode) {
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)) {
                ticket.setEnable(false);
                // Save database ...
                return true;
            }
        }
        return false;
    }


}
