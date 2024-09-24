package Dsa.Heap;

public class HeapTest {
    public static void main(String[] args) {
        Heap heap=new Heap(4);
        try {
            heap.add(10);
            System.out.println("heap peek "+heap.peek());
            heap.pop();
            heap.pop();
            heap.add(10);
            heap.add(20);
            System.out.println("heap peek "+heap.peek());
            heap.add(4);
            System.out.println("heap peek "+heap.peek());
            heap.add(1);
            System.out.println("heap peek "+heap.peek());
            heap.add(22);
            System.out.println("heap peek "+heap.peek());
            System.out.println("popped "+ heap.pop());
            System.out.println("popped "+ heap.pop());
            System.out.println("popped "+ heap.pop());
            System.out.println("popped "+ heap.pop());
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }

    }
}
