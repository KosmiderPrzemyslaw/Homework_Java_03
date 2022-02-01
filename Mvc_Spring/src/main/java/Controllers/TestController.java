import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class TestController {
    @RequestMapping(path = "/test", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String start(Model model) {
        return "<h1>title</h1> <p> łóąś</p>";
    }
}
