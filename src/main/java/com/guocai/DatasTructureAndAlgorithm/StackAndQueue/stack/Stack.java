package com.guocai.DatasTructureAndAlgorithm.StackAndQueue.stack;

/**
 * java类简单作用描述
 *
 * @ClassName: Stack
 * @Package: com.guocai.DatasTructureAndAlgorithm.StackAndQueue
 * @Description: 自定义的栈接口
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-01-02-20:18
 */
public interface Stack<E> {

    // 判断栈是否为空
    public boolean empty();

    // 返回栈中的元素数量
    public int size();

    // 压栈
    public void push(E item);

    // 弹栈
    public E pop();

    // 查看栈顶元素(不弹栈)
    public E peek();

}
