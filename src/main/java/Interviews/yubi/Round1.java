package Interviews.yubi;

import java.util.Map;

public class Round1 {

    /*
    * Given a binary array nums and an integer k,
    * return the maximum number of consecutive 1's in the array
    * if you can flip at most k 0's.

    Example 1:

    Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
    Output: 6
    Explanation: [1,1,1,0,0,(1),1,1,1,1,(1)] numbers in
    * brackets were flipped from 0 to 1. The longest subarray is underlined.
    *
    * */

    private static int maxConsecutiveNo(int []nums,int k){
        if(nums.length==0) return 0;
        k= Math.max(k, 0);
        int maxLen=0,i=0,j=0,currLen=0,n=nums.length;
        while(j<n){
            if(nums[j]==1){
                currLen++; j++;
            }else{
                if(k>0) {
                    currLen++;
                    k--;
                    j++;
                }else{
                    while(nums[i]!=0) {
                        i++;
                        currLen--;
                    }
                    // extra for zero idx
                    i++;k++;
                    currLen--;
                }
            }
            maxLen= Math.max(maxLen,currLen);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(maxConsecutiveNo(new int[]{1,1,1,0,0,0,1,1,1,1,0},-1));
//        [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
        System.out.println(maxConsecutiveNo(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));

    }
}
