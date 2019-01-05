package com.guocai.DatasTructureAndAlgorithm.StackAndQueue.stack;

import java.util.EmptyStackException;

/**
 * java类简单作用描述
 *
 * @ClassName: LinkedStack
 * @Package: com.guocai.DatasTructureAndAlgorithm.StackAndQueue
 * @Description: 基于链表的栈
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-01-02-20:44
 */
public class LinkedStack<E> implements Stack<E>{

    private static class Node<E> {
        public E data;
        public Node<E> next;

        public Node(E val, Node<E> next) {
            this.data = val;
            this.next = next;
        }
    }

    // 栈顶指针
    private Node<E> top;

    // 栈中数量元素
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
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
        top = new Node<E>(item, top);
        size++;
    }

    @Override
    public E pop() {
        if (size ==0) {
            throw new EmptyStackException();
        }

        E result = top.data;
        top = top.next;
        return result;
    }

    @Override
    public E peek() {
        if (size ==0) {
            throw new EmptyStackException();
        }
        return top.data;
    }
}
