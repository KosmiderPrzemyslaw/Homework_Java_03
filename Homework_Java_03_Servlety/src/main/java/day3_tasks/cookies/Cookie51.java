package day3_tasks.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie51")
public class Cookie51 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = request.getParameter("msg");

        if (msg != null) {
            response.getWriter().append(String.format("<h2>%s</h2>", msg));
        }

        String link = "<div><a href=\"/cookie52\">Przejdź do coookie52 </a></div>";
        response.addCookie(new Cookie("cookie51", "val51"));
        response.getWriter().append(link).close();
    }
}
