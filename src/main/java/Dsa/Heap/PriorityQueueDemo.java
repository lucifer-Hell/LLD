package Dsa.Heap;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->-(a-b));
        pq.add(4);
        print(pq.peek());
        print(pq.add(4));
        print(pq.peek());
        print(pq.add(900));
        print(pq.peek());
        print(pq.add(7));
        print(pq.peek());
        print(pq.add(9));
        System.out.println(pq);
    }
    static void print(Object o){
        System.out.println(o);
    }
}
