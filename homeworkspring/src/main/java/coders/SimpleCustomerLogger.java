package coders;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SimpleCustomerLogger implements CustomerLog {

    private Customer customer;

    public SimpleCustomerLogger(Customer customer) {
        this.customer = customer;
    }

    public SimpleCustomerLogger() {

    }


    @Override
    public void log(Customer customer) {
        System.out.println(customer + " " + LocalDateTime.now());
    }

    @Override
    public void readAllLogs() {

    }
}

