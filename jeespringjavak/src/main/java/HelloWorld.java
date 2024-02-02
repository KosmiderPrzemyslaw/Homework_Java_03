import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class HelloWorld {
    public void printHelloWorld(){
        System.out.println("Hello world!! " + LocalDateTime.now());
    }
}
