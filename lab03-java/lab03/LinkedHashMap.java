package lab03;

import java.util.*;

public class LinkedHashMap<K, V> implements ILinkedHashMap<K, V> {

    private List<Entry<K, V>> buckets[];
    private final int CAPACITY;


    public LinkedHashMap(int capacity) {
        this.CAPACITY = Math.abs(capacity);
        buckets = new List[CAPACITY];
    }

    public int getIndex(K key) {
        // fixing null values
        // null values are acceptable in Java for generic Types
        if (key == null) return 0;

        int code = Math.abs(key.hashCode());
        return code % CAPACITY;
    }

    @Override
    public int size() {
        Optional<Integer> size = Arrays.stream(buckets).filter(entry -> entry != null).map(entry -> entry.size()).reduce((entry1, entry2) -> entry1 + entry2);
        if (size.isPresent()){
            return size.get();
        }else{
            return 0;
        }
    }

    public int capacity() {
        return CAPACITY;
    }

    public double loadFactor(){
        return 1.0 * size() / capacity();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        return buckets[index] != null
                && buckets[index].size() > 0
                && buckets[index].stream().anyMatch(entry -> entry!=null && Objects.equals(entry.getKey(), key));
        // key could be null
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (!containsKey(key)) {
            Entry<K, V> entry = new Entry<>(key, value);
            if (buckets[index] == null) buckets[index] = new LinkedList<>();
            buckets[index].add(entry);
        } else {
            Optional<Entry<K, V>> entry = buckets[index].stream().filter(i -> i!=null && Objects.equals(i.getKey(), key)).findFirst();
            if (entry.isPresent())
                entry.get().setValue(value);
        }
    }

    @Override
    public void remove(K key) {
        if (containsKey(key)) {
            int index = getIndex(key);

//            buckets[index].removeIf(entry -> entry.equals(key));

            for (int i = 0; i < buckets[index].size(); i++) {
                if (buckets[index].get(i)!=null && Objects.equals(buckets[index].get(i).getKey(), key)) {
                    buckets[index].remove(i);
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {

        if (containsKey(key)) {
            int index = getIndex(key);
            Optional<Entry<K, V>> entry = buckets[index].stream().filter(entry1 -> entry1!=null && Objects.equals(entry1.getKey(), key)).findFirst();
            if (entry.isPresent()) {
                return entry.get().getValue();

            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "LinkedHashMap{" +
                "buckets=" + Arrays.toString(buckets) +
                ", size=" + this.size() +
                ", capacity=" + this.capacity() +
                ", loadFactor=" + this.loadFactor() +
                '}';
    }
}
