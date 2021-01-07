package day1_tasks;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get3")
public class Servlet3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width;
        int height;

        try {
            width = Integer.parseInt(request.getParameter("width"));
            height = Integer.parseInt(request.getParameter("height"));

            printTable(response, width, height);
        } catch (NumberFormatException e) {
            width = 5;
            height = 10;

            printTable(response, width, height);
        }
    }

    private void printTable(HttpServletResponse response, int width, int height) throws IOException {
        int result;
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                result = i * j;

                PrintWriter writer = response.getWriter();
                writer.print(i + "*" + j + "=" + result + "\t");
                if (j == width) {
                    writer.println();
                }
            }
        }
    }
}
