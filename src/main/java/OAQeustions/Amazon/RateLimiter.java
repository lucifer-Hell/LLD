package OAQeustions.Amazon;

import java.util.HashMap;

public class RateLimiter {

    private static String getRequestOrder(String request,int minGap){
        // edge case
        if(minGap==0) return  request;
        // assuming regions are between a-z only
        int [] zfreq=new int[26];
        for(char c : request.toCharArray()) zfreq[c-97]++;
        int totalReqs=request.length(),processedReqs=0,elapsedTime=0;
        String outputReq="";
        while (processedReqs!=totalReqs){
            for(int i=0;i<zfreq.length;i++){
                if(zfreq[i]==0) continue;
                outputReq+=(char)(97+i);
                processedReqs++;
                elapsedTime++;
                zfreq[i]--;
                if(elapsedTime>minGap) break;
            }
            // restart with from start
            if(elapsedTime>minGap) {
                elapsedTime=0;
                continue;
            }
            if(processedReqs==totalReqs) break;
            while (elapsedTime<=minGap) {
                outputReq+='_';
                elapsedTime++;
            }
            // reset elapsed time
            elapsedTime=0;
        }
        System.out.println("output is "+outputReq+" with length "+outputReq.length());
        return outputReq;
    }
    public static void main(String[] args) {
        System.out.println(getRequestOrder("aaabbb",2));
        System.out.println(getRequestOrder("abacadaeafag",2));
//        System.out.println((int)'a');
//        System.out.println(122-97);

    }
}
