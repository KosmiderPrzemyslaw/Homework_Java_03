package day_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main6 {
    public static void main(String[] args) {

        List<Country> list = initialize();
        Map<String, Country> map = getMap(list);
        for (Map.Entry<String, Country> entry: map.entrySet()) {
            String capital = entry.getKey();
            String country = entry.getValue().getName();

            System.out.println(String.format("%s - %s", capital, country));
        }
    }

    private static List<Country> initialize() {
        List<Country> countries = new ArrayList<>();

        Country Spain = new Country("Spain", "Madrid");
        Country Poland = new Country("Poland", "Warsaw");
        Country Finland = new Country("Finland", "Helsinki");
        Country Belgium = new Country("Belgium", "Brussel");
        Country Russia = new Country("Russia", "Moscow");

        countries.add(Spain);
        countries.add(Poland);
        countries.add(Finland);
        countries.add(Belgium);
        countries.add(Russia);
        return countries;
    }

    private static Map<String, Country> getMap(List<Country> countryList) {
        Map<String, Country> stringCountryMap = new HashMap<>();
        for (Country c : countryList
        ) {
            stringCountryMap.put(c.getCapital(), c);

        }
        return stringCountryMap;
    }
}
