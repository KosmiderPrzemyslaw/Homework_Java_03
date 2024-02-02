package pl.kosmider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {
    @RequestMapping("/showRandom")
    @ResponseBody
    public String showRandom() {
        Random random = new Random();
        int i = random.nextInt(99 + 1);
        return "Wylosowano liczbe: " + i;
    }
}
