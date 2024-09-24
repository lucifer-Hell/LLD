package Dsa.Heap;

public class Heap {
    private final int []arr;
    private final int maxSize;
    private int currSize;
    Heap(int size){
        arr=new int[size];
        maxSize=size;
        currSize=0;
    }

    public void add(int ele) {
        if(currSize>=maxSize){
            System.out.println("head is filled ");
            return;
        };
        // add the element at top
        arr[currSize]=ele;
        int i=currSize;
        while(i>0){
            int parent=getParent(i);
            if(arr[parent]>arr[i]) {
                swap(arr, parent, i);
                i=parent;
            }else break;
        }
        currSize++;
    }

    private int getParent(int i){
        return (i%2==0) ? (i-1)/2:(i)/2;
    }
    // after extract min
    private void heapify() {
        int i=0;
        while(i<currSize){
            int lefChildIdx=getLeftChildIdx(currSize,i);
            int rightChildIdx=getRightChildIdx(currSize,i);
            if(lefChildIdx!=-1 && arr[lefChildIdx]<arr[i]) {
                swap(arr, lefChildIdx,i);
                i=lefChildIdx;
            }else if(rightChildIdx!=-1 && arr[rightChildIdx]<arr[i]) {
                swap(arr, i, rightChildIdx);
                i=rightChildIdx;
            }
            else return;
        }
    }
    private void swap(int []arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    private int getRightChildIdx(int currSize, int i) {
        int idx=2*i+2;
        return (idx)<currSize?idx:-1;
    }

    private int getLeftChildIdx(int currSize,int i) {
        int idx=2*i+1;
        return (idx)<currSize?idx:-1;
    }

    public int pop(){
        if(currSize==0) return -1;
        int ele=arr[0];
        // swap element
        swap(arr,0,currSize-1);
        // reduce size
        currSize--;
        // heapify
        heapify();
        return ele;
    }

    public int peek(){
        if(currSize==0) return -1;
        return arr[0];
    }
}
