package Regex;

import java.util.regex.Pattern;

public class Main3 {
    public static void main(String[] args) {
        boolean result1 = Pattern.matches("(\\w+)=\\1", "Ala=ala");
        boolean result2 = Pattern.matches("(\\w+)=\\1", "Ala=Ala");
        System.out.println("Result1: " + result1);
        System.out.println("Result2: " + result2);

        Pattern pattern = Pattern.compile("^abc");
        boolean result3 = pattern.matcher("abc nazywam sie ").find();
        System.out.println("Result3: " + result3);

        Pattern pattern1 = Pattern.compile("abc$");
        boolean result4 = pattern1.matcher("nazywam sie abc").find();
        System.out.println("Result4: " + result4);
    }
}
