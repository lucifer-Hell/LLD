package Leetcode.dailyChallenges;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Problem862 {


    public static int shortestSubarray(int[] nums, int k) {

        int minLen=Integer.MAX_VALUE,n=nums.length;
        int []prefix=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=nums[i]+prefix[i-1];
        }
//        System.out.println("prefix arr "+Arrays.toString(prefix));
        // for mantaing the minimal no removal candidates idx
        Deque<Integer> dq=new LinkedList<>();
        for(int i=0;i<n;i++){
//            System.out.println("at i: "+i+" dq is "+Arrays.toString(dq.toArray()));
            if(prefix[i]>=k) minLen=Math.min(minLen,i+1);
            while(!dq.isEmpty() && (prefix[i]-prefix[dq.peek()]>=k)){
                minLen=Math.min(minLen,(i-dq.peek()));
                dq.removeFirst();
            }
            while (!dq.isEmpty() && (prefix[i]<prefix[dq.peekLast()])){
                dq.removeLast();
            }
            dq.add(i);
        }
        return minLen==Integer.MAX_VALUE?-1:minLen;
    }
    public static void main(String[] args) {
        System.out.println(shortestSubarray(new int[]{
                -3,2,-3,-5,-1,10
        },10));
    }
}
