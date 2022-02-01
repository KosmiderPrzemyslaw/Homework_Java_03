package coders;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    public SimpleCustomerLogger simpleCustomerLogger() {
        return new SimpleCustomerLogger();
    }


    @Bean
    public MemoryCustomerRepository memoryCustomerRepository() {
        return new MemoryCustomerRepository();
    }

    @Bean
    public Customer customer() {
        return new Customer(memoryCustomerRepository().getCustomer());
    }

    @Bean
    public FileCustomerLogger fileCustomerLogger() {
        return new FileCustomerLogger("customersLogs.txt");
    }

    @Bean
    public DbUtil dbUtil() {
        return new DbUtil();
    }

    @Bean
    public DBCustomerLogger dbCustomerLogger() {
        return new DBCustomerLogger();
    }

    @Bean
    public ReadAllLogsFromDb readAllLogsFromDb() {
        return new ReadAllLogsFromDb();
    }
}
