package lab03;

import java.util.Objects;

public class Entry<K, V> {

    private K key;
    private V value;

    public Entry(K key, V value) {
        setKey(key);
        setValue(value);
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;

        var entry = (Entry<K, V>) o;
        return Objects.equals(key, entry.key) && Objects.equals(value, entry.value);

    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "Item{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
