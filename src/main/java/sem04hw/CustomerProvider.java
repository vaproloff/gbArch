package sem04hw;

import java.util.Collection;

public class CustomerProvider {

    private final Database database;

    public CustomerProvider(Database database) {
        this.database = database;
    }

    public Customer getCustomer(String login, String password) {
        Collection<Customer> customers = database.getCustomers();
        for (Customer customer : customers) {
            if (customer.getLogin().equals(login) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        return null;
    }

    public Customer getCustomerById(int id) {
        for (Customer customer : database.getCustomers()) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public boolean signUpCustomer(String login, String password) {
        Customer customer = new Customer(login, password);
        return database.addCustomer(customer);
    }


}
