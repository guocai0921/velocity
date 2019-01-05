package com.guocai.DatasTructureAndAlgorithm.LinkedAndLinearOfList.LinkedList;

import com.guocai.DatasTructureAndAlgorithm.LinkedAndLinearOfList.LinearList.ArrayList;
import com.guocai.DatasTructureAndAlgorithm.LinkedAndLinearOfList.list.List;

/**
 * java类简单作用描述
 *
 * @ClassName: LinkedList
 * @Package: com.guocai.DatasTructureAndAlgorithm.LinkedAndLinearOfList.LinkedList
 * @Description: 自定义链表类
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2018-12-09-19:43
 */
public class LinkedList<E> implements List<E> {

    // Node内部类
    private class Node {
        private E data;       // 存储数据
        private Node next;    // 下一个节点

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this(data, null);
        }

        public String toString(){
            return data.toString();
        }

    }

    private Node head;

    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(E e) {
        Node prev = head;
        while (prev != null) {
            if (prev.data.equals(e)){
                return true;
            }
            prev = prev.next;
        }
        return false;
    }

    @Override
    public int indexOf(E e) {
        Node prev = head;
        int index = -1;
        int i = 0;
        while (prev != null) {
            if (prev.data.equals(e)){
                index = i;
                break;
            }
            i++;
            prev = prev.next;
        }
        return index;
    }

    @Override
    public E get(int index) {
        if (index<0 || index>=size){
            throw new IllegalArgumentException("下标越界......");
        }
        Node prev = head;
        E e = null;
        int i = 0;
        while (prev != null) {
            if (i == index){
                e = prev.data;
            }
            i++;
            prev = prev.next;
        }
        return e;
    }

    @Override
    public void set(int index, E e) {
        if (index<0 || index>=size){
            throw new IllegalArgumentException("下标越界......");
        }
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
            p.data = e;
        }
    }

    @Override
    public void add(int index, E e) {
        if (index<0 || index>size){
            throw new IllegalArgumentException("下标越界......");
        }
        // 插入链表头部
        if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            Node prev = head;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            prev.next = new Node(e, prev.next);
            size ++;
        }

    }

    @Override
    public E remove(int index) {
        if (index<0 || index>=size){
            throw new IllegalArgumentException("下标越界......");
        }
        if (index == 0) {
            removeFirst();
        }
        if (index == size-1) {
            removeLast();
        } else {
            Node prev = head;
            for (int i = 0; i < index-1; i++) {
                prev = prev.next;
            }
            Node tmp = prev.next;
            prev.next = tmp.next;
            tmp.next = null;
            size--;
            return tmp.data;
        }
        return null;
    }

    public E removeFirst() {
        if (head == null) {
            return null;
        }
        E result = head.data;
        head = head.next;
        size--;
        return result;
    }

    public E removeLast() {
        if (head == null) {
            return null;
        }
        E result;
        if (head.next == null) {
            result = head.data;
            head = null;
            size--;
            return result;
        } else {
            Node prev = head;
            while (prev.next.next != null) {
                prev = prev.next;
            }
            result = prev.next.data;
            prev.next = null;
        }
        size--;
        return result;
    }

    public void addFirst(E e) {
        Node node = new Node(e, head);
        head = node;
        size++;
    }

    @Override
    public void addLast(E e) {
        Node node = new Node(e, null);
        if (head == null) {
            head = node;
        } else {
            Node prev = head;
            while (prev.next != null) {
                prev = prev.next;
            }
            prev.next = node;
            size++;
        }

    }

    public static void main(String[] args){
        List<String> list = new LinkedList<>();

        list.add(0,"总经理");
        list.add(1,"副总经理");
        list.add(2,"厂长");

        System.out.println("list.get(1) = " + list.get(2));


    }

}
