package LRUCache;

public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache<Integer,Integer> lruCache=new LRUCache<Integer, Integer>(3);
        lruCache.put(3,4);
        System.out.println(lruCache.get(3));
        lruCache.put(4,8);
        lruCache.put(2,8);
        lruCache.put(1,8);
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));

    }
}
