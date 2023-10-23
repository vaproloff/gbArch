package sem04hw;

import java.util.Collection;
import java.util.Date;

public class MobileApp {
    private Customer customer;
    private final TicketProvider ticketProvider;
    private final CustomerProvider customerProvider;

    public MobileApp(TicketProvider ticketProvider, CustomerProvider customerProvider) {
        this.ticketProvider = ticketProvider;
        this.customerProvider = customerProvider;
    }

    public Collection<Ticket> getTickets() {
        return customer.getTickets();
    }

    public boolean signIn(String login, String password) {
        this.customer = customerProvider.getCustomer(login, password);
        return this.customer != null;
    }

    public void signOut() {
        this.customer = null;
    }

    public void searchTicket(Date date) {
        if (customer == null) {
            throw new RuntimeException("You are not authorized.");
        }
        customer.setTickets(ticketProvider.searchTicket(customer.getId(), new Date()));
    }

    public Ticket buyTicket(String cardNo) {
        if (customer == null) {
            throw new RuntimeException("You are not authorized.");
        }
        return ticketProvider.buyTicket(customer.getId(), cardNo);
    }

}
