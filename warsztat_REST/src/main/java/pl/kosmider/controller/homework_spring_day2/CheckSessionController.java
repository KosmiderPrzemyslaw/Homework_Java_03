package pl.kosmider.controller.homework_spring_day2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
public class CheckSessionController {

    @GetMapping("/checkSession")
    @ResponseBody
    public Object checkSession(HttpSession session){
        session.setAttribute("loginStart", "START");
        Object loginStart = session.getAttribute("loginStart");
        if (loginStart == null){
            return LocalDateTime.now();
        }
        return loginStart;
    }
}
