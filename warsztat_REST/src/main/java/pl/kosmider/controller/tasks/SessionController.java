package pl.kosmider.controller.tasks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;


@Controller
@SessionAttributes({"loginStart"})
public class SessionController {
    @RequestMapping("/cookieSet")
    @ResponseBody
    public String homeJsp(HttpServletResponse response) {
        Cookie cookie = new Cookie("cookie1", "value1");
        Cookie cookie1 = new Cookie("cookie2", "value2");

        cookie.setPath("/");
        cookie1.setPath("/");

        response.addCookie(cookie);
        response.addCookie(cookie1);

        return "setCookies";
    }

    @RequestMapping("/cookieGet")
    @ResponseBody
    public String home(HttpServletRequest request) {
        Cookie c = WebUtils.getCookie(request, "cookie2");
        return "cookie: " + c.getValue() + " " + c.getName();
    }

    @RequestMapping("/cookieGetSec")
    @ResponseBody
    public String cookie(@CookieValue("cookie1") String cookie) {
        return "cookie: " + cookie;
    }

    @RequestMapping("/sessionController")
    @ResponseBody
    public String session(HttpSession session) {
        session.setAttribute("loginStart", "jakis tam se login start");
        Object loginStart = session.getAttribute("loginStart");

        if (loginStart != null) {
            return (String) loginStart;
        }
        else return String.valueOf(LocalDateTime.now());
    }
}
