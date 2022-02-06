package pl.kosmider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

@Controller
@SessionAttributes({"leon", "age"})
public class TestController {
    @GetMapping({"/test", "homepage"})
    public String test() {
        return "test";
    }

    @RequestMapping("/task3")
    @ResponseBody
    public String task3(@RequestParam String name, @RequestParam String secondName) {
        return "My name: " + name + " my second name: " + secondName;
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String task4() {
        return "form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String param(HttpServletRequest request) {

        LocalDate localDate = LocalDate.parse(request.getParameter("paramDate"));
        String paramName = request.getParameter("paramName");

        return paramName + localDate;
    }

    @RequestMapping({"/home"})
    public String bgColor(Model model) {
        checkHour(model);
        return "home";
    }

    private void checkHour(Model model) {
        String color;
        String bgColor;

        Random random = new Random();
        int i = random.nextInt(24);

        LocalTime localTime = LocalTime.of(i, 44);
        int hour = localTime.getHour();

        if (hour >= 8 && hour < 20) {
            color = "yellow";
            bgColor = "blue";
        } else {
            color = "red";
            bgColor = "green";
        }

        model.addAttribute("color", color);
        model.addAttribute("bgColor", bgColor);
    }

    @RequestMapping("/leon")
    public String leon(Model model) {
        model.addAttribute("leon", 1);
        model.addAttribute("age", 30);
        return "leon";
    }

    @RequestMapping("/session")
    @ResponseBody
    public String session(HttpSession session) {
        int sesLeon = (int) session.getAttribute("leon");
        return "session leon value " + sesLeon;
    }

}


