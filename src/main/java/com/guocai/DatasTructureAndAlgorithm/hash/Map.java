package com.guocai.DatasTructureAndAlgorithm.hash;

/**
 * java类简单作用描述
 *
 * @ClassName: Map
 * @Package: com.guocai.DatasTructureAndAlgorithm.hash
 * @Description: 自定义Map接口
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-01-27-10:29
 */
public interface Map<K, V> {

    public int size();

    public boolean isEmpty();

    public V get(K key);

    public V put(K key, V Value);

    public boolean containsKey(K key);

    public boolean containsValue(V value);

    public V remove(K key);

    public void clear();

}
