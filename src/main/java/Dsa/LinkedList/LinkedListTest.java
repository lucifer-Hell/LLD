package Dsa.LinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList=new LinkedList<>();
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);

        List<Integer> updatedList=linkedList.stream().parallel().map((a)->{
            System.out.println("incr "+a+" with "+1);
            return a+1;
        }).toList();
        System.out.println(updatedList);
    }
}
