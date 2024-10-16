package OAQeustions.Amazon;

import java.util.Arrays;
import java.util.HashMap;

public class BalProduct {

    private int getMinCost(int []arr){
        int totalProd= Arrays.stream(arr).sum();
        int perUnitCap=totalProd/arr.length;
        int unbalancedUnits=0,unbalancedUnitIdx=-1;
        for(int i=0;i<arr.length;i++)
            if(arr[i]>perUnitCap || arr[i]<perUnitCap) {
                // capture first overwt unit idx
               if(arr[i]>perUnitCap)
                    unbalancedUnitIdx=(unbalancedUnitIdx!=-1)?unbalancedUnitIdx:i;
                unbalancedUnits++;
            }
        int idx=unbalancedUnitIdx;
        // all units are balanced
        if(idx==-1) return 0;
        HashMap<Integer,Integer> costMap=new HashMap<>();
        while (unbalancedUnits>0){
            int currUnit=arr[idx];
            if(currUnit>perUnitCap){
                // add item
//                costMap.put()
            }
        }
        return -1;

    }
    public static void main(String[] args) {

    }
}
