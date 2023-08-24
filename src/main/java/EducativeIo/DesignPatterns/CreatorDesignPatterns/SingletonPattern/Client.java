package EducativeIo.DesignPatterns.CreatorDesignPatterns.SingletonPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {
        Runnable run= ()->{
            try {
                Logger.logMessage("testing design patterns ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        List<Thread> testThreads= new ArrayList<>();
        IntStream.range(1,100000000).forEach((number)->testThreads.add(new Thread(run)));
        testThreads.stream().forEach(Thread::run);
    }

}
