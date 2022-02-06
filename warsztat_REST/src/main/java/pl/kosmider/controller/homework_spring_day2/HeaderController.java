package pl.kosmider.controller.homework_spring_day2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController {
    @GetMapping("/showUserAgent")
    public String userA(@RequestHeader("user-agent") String userAgent, Model model) {
        model.addAttribute("userAgent", userAgent);
        return "userAgent";
    }

    @GetMapping("/userAgent")
    @ResponseBody
    public String usA(@RequestHeader("user-agent") String userAgent) {
        return "user-agent = " + userAgent;
    }
}
