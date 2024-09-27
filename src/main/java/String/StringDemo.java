package String;

import java.util.*;

public class StringDemo {
    public static void main(String[] args) {
        // literals are stored in a special memory ( string pool )
        String literal1= "alpha-wave";
        String literal2="alpha-wave";

        // String objects - each is stored as a new object in heap
        String str1=new String("alpha-wave");
        String str2=new String("alpha-wave");

        // string literals always return true if they are same
        System.out.println(literal1==literal2);
        // string obj always return false since both of them are pointing to diff memory
        System.out.println(str2==str1);
    }
}
