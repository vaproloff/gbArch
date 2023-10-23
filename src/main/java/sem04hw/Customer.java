package sem04hw;

import java.util.ArrayList;
import java.util.Collection;

public class Customer {

    {
        id = ++counter;
    }

    public Customer(String login, String password) {
        this.login = login;
        this.password = password;
    }

    private static int counter;
    private final int id;
    private final String login;
    private String password;

    private Collection<Ticket> tickets = new ArrayList<>();

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }
}
