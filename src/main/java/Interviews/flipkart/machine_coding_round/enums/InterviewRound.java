package Interviews.flipkart.machine_coding_round.enums;

public class InterviewRound {
//    static int [][] dirs ={
//            {0,1},{1,0},{0,-1},{-1,0}
//    };
//
//    // main func
//    static int getMaxChoc(int x, int y , int [][]mat , boolean [][]visited) {
//        // out of bound  or visited case
//        if(x>=mat.length || x<0 || y>=mat[0].length || y<0 || visited[x][y] || mat[x][y]==0) return 0;
//        int currReward=0;
//        visited[x][y]=true;
//        for(int  [] dir : dirs){
//            int xi=dir[0]+x;
//            int yi=dir[1]+y;
//            currReward=Math.max(currReward,getMaxChoc(xi,yi,mat,visited));
//        }
//        visited[x][y]=false;
//        return currReward+mat[x][y];
//    }
//
//    public static void main(String[] args) {
//        /*
//        *  [[0,6,0],
// [5,8,7],
// [0,9,0]]
//
//        *
//        * */
////        int [][]mat={
////                {0,6,0},
////                {5,8,7},
////                {0,9,0}
////        };
//
//        int [][]mat={
//                {1,0,7},
//                {2,0,6},
//                {3,4,5},
//                {0,3,0},
//                {9,0,20}
//        };
//        int n=mat.length,m=mat[0].length;
//        boolean visited[][]=new boolean[n][m];
//        int maxAns=0;
//        // n rows m colns  n==m
//        // n*m*n*m
//        for(int i=0;i<mat.length;i++){   //  n
//            for(int j=0;j<mat[i].length;j++){  // m
////                if(!visited[i][j]){
//                    maxAns=Math.max(maxAns,getMaxChoc(i,j,mat,visited));  // n*m
////                }
//            }
//        }
//        System.out.println("ans "+maxAns);
//    }

    private static int getMinTime(int []ranks,int sofas,int idx){
        // [4,3,2,1,1,1]
        if(idx==ranks.length) return Integer.MAX_VALUE;
        int time=Integer.MAX_VALUE;
        for(int i=1;i<=sofas;i++){
            if(sofas-i>0){
                int temp=getMinTime(ranks,sofas-i,idx+1);
                time=Math.min(time,Math.min(i*i*ranks[idx],temp));
            }
            else time=Math.min(time,i*i*ranks[idx]);
        }
        return  time;
    }

//    private static int getMinTime(int []ranks ,int sofas){
//        int z= sofas;
//        for(int i=)
//    }
    public static void main(String[] args) {
        int[]  ranks =new int []{4,2,3,1} ;
        int sofas = 10;
        System.out.println(getMinTime(ranks,sofas,0));
    }
}
