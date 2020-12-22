package day_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>();

        for (int i = 10; i <= 19; i++) {
            elements.add(i);
        }

        for (Integer i: elements
             ) {
            System.out.println(i);
        }

        Iterator<Integer> iterator = elements.iterator();

        System.out.println("print by iterator: ");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("print by for loop ");
        for (int i = 0; i < elements.size() ; i++) {
            System.out.println(elements.get(i));
        }

    }
}
