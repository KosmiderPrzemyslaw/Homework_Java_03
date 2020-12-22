package day_1;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<City> cities = initialize();

        System.out.println(firstSubList(cities,1,3));
    }

    public static List<City> initialize(){
        List<City> cities = new ArrayList<>();
        cities.add(new City("Madryt", 12321));
        cities.add(new City("Berlin", 12321));
        cities.add(new City("Warszawa", 12321));
        cities.add(new City("Tokio", 12321));
        cities.add(new City("Hamburg", 12321));

        return cities;
    }

    public static List<City> firstSubList(List<City> list, int start, int end){
        List<City> cities;
        cities = list.subList(start, end);

        return cities;
    }

}
