package day_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/servlet23")
public class Servlet23 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = "/home/przemysaw/IdeaProjects/Homework_Java_03_Servlety/oop.txt";
        Path source = Paths.get(fileName);
        PrintWriter printWriter = response.getWriter();

        if(!Files.exists(source)){
            throw new IOException("Plik nie istnieje");
        }

        List<String> objLang = new ArrayList<>(Files.readAllLines(source));

        for (String lang: objLang
             ) {
            printWriter.println(lang);
        }
    }
}
