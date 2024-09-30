package Interviews.Walmart.round1;

import java.util.HashSet;

public class WalmartTestR1 {

    /*
    *
    * Input: arr[] = {2, 3, -8, 7, -1, 2, 3}
Output: 11
Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.
Input: arr[] = {-2, -4}
Output: –2
Explanation: The subarray {-2} has the largest sum -2.
Input: arr[] = {5, 4, 1, 7, 8}
Output: 25
Explanation: The subarray {5, 4, 1, 7, 8} has the largest sum 25.

    *
    *
    *
    *
    * */

    /*
    *
    *Input: s = "abcabcbb"
    * Output: 3
    * Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: s = "bbbbb"
* Output: 1
* Explanation: The answer is "b", with the length of 1.
Example 3:
Input: s = "pwwkew"
* Output: 3
* Explanation: The answer is "wke", with the length of 3.Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    *
    *
    * */
    public static void main(String[] args) {
//        int []arr= { 5, 4, 1, 7, 8,-8,1};
//        int i=0,n=arr.length,j=1,max=arr[0],currMax=arr[0];
////        int iMax=0,jMax=0;
//        while(j<n){
//            // add j on curr max
//            currMax+=arr[j];
//            if(currMax>=max){
//                max=currMax;
////                iMax=i;
////                jMax=j;
//                j++;
//            }
//            if(currMax<0){
//                currMax=0;
//                i=++j;
//            }
//
//        }
//        // print the range
//        System.out.println("sum is "+max);
        String s="bbbbb";

        HashSet<Character> set=new HashSet<>();
        int currLen=1,maxLen=1;
        set.add(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char currChar=s.charAt(i);
            if(set.contains(currChar)){
                // reset the set
                set=new HashSet<>();
                currLen=1;
            }else{
                currLen++;
                maxLen=Math.max(maxLen,currLen);
            }
            set.add(currChar);

        }
        System.out.println(maxLen);
        // [1,2,3,4,5]
    }
}
