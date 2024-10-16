package OAQeustions.Amazon;

public class LexPalindrome {
    private static String getPalindrome(String str){
        //  C1 C2 C3 C4 C5 -- ODD LENGTH CASE
        //  C  B A B C
        //  A - 1 , C - 2 B- 2 -- IF ODD CHAR ONE FREQ WILL BE ODD PLACE THAT IN CENTER
        //  OUTPUT =   A
        // PROCCED WITH HIGHEST CHAR
        //  OUTPUT =   CAC
        // PROCEED WITH SECOND HIGHEST
        //  OUTPUT =   BCACB
        int [] freqMap=new int[27];
        for(char c:str.toCharArray())
            freqMap[c-97]++;
        int n=str.length();
        String output="";
        if(n%2!=0){
            // find the odd freq char and add in output
            for(int i=0;i< freqMap.length;i++)
                if(freqMap[i]%2!=0){
                    output+=(char)(i+97);
                    freqMap[i]--;
                    break;
                }
        }
        while (true){
            int idx=-1;
            for(int i=freqMap.length-1;i>=0;i--){
                if(freqMap[i]>0){
                    idx=i;
                    break;
                }
            }
            // no char remaining
            if(idx==-1){
                break;
            }
            char temp=(char)(idx+97);
            output=temp+output+temp;
            freqMap[idx]-=2;
        }
        return output;
    }
    public static void main(String[] args) {
        System.out.println(getPalindrome("abbba"));
        System.out.println(getPalindrome("caac"));
    }
}
