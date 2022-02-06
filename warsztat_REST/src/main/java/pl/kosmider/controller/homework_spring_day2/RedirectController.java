package pl.kosmider.controller.homework_spring_day2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {
    @GetMapping("/first")
    public String first() {
        return "first";
    }

    @GetMapping("/third")
    public String third() {
        return "third";
    }

    @GetMapping("/second")
    public String second() {
        return "redirect:third";
    }

//    @RequestMapping("/first")
//    public String first(HttpServletRequest request) {
//        return "redirect:second";
//    } // Przekirowanie first -> second -> third (w metodzie second jest przekirowanie na third)

}
