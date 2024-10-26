package Interviews.Cars24;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

class Node{
    Key key;
    Value value;
    Node next;
    Node prev;
    Node(Key key,Value value,Node next ,Node prev){
        this.key=key;
        this.value=value;
        this.next=next;
        this.prev=prev;
    }
}

public class LRUCache {
    HashMap<Key,Node> map;

    Node head ;
    // 1
    // 1 2
    // 1  2  3
    Node tail ;
    int currSize;
    int maxSize;
    LRUCache(int n){
        map=new HashMap<>(n);
        this.maxSize=n;
        this.currSize=0;
    }

    public Node put(Key key,Value value){
        Node temp=new Node(key,value,null,null);
        if(currSize==0){
            head=tail=temp;
        }else{
            // max size case
            if(currSize+1==maxSize){
                // remove lru
                Node th=head;
                head=head.next;
                if(head!=null)head.prev=null;
                map.remove(th.key);
            }
            // update the tail
            // 1 - h -t
            // 1 -h  2 -t
            tail.next=temp;
            temp.prev=tail;
            tail=temp;
        }
        currSize++;
        map.put(key,temp);
        return temp;
    }

    public Node get(Key key){
        Node temp=null;
        if(map.containsKey(key)){
            temp=map.get(key);
           // move it to tail
            // 1 - 3- 2
            //
            Node prev=temp.prev;
            Node next=temp.next;
            if(prev!=null){
                prev.next=next;
            }
            if(next!=null){
                next.prev=prev;
            }
            appendToTail(temp);
        }
        return temp;
    }

    private void appendToTail(Node temp) {
        tail.next=temp;
        temp.prev=tail;
        tail=temp;
    }


    public Value getHotElement(){
        return (tail!=null) ?tail.value:null;
    }




}

class Key{
    String key;
    Key(String key){
        this.key=key;
    }
}

class Value{
    String value;
    Value(String value){
        this.value=value;
    }
}
