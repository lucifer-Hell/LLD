package ConceptAndCoding.desginPatterns;

import java.util.ArrayList;
import java.util.HashSet;

public class Test {

    static void reverse(char []arr){
       int i=0,n=arr.length;
       while(i<n){
           int j=i;
           while(i<n && arr[i]!=' ') i++;
//           if(i>=n)break;
           int k=i-1;
           while(j<k){
               // swap with two pointer approach
               char temp=arr[j];
               arr[j]=arr[k];
               arr[k]=temp;
               j++;k--;
           }
           i++;
       }
        System.out.println(arr);

    }
    public static void main(String[] args) {
        String test="This is a long string";
        reverse(test.toCharArray());
    }
}


// resume link
// https://drive.google.com/file/d/1SSZ9kPNBtkdTPzOvlmhCaZs8_74rQuvr/view?usp=sharing

// book :
// desgin patterns :gang of four -- core book
