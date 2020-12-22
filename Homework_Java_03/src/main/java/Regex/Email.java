package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    public static void main(String[] args) {
        firstRegex();

        findFirstJava();


        String email = "_kosmo-.a@kosmo.asd.pl";
        System.out.println(verifyEmail(email));

        String secEmail = "aKaKaaKaKaK";
        verifyEmailSec(secEmail);
    }

    private static boolean verifyEmail(String email) {

        Pattern pattern = Pattern.compile("[\n" +
                "_\n" +
                "a-zA-Z0-9-]+(\\.[\n" +
                "_\n" +
                "a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}");
        Matcher matcher = pattern.matcher(email);

        boolean matches = matcher.matches();
        return matches;
    }

    public static boolean verifyEmailSec(String email) {
        Pattern pattern = Pattern.compile("(([a-z]?[A-Z]?)?([a-z]?[A-Z]?)?){10,15}");
        Matcher matcher = pattern.matcher(email);

        System.out.println(matcher.matches());

        return matcher.matches();
    }

    private static void findFirstJava() {
        Pattern pattern = Pattern.compile("^java", Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern.matcher("Java jest technologią wykorzystywaną do\n" +
                "tworzenia aplikacji, które czynią Internet bardziej atrakcyjnym.\n" +
                "Java to nie to samo co JavaScript. Więcej informacji o oprogramowaniu Java");

        while (matcher1.find()) {
            System.out.print("start: " + matcher1.start());
            System.out.println(" end: " + matcher1.end());
        }
    }

    private static void firstRegex() {
        Pattern compiledPattern = Pattern.compile("reg.*");
        Matcher matcher = compiledPattern.matcher("Wyrażenia regularne w Javie");
        System.out.println(matcher.find());
        System.out.println(matcher.matches());
    }
}
