package sem04hw;

public class Order {

    private static int counter;
    private final int id;
    private final int customerId;
    private final int ticketId;


    {
        this.id = ++counter;
    }

    public Order(int customerId, int ticketId) {
        this.customerId = customerId;
        this.ticketId = ticketId;
    }


    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getTicketId() {
        return ticketId;
    }
}
