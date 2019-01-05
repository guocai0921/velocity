package com.guocai.DatasTructureAndAlgorithm.StackAndQueue.queue;

/**
 * java类简单作用描述
 *
 * @ClassName: Queue
 * @Package: com.guocai.DatasTructureAndAlgorithm.StackAndQueue.queue
 * @Description: 自定义队列
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-01-02-21:23
 */
public interface Queue<E> {
    // 返回队列元素数量
    public int size();

    // 队列是否为空
    public boolean empty();

    // 入队
    public void enqueue(E e);

    // 出队
    public E dequeue();

    // 查看队首元素
    public E peek();
}
