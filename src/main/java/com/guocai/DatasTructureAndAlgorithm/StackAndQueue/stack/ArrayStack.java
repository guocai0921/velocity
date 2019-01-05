package com.guocai.DatasTructureAndAlgorithm.StackAndQueue.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * java类简单作用描述
 *
 * @ClassName: ArrayStack
 * @Package: com.guocai.DatasTructureAndAlgorithm.StackAndQueue
 * @Description: 基于数组的栈
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-01-02-20:24
 */
public class ArrayStack<E> implements Stack<E>{
    private final static int DEFAULT_CAPACITY = 10;

    // 定义一个数组保存数据；
    private E[] data;

    // 栈中元素数量
    private int size;

    // 栈顶索引
    private int top;

    public ArrayStack(int capactiy) {
        this.size = 0;
        this.top = -1;
        this.data = (E[]) new Object[capactiy];
    }

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(E item) {
        // 扩容
        if (data.length == size) {
            grow(size << 1);
        }
        // 添加元素
        data[++top] = item;
        size++;
    }

    private void grow(int i) {
        if (i<DEFAULT_CAPACITY) {
            return;
        }
        data = Arrays.copyOf(data,i);
    }

    @Override
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        size--;

        if (size < data.length/2) {
            grow(data.length/2);
        }
        return data[top--];
    }

    @Override
    public E peek() {
        if (size == 0){
            throw new EmptyStackException();
        }
        return data[top];
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 20; i++) {
            stack.push(i+1);
        }
        System.out.println("stack.pop() = " + stack.pop());

    }
    
}
