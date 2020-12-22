package day_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main5 {
    public static void main(String[] args) {
        Map<String, String> opposites = getMap();
        Set<String> keys = opposites.keySet();

        Scanner scanner = new Scanner(System.in);
        int counter = 0;

        for (String key : keys
        ) {
            System.out.println("Podaj przeciwieństwo do " + key);
            String answer = scanner.nextLine();
            String value = opposites.get(key);

            if (answer.equals(value)) {
                counter++;
            }
        }

        System.out.println("Poprawnych odpowiedzi: " + counter);

    }

    public static Map<String, String> getMap() {
        Map<String, String> stringMap = new HashMap<>();

        stringMap.put("ciepło", "zimno");
        stringMap.put("biały", "czarny");
        stringMap.put("dobry", "zły");
        stringMap.put("stary", "młody");
        stringMap.put("lato", "zima");

        return stringMap;
    }
}
