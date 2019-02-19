package com.guocai.DatasTructureAndAlgorithm.unionfind;

/**
 * java类简单作用描述
 *
 * @ClassName: UnionFind
 * @Package: com.guocai.DatasTructureAndAlgorithm.unionfind
 * @Description: 并查集接口
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-01-27-18:59
 */
public interface UnionFind {
    public void union(int p, int q); // 把p和q连接起来
    public boolean connected(int p, int q); // 判断p和q是否连通
    public int find(int p); // 找出p所在的集合
    public int count();  // 连通组件个数
}



























