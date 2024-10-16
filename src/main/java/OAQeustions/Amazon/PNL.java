package OAQeustions.Amazon;

public class PNL {
    public static void main(String[] args) {
        // [ 5 , 3 , 1, 2]
        // cummulative pnl must be non -ve for each month
        // how many numbers can be turned negatives
        // all array are intially positive
        // 5 + 3 + 1 + 2 = 11
        // 11/2 = 5+1
        // total elems - no of elems req for half sum = negative comb
        // problem least no of elems that can be formed which give half sum
        // [ 1 , 2 , 3 , 5 ]
        //
        /*
        *   [ 5, 2,3, 5, 2, 3]
        *    5 + 5 + 3 + 3  + 2 + 2 = 20
        *    20 / 2 = 10
        *   [2,2,3,3,5,5] = will ony require last two elem to be +ve
        *   [5 ,-2,-3,5,-2,-3]
        *   [5 , 3, 0 , 5, 3, 0]
        *   [ 5 , 2, 3, 5, 2, 3 ]
        *   [ 5 , 2 , 3,
        * */
    }
}
