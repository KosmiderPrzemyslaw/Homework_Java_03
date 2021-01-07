package day3_tasks;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@WebServlet("/post2")
public class Form2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        String text = request.getParameter("text");
        String checkbox = request.getParameter("checkbox");

        if (checkbox != null) {
            printWriter.println(text);
        } else {
            List<String> profanity = new ArrayList<>();
            profanity.add("Dupa");
            profanity.add("Cholera");

            StringBuilder string = new StringBuilder();

            List<String> cleanString = cleanString(text);

            for (String strFromCleanList : cleanString
            ) {
                for (String strFromProfanity : profanity
                ) {
                    if (strFromCleanList.equalsIgnoreCase(strFromProfanity)) {
                        strFromCleanList = strFromCleanList.replaceAll("[A-Za-z]", "*");
                    }
                }
                string.append(" ").append(strFromCleanList);
            }


            printWriter.println(string);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(getServletContext().getContextPath() + "/form2.html");
    }

    private static List<String> cleanString(String string) {
        return Arrays.asList(string.
                replaceAll("\\.", " ").replaceAll(",", " ").replaceAll(";", " ").replaceAll("-", " ").split(" "));
    }
}
