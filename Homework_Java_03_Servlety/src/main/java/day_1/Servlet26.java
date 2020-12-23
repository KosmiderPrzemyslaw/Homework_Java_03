package day_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/servlet26")
public class Servlet26 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> headersMap = headersValue(request);

        Set<String> keys = headersMap.keySet();
        PrintWriter printWriter = response.getWriter();

        for (String key: keys
             ) {
            String value = headersMap.get(key);
            printWriter.println(String.format("%s : %s", key, value));
        }
    }

    private Map<String, String> headersValue(HttpServletRequest request){
        Map<String, String> map = new HashMap<>();

        Enumeration headersNames = request.getHeaderNames();
        while (headersNames.hasMoreElements()){
            String key = (String) headersNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }
}
