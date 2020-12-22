package day_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class GeneratedRandom {
    public static void main(String[] args) {
        Map<Integer, Integer> map = checkRand(300, 5);
        Set<Integer> keys = map.keySet();
        for (Integer key:keys
             ) {
            System.out.println(key + ": " + map.get(key));
        }
    }

    public static Map<Integer, Integer> checkRand(int amount, int interval) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        Random generator = new Random();

        for (int i = 0; i < amount ; i++) {
            int number = generator.nextInt(interval);
            if (integerMap.containsKey(number)){
                integerMap.put(number, integerMap.get(number) + 1);
            } else {
                integerMap.put(number, 1);
            }
        }
        return integerMap;
    }
}
