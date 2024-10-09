package OAQeustions.Amazon;

public class LexicoGraph {

    private static String nextString(String str){
        // non repating case
        boolean hasRepatingChar=false;
        int repeatingIdx=-1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                hasRepatingChar=true;
                repeatingIdx=i;
                break;
            }
        }
        int idx=(hasRepatingChar)?repeatingIdx:str.length()-1;
        // traverse till non first z char
        while (idx>=0 && str.charAt(idx)=='z') idx--;
        if(idx<0) return 'a'+str;
        else {
            // incr the non z char
            String output=(idx-1>=0)?str.substring(0,idx):"";
            char c= (char) (str.charAt(idx)+1);
            output+=c;
            // append ab pattern till the end
            output+=generateABStr(str.length()-idx-1);
            return output;
        }
    }

    private static String generateABStr(int len) {
        boolean isB=false;
        String out="";
        int curr=0;
        while(curr<len) {
            out += (isB) ? 'b' : 'a';
            isB=!isB;
            curr++;
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println(nextString("abbd"));
        System.out.println(nextString("abbc"));
        System.out.println(nextString("abbbbbcccccddddd"));
        System.out.println(nextString("zzzz"));
        System.out.println(nextString("abzz"));


    }
}
