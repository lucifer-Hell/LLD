package Interviews.Multiplier;

public class Round1 {

    private static String say(String no){
        int i=0,n=no.length(),count=0;
        String ans="";
        while(i<n){
            char curr=no.charAt(i);
            count++;
            // 1211
            while(i+1<n && curr==no.charAt(i+1)){
                i++;
                count++;
            }
            ans+=Integer.toString(count)+curr;
            count=0;
            i++;
        }
        return ans;
    }

    private static String countAndSay(int n){
        String []res=new String[n+1];
        res[1]="1";
        for(int i=2;i<=n;i++){
            res[i]=say(res[i-1]);
        }
        return res[n];
    }
    public static void main(String[] args) {
        // countAndSay(5) = say(4)= "31"
      System.out.println(countAndSay(2));
      System.out.println(countAndSay(3));
      System.out.println(countAndSay(4));
      System.out.println(countAndSay(10));


    }
}
