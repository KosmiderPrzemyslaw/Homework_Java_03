package day3_tasks.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/showCookie")
public class Cookie1Get extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        String cookieValue = null;
        for (Cookie c: cookies
             ) {
            if ("User".equals(c.getName())){
                cookieValue = c.getValue();
            }
        }
        PrintWriter printWriter = response.getWriter();
        printWriter.println(cookieValue);
    }
}
