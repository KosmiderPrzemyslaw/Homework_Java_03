package Regex;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
    private static final String REGEX = "(\\d[\\\\/*-])*\\d=\\d";


    public static void main(String[] args) {
        StringBuilder expression = getExpression();

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(expression);
        System.out.println(matcher.find());

        File file = new File("main2.txt");

        try {
            FileWriter fileWriter = new FileWriter(file, true);

            fileWriter.write(expression + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder getExpression() {
        String expression;
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("quit")) {
            expression = scanner.nextLine();
            String expressionWithoutWhitespace = expression.replaceAll(" ", "");
            stringBuilder.append(expressionWithoutWhitespace + "\n");
        }
        return stringBuilder;
    }
}

