package Thread;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        // THREADS SHARE CODE DATA AND HEAP BUT DON'T SHARE STACK IN THEORTICIAL
        // BUT IN PRACTICAL SINCE THREADS MEMORY ARE ACCESSIBLE TO OTHER THREADS THEY CAN THE STACK MEM -- JUST IGNORE IF U DON'T UNDERSTAND
        // Thread vs no thread approach to proivde modulo of all the numbers with 77 .
        int start=0,end=1000;
        Stack<Integer>stack=new Stack<>();
        stack.addAll(IntStream.range(start,end).boxed().toList());
        long [] noThreadTime=calculateModuleNoThreaded(stack,new ConcurrentHashMap<>());
        stack.addAll(IntStream.range(start,end).boxed().toList());
        long [] threadTime=calculateModuleThreaded(stack,new ConcurrentHashMap<>());
        System.out.println("time required to caluclating in non threaded approach "+(noThreadTime[1]-noThreadTime[0]));
        System.out.println("time required to caluclating in threaded approach "+(threadTime[1]-threadTime[0]));

    }

    private static long [] calculateModuleThreaded(Stack<Integer> stack, Map<Integer, Integer> modMap) throws InterruptedException {
        System.out.println("Starting with thread approach");
        // Spawn threads
        ExecutorService executorService=Executors.newFixedThreadPool(1000);
        List<Callable<Integer>> tasks=new ArrayList<>();
        while (!stack.isEmpty()){
            int no=stack.pop();
            tasks.add(()->{
                System.out.println("processing "+no+" with thread id "+Thread.currentThread().getName());
                System.out.println("some processing happening for no" + no);
                Thread.sleep(20);
                modMap.put(no,no%77);
                return no;
            });
        }
        long start=System.currentTimeMillis();
        executorService.invokeAll(tasks);
        long end=System.currentTimeMillis();
        executorService.shutdown();
//        executorService.close();
        return new long[]{start,end};
    }

    private static long[] calculateModuleNoThreaded(Stack<Integer> stack,Map<Integer,Integer> modMap) throws InterruptedException {
        System.out.println("Starting with non thread approach");
        long start=System.currentTimeMillis();
        while (!stack.isEmpty()){
            int no=stack.pop();
            System.out.println("some processing happening for no" + no);
            Thread.sleep(20);
            modMap.put(no,no%77);
        }

        long end=System.currentTimeMillis();
        return new long[]{start,end};
    }
}
