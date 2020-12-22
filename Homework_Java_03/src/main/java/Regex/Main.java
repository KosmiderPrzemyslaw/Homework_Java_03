package Regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("quit")){
            String password = scanner.next();
            System.out.println(verifyPassword(password));
        }

    }

    private static boolean verifyPassword(String password){
        boolean validLength = verifyLength(password);
        boolean validLowerCase = verifyLowerCase(password);
        boolean validUpperCase = verifyUpperCase(password);
        boolean verifyNoDoubleCase = verifyNoDoubleCase(password);

        return validLength && validLowerCase && validUpperCase && verifyNoDoubleCase;
    }
    private static boolean verifyLength(String password){
        return password.matches(".{10,15}");
    }

    private static boolean verifyLowerCase(String password){
        Pattern pattern = Pattern.compile("[a-z]");
        return pattern.matcher(password).find();
    }

    private static boolean verifyUpperCase(String password){
        Pattern pattern = Pattern.compile("[A-Z]");
        return pattern.matcher(password).find();
    }

    private static boolean verifyNoDoubleCase(String password){
        Pattern pattern = Pattern.compile("[a-z]{2}|[A-Z]{2}");
        return !pattern.matcher(password).find();
    }

}
