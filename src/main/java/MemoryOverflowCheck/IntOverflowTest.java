package MemoryOverflowCheck;

public class IntOverflowTest {
    public static void main(String[] args) {
        int []arr=new int[1000000000]; // can store upto 10^9 values
        int val=100;
        System.out.println(val);
        val*=100;
        System.out.println(val);
        val*=100;
        System.out.println(val);
        val*=100;
        System.out.println(val);
        val*=10;
        System.out.println(val); // can hold till 10^9 value
        long temp=val* 100L;
        System.out.println(temp);
        temp*= 100L;
        System.out.println(temp);
        temp*= 100L;
        System.out.println(temp);
        temp*= 100L;
        System.out.println(temp);
        temp*= 100L;
        System.out.println(temp);
        temp*= 100L;
        System.out.println(temp);
        temp*= 100L;
        System.out.println(temp); // long can hold upto 10^18
        // float can hold upto 10^38
        // double can hold upto 10^308

    }
}
