package pl.kosmider.controller.tasks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {
    @GetMapping("/random/{max}")
    @ResponseBody
    public String getRandom(@PathVariable int max) {
        Random random = new Random();
        int i = random.nextInt(max + 1);
        return String.valueOf(i);
    }
}
