package coders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemoryCustomerRepository implements CustomerRepository, CustomerLog {
    public Customer customer;
    public List<Customer> customerList = new ArrayList<>();
    CustomerLog customerLog;

    public MemoryCustomerRepository(Customer customer, CustomerLog customerLog, List<Customer> customerList) {
        this.customer = customer;
        this.customerList = customerList;
    }

    MemoryCustomerRepository() {
    }


    @Override
    public void addCustomer(Customer customer) {
        log(customer);
        customerList.add(customer);
    }

    @Override
    public void removeCustomer(Customer customer) {
        log(customer);
        customerList.remove(customer);
    }

    @Override
    public List<Customer> showAllCustomers(List<Customer> customerList) {
        for (Customer c:customerList
             ) {
            System.out.println(c.toString());
        }
        return customerList;
    }

    @Override
    public void log(Customer customer) {
        System.out.println(customer.toString() + "Last operation at: " + LocalDateTime.now());
    }

    @Override
    public void readAllLogs() {

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public List<Customer> getCustomerList() {
        return this.customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}