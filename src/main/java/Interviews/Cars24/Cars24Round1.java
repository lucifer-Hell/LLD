package Interviews.Cars24;

public class Cars24Round1 {

    /*
    * Design an least recently used cache having methods with complexity o(1)
      Fixed size of N
        1. V get(K key); --
        2. put(K key. V value);
        3. V hotElement(); -- get most recently used element
    * head
    *  node 1 , node2 ,
    * tail
    *  Deque --
    *  HashMap<Key,Value> map
    *
    * */
    public static void main(String[] args) {
        int n=4;
        LRUCache lruCache=new LRUCache(n);
        Key key1=new Key("1");
        Value val1=new Value("test val");
        Key key2=new Key("2");
        Value val2=new Value("test val 2");
        Key key3=new Key("3");
        Value val3=new Value("test val 3");
        Key key4=new Key("4");
        Value val4=new Value("test val 4");

        Key key5=new Key("5");
        Value val5=new Value("test val 5");
        lruCache.put(key1,val1);
        System.out.println(lruCache.get(key1).value.value);
        lruCache.put(key2,val2);
        System.out.println(lruCache.get(key2).value.value);
        lruCache.put(key3,val3);
        lruCache.put(key4,val4);
        lruCache.put(key5,val5);
        System.out.println(lruCache.get(key1).value.value);


    }
}
