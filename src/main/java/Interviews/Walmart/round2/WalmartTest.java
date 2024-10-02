//package Interviews.Walmart.round2;
//
//public class WalmartTest {
//
//    /*
//    * Q1. Find LCA of 2 given nodes in a BST.
//              50
//         /          \
//      35            60
//      /  \         /   \
//    30   36        55  70
//                      /  \
//                    65   80
//                    *
//    Input - 55, 70, Output - 60
//    Input - 65, 10, Output - 50
//    Input - 35, 30 O/p - 30
//    *
//    *  65 , 10
//    * 10
// Stack
// * 55 - { 50 , 60 ,55 }
// *
// * 70 - { 50 , 60 , 70 }  //
// *
//    *
//    *
//    *
//    * */
//
//
//    private Node findLca(int a , int b , Node curr ){
//        if(curr==null) return null;
//        //  curr         a        curr       b
//        //  35      >=  30         35  <=     35
//        if(curr.val>= a && curr.val <=b )  return curr ;
//        if(a >curr.val) findLca(a,b,curr.right);
//        else findLca(a,b,curr.left);
//
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
