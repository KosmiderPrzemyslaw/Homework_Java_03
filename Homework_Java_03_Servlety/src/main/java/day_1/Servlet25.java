package day_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/servlet25")
public class Servlet25 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random random = new Random();
        List<Integer> sortedRandomNumbers = new ArrayList<>();
        int[] randomNumbers = new int[10];

        for (int i = 0; i < 10; i++) {
            randomNumbers[i] = random.nextInt(100) + 1;
            sortedRandomNumbers.add(randomNumbers[i]);
        }

        Arrays.sort(randomNumbers);
        Collections.sort(sortedRandomNumbers);
        PrintWriter printWriter = response.getWriter();
        printWriter.println(String.format("Unsorted list: %s",Arrays.toString(randomNumbers)));
        printWriter.println(String.format("Sorted by Collection.sort: %s", sortedRandomNumbers));

    }
}
