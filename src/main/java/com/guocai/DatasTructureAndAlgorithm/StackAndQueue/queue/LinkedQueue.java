package com.guocai.DatasTructureAndAlgorithm.StackAndQueue.queue;

/**
 * java类简单作用描述
 *
 * @ClassName: LinkedQueue
 * @Package: com.guocai.DatasTructureAndAlgorithm.StackAndQueue.queue
 * @Description: 基于链表的队列
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-01-03-14:09
 */
public class LinkedQueue<E> implements Queue<E>{


    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

    }
    // 头指针
    private Node<E> head;
    // 尾指针
    private Node<E> tail;
    // 队列大小
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        Node<E> prev = tail;
        if (size == 0) {
            head = tail;
        } else {
            prev.next = tail;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (size == 0) {
            throw new RuntimeException("队列为空...");
        }
        E result = head.data;
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return result;
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new RuntimeException("队列为空...");
        }
        return head.data;
    }
}
