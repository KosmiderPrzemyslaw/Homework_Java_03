package coders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class FileCustomerLogger implements CustomerLog {

    private String fileName;

    @Autowired
    public FileCustomerLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void log(Customer customer) {
        String string = LocalDateTime.now() + ": new method";
        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(string).append(String.valueOf(customer)).append("\n");
            System.out.println("Zapisano nowy log do pliku");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readAllLogs() {

    }
}
