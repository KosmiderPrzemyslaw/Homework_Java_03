package coders;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class SpringDiApplication {
    @lombok.SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SimpleCustomerLogger simpleCustomerLogger = context.getBean("simpleCustomerLogger", SimpleCustomerLogger.class);
        simpleCustomerLogger.log(new Customer(3, "Jack", "Sparrow"));

        MemoryCustomerRepository memoryCustomerRepository = context.getBean("memoryCustomerRepository", MemoryCustomerRepository.class);


        Customer customer = new Customer(1, "Kamil", "Volko");
        Customer customer2 = new Customer(2, "Mateusz", "Juraszewski");

        memoryCustomerRepository.addCustomer(customer);
        memoryCustomerRepository.addCustomer(customer2);

        List<Customer> customerList = memoryCustomerRepository.getCustomerList();

        for (Customer c : customerList
        ) {
            System.out.println(c);
        }

        FileCustomerLogger fileCustomerLogger = context.getBean("fileCustomerLogger", FileCustomerLogger.class);
        fileCustomerLogger.log(customer);
        fileCustomerLogger.log(customer2);

        memoryCustomerRepository.removeCustomer(customer);

        System.out.println("-----------");
        memoryCustomerRepository.showAllCustomers(customerList);
        memoryCustomerRepository.removeCustomer(customer2);
        System.out.println("-----------");
        memoryCustomerRepository.showAllCustomers(customerList);


        DBCustomerLogger dbCustomerLogger = context.getBean("dbCustomerLogger", DBCustomerLogger.class);
        dbCustomerLogger.log(customer);

        try {

            File file = new File("customersLogs.txt");
            Scanner scanner = new Scanner(file);
            StringBuilder stringBuilder = new StringBuilder();


//            while (scanner.hasNextLine()) {
//                System.out.println("Logi z pliku");
//                System.out.println(scanner.nextLine());
//                stringBuilder.append(scanner.nextLine());
//
//                System.out.println("String biulider: " + stringBuilder);
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FileWriter fileWriter = new FileWriter("customersLogs.txt", true);
        fileWriter.append("coś");
        fileWriter.close();

        ReadAllLogsFromDb readAllLogsFromDb = context.getBean("readAllLogsFromDb", ReadAllLogsFromDb.class);
        readAllLogsFromDb.readAllLogs();

        context.close();


    }
}
