package com.guocai.DatasTructureAndAlgorithm.hash;

import java.util.Objects;

/**
 * java类简单作用描述
 *
 * @ClassName: HashMap
 * @Package: com.guocai.DatasTructureAndAlgorithm.hash
 * @Description: 自定义HashMap
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-01-27-10:34
 */
public class HashMap<K, V> implements Map<K, V>{

    static class Entry<K, V> {
        final K key;
        V value;

        Entry<K, V> next;

        Entry(K k, V v, Entry<K, V> n){
            this.key = k;
            this.value = v;
            this.next = n;
        }

        public final K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Entry) {
                Entry<?, ?> e = (Entry<?, ?>) o;
                if (Objects.equals(key, e.getKey()) &&
                 Objects.equals(value, e.getValue())){
                    return true;
                }
            }
            return false;
        }

    }

    Entry<K, V>[] table;

    int size;

    double loadFactor;

    int threhold;

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16));
    }

    static int indexFor(int hash, int length) {
        return hash & (length - 1);  // hash % length   length是2的指次方
    }

    static final int DEFAULT_CAPACITY = 16;

    static final double DEFAULT_LOAD_FACTOR = 0.75;

    static final int MAX_NUM_CAPACITY = 1 << 30;

    public HashMap(int capacity, double loadFactor) {
        if (capacity < 0) {
            throw new IllegalArgumentException("初始容量不能小于零!!!");
        }

        if (capacity > MAX_NUM_CAPACITY){
            capacity = MAX_NUM_CAPACITY;
        }
        if (loadFactor < 0) {
            throw new IllegalArgumentException("负载因子不能小于零!!!");
        }

        int actualCapacity = 1;
        while (actualCapacity < capacity){
            actualCapacity <<= 1;
        }

        this.loadFactor = loadFactor;

        threhold = (int) (actualCapacity * loadFactor);

        table = new Entry[actualCapacity];

    }

    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        threhold = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_CAPACITY);
        table = new Entry[DEFAULT_CAPACITY];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V get(K key) {
        if (key == null){
            // 为空先不考虑
            for (Entry<K, V> e = table[0]; e != null; e = e.next){
                if (e.key == null) {
                    return e.value;
                }
            }
            return null;
        }

        int hash = hash(key);
        int index = indexFor(hash, table.length);

        for (Entry<K, V> e = table[index]; e != null; e = e.next){
            if (hash(e.key) == hash && ((e.key == key) || key.equals(e.key))){
                return e.value;
            }
        }

        return null;
    }

    @Override
    public V put(K key, V value) {

        if (key == null) {

            for (Entry<K, V> e = table[0]; e != null; e = e.next){
                if (e.key == null) {
                    V oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
            addEntry(null, value, 0);
            return null;
        }

        int hash = hash(key);
        int index = indexFor(hash, table.length);

        for (Entry<K, V> e = table[index]; e != null; e = e.next){
            if (hash(e.key) == hash && e.key == key){
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }

        addEntry(key, value, index);

        return null;
    }


    void addEntry(K key, V value, int index){
        Entry<K, V> e = table[index];
        table[index] = new Entry<>(key, value, e);
        size++;
        if (size >=threhold){
            resize(2*table.length);
        }
    }

    private void resize(int i){
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity >= MAX_NUM_CAPACITY) {
            threhold = Integer.MAX_VALUE;
            return;
        }
        Entry[]  newTable = new Entry[i];
        transfer(newTable);
        table = newTable;
        threhold = (int) (i * loadFactor);
    }

    private void transfer(Entry[] newTable) {
        Entry[] oldTable = table;
        int newCapacity = newTable.length;
        for (int i=0; i<oldTable.length; i++){
            Entry<K, V> e = oldTable[i];
            if (e != null) {
                oldTable[i] = null;
                do {
                    Entry<K, V> next = e.next;
                    int index = indexFor(hash(e.key),newCapacity);
                    newTable[index] = e;
                    e = next;
                } while (e != null);
            }
        }
    }


    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(V value) {
        if (value == null) {
            for (int i = 0; i < table.length; i++) {
                for (Entry e = table[i]; e != null; e = e.next) {
                    if (e.value == null){
                        return true;
                    }
                }
            }
        }
        for (int i = 0; i < table.length; i++) {
            for (Entry e = table[i]; e != null; e = e.next) {
                if (value.equals(e.value)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V remove(K key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        Entry<K, V> prev = table[index];
        Entry<K, V> e = prev;
        while (e != null) {
            Entry<K, V> next = e.next;
            if (hash(e.key) == hash(key) || ((e.key == key) || (key != null) && (key.equals(e.key)))){
                size--;
                if (prev == e){
                    table[index] = next;
                } else {
                    prev.next = next;
                }
                return (e == null ? null : e.value);
            }
            prev = e;
            e = next;
        }
        return (e == null ? null : e.value);
    }

    @Override
    public void clear() {
        for (int i = 0; i<table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0;i<100;i++){
            map.put(i+"", i);
        }
        System.out.println("map.size() = " + map.size());

        System.out.println("6 = " + map.get("6"));


    }
    
}



















