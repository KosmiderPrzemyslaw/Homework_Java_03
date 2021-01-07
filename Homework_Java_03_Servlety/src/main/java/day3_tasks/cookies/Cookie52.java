package day3_tasks.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/cookie52")
public class Cookie52 extends HttpServlet {
    private final String COOKIE_NAME = "cookie51";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isCookieSet(request.getCookies())) {
            Cookie cookie = new Cookie(COOKIE_NAME, "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            response.getWriter().append("Witamy na stronie cookie52").close();
        } else {
            String message = "FirstVisitCookie51";
            response.sendRedirect("cookie51?msg=" + URLEncoder.encode(message, "UTF-8"));
        }
    }

    private boolean isCookieSet(Cookie[] cookies) {
        for (Cookie cookie : cookies
        ) {
            if (cookie.getName().equals(COOKIE_NAME)) {
                return true;
            }
        }
        return false;
    }
}
