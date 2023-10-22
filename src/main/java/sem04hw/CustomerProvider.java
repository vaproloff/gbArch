package sem04hw;

public class CustomerProvider {

    private final Database database;

    public CustomerProvider(Database database) {
        this.database = database;
    }

    public Customer getCustomer(String login, String password) {
        return new Customer();
        //return database.getCustomers().stream().findFirst().get();
    }


}
