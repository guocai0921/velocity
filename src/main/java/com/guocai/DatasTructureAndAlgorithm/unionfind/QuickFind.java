package com.guocai.DatasTructureAndAlgorithm.unionfind;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

/**
 * java类简单作用描述
 *
 * @ClassName: QuickFind
 * @Package: com.guocai.DatasTructureAndAlgorithm.unionfind
 * @Description: 并查集实现类(用数组表示每个对象)
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-02-01-20:57
 */
public class QuickFind implements UnionFind{

    private int[] id; // 存储对象的id, id[i]表示对象i的标识。
    private int count;

    public QuickFind(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pId = id[p];
        int qId = id[q];

        if (pId == qId) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }

        count--;
    }

    @Override
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

    @Override
    public int find(int p) {
        validate(p);
        return id[p];
    }

    @Override
    public int count() {
        return count;
    }

    private void validate(int p){
        int n = id.length;
        if (p < 0 || p >= n){
            throw new IllegalArgumentException(p+" 必须在0~"+n+"之间...");
        }
    }

    public static void main(String[] args) {
        int N = 10000;
        QuickFind uf = new QuickFind(N);
        Random rand = new Random();

        Instant inst1 = Instant.now();
        for (int i = 0; i < N; i++) {
            int a = rand.nextInt(N);
            int b = rand.nextInt(N);
            uf.union(a, b);
        }
        for (int i = 0; i < N; i++) {
            int a = rand.nextInt(N);
            int b = rand.nextInt(N);
            uf.connected(a, b);
        }
        Instant inst2 = Instant.now();
        System.out.println("Difference in milliseconds : " + Duration.between(inst1, inst2).toMillis());
        System.out.println("Difference in seconds : " + Duration.between(inst1, inst2).getSeconds());
    }

}
