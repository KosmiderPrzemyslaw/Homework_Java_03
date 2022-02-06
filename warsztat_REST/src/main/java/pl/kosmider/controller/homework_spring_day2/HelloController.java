package pl.kosmider.controller.homework_spring_day2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class HelloController {

    @GetMapping("/workers")
    public String workers(Model model) {

        Random random = new Random();
        int randomNumber = random.nextInt(30) + 1;
        List<String> workersList = new ArrayList<>();

        System.out.println("RANDOM NUMBER: " + randomNumber);
        int number = 0;
        int n = 0;

        try {
            workersList = Files.readAllLines(Paths.get("/home/przemysaw/IdeaProjects/warsztat_REST/Workers.txt"), StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }


        for (String workerFromList : workersList
        ) {
            String s2 = String.valueOf(workerFromList.charAt(0)); // szybsze wyciąnięcie liczby
            String s3 = String.valueOf(workerFromList.charAt(1));// szybsze wyciągnięcie liczby

            n = Integer.parseInt(s2 + s3); // suma Stringów + pars na integer


            char[] workerToCharArray = workerFromList.toCharArray();

            for (int i = 0; i < workerToCharArray.length; i++) {
                System.out.println(workerToCharArray[i]);
                String s = String.valueOf(workerToCharArray[0]);
                String s1 = String.valueOf(workerToCharArray[1]);

                number = Integer.parseInt(s + s1);
            }
            System.out.println(number);
            if (number == randomNumber) {
                String worker = String.valueOf(workerToCharArray);
                model.addAttribute("worker", worker);
            }
        }

       return "workers";
    }
}
