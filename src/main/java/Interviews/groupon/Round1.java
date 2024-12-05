package Interviews.groupon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Round1 {
    public static void main(String[] args) {
        // UTTERLY CRAP
        List<Integer> list=new ArrayList<>();
//        list.sort(Comparator.comparing(a)->a[0]);
        list.sort((a, b) -> a - b);
    }
}
