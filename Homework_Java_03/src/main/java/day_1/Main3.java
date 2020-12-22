package day_1;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        int count = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj wartosć  - exit zakończ program");
        String input = scanner.nextLine();

        while (!input.equals("exit")){
            count++;
            strings.add(input);
            System.out.println(input);
            System.out.println("Podaj wartość - exit zakończ program");
            input = scanner.nextLine();
        }

        System.out.println("Podanych napisów: " + count + " rozmiar kolekcji: " + strings.size());

    }
}
