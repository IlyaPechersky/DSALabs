package lab03;

public

interface ILinkedHashMap<K,V> {
    int size();
    boolean isEmpty();
    void put(K key, V value);
    void remove(K key);
    V get(K key);
}


