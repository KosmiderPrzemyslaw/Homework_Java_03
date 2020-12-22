package day_1;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main4 {
    public static void main(String[] args) {
        Queue<Integer> integerQueue = new LinkedList<>();
        integerQueue.add(2);
        integerQueue.add(3);
        integerQueue.add(4);
        integerQueue.add(5);
        integerQueue.add(6);
        integerQueue.add(7);
        integerQueue.add(8);

        Integer remove = integerQueue.remove();
        System.out.println(remove);

        Queue<String> pq = new PriorityQueue<>();

        pq.add("Zet");
        pq.add("Bet");
        pq.add("Cet");
        pq.add("Ad");
        pq.add("Kat");
        pq.add("Red");

        System.out.println(pq);
    }
}
