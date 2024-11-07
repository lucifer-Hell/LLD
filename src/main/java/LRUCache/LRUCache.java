package LRUCache;

import java.util.HashMap;

public class LRUCache<K,V> {
    private final HashMap<K,Node<K,V>> map;
    private final Node<K,V> head;
    private final Node<K,V> tail;
    private int remCapacity;
    LRUCache(int capacity){
        // intialize dummy head and tail ptrs
        head=new Node<K,V>(null,null);
        tail=new Node<K,V>(null,null);
        tail.next=head;
        head.prev=tail;
        this.remCapacity=capacity;
        map=new HashMap<>();
    }
    private void appendToHead(Node<K,V> node){
        Node<K,V> prev=head.prev;
        // link prev and node
        prev.next=node;
        node.prev=prev;
        // link head and node
        head.prev=node;
        node.next=head;
    }
    private void delete(Node<K,V> node){
        Node<K,V> prev=node.prev;
        Node<K,V> next=node.next;
        // link prev and next
        prev.next=next;
        next.prev=prev;
        // delink next and prev references of node
        node.next=null;
        node.prev=null;
    }

    public V get(K key) {
        if(map.containsKey(key)){
            Node<K,V> node=map.get(key);
            delete(node);
            // move node to head
            appendToHead(node);
            return node.value;
        }
        return null;
    }

    public void put(K key, V value) {
        Node<K,V> temp=new Node<>(key,value);
        // check if same key is present
       if(map.containsKey(key)){
           Node<K,V> node=map.get(key);
           delete(node);
           map.remove(node.key);
           remCapacity++;
       }
       else if(remCapacity==0){
           // remove last element from tail
           Node<K,V> lastNode=tail.next;
           delete(lastNode);
           map.remove(lastNode.key);
           remCapacity++;
       }
        appendToHead(temp);
        map.put(key,temp);
        remCapacity--;
    }

    private static class Node<K,V>{
        K key;
        V value;
        Node<K,V> next;
        Node<K,V> prev;
        Node(K k,V v){
            this.key=k;
            this.value=v;
        }
    }
}
