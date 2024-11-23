package Interviews.Zeta;

public class Round1 {
/*
* Input: nums = [4,5,6,7,0,1,2], target = 0
[4,5,6,7,0,1,2]
s=0
e= 6
Mid =3
Output: 4


*
*
* */

    private static int getUnBalIdx(int []nums){
        int l=0,n=nums.length,r=n-1;
        while(l<=r){
            if(l==r) return l;
            System.out.println("l "+l+" r "+r);
//            6,7,0,1,2,4,5
            int m=l+(r-l)/2;
            if(nums[l]>nums[m]){
                r=m-1;
            }else{
                // nums[r]<nums[m]
                l=m+1;
            }
        }
        return -1;
    }
    private static int getTargetIdx(int []nums,int t,int l,int r){
        while(l<=r){
            System.out.println("l "+l+" r "+r);
//            6,7,0,1,2,4,5
            int m=l+(r-l)/2;
            if(nums[m]==t) return m;
            else if (t>nums[m]) r= m-1;
            else l=m+1;
        }
        return -1;
    }

    private int findIdx(int []nums ,int t){
        int unBalIdx=getUnBalIdx(nums);
        if(unBalIdx!=-1)
            return Math.max(getTargetIdx(nums,t,0,unBalIdx),getTargetIdx(nums,t,unBalIdx,nums.length-1));
        else return getTargetIdx(nums,t,0, nums.length-1);
    }
    public static void main(String[] args) {


    }
}
