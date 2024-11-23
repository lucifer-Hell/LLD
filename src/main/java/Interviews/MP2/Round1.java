package Interviews.MP2;

public class Round1 {
    private static   int getMinStart(int [] jumps){
        int minSteps=1,currSteps=1;
        for(int jump : jumps){
//            System.out.println("minSteps "+minSteps + " curr "+currSteps);
            if(jump+currSteps>=1) currSteps+=jump;
            else{
                minSteps+=(-(jump+currSteps))+1;
                currSteps=1;
            }
        }
        return minSteps;
    }
    public static void main(String[] args) {
        // given arr = [ 1, -4 , -2 , 3]
        System.out.println(getMinStart(new int[]{1,-4,-2,3}));
        System.out.println(getMinStart(new int[]{5,-2,-2,1}));

    }
}
