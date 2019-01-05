package com.guocai.DatasTructureAndAlgorithm.LinkedAndLinearOfList.LinearList;

import com.guocai.DatasTructureAndAlgorithm.LinkedAndLinearOfList.list.List;

import java.util.Arrays;

/**
 * java类简单作用描述
 *
 * @ClassName: ArrayList
 * @Package: com.guocai.DatasTructureAndAlgorithm.LinkedAndLinearOfList.LinearList
 * @Description: 自己实现的ArrayList
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2018-12-09-11:41
 */
public class ArrayList<E> implements List<E> {

    private  static final int DEFAULT_CAPACITY = 10;

    private E[] data;

    private int size;

    public ArrayList(int capacity) {
        this.size = 0;
        data = (E[]) new Object[capacity];
    }

    public ArrayList() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        if (index<0 || index>=size){
            throw new IllegalArgumentException("数组下标越界!");
        }
        return data[index];
    }

    @Override
    public void set(int index, E e) {
        if (index<0 || index>=size){
            throw new IllegalArgumentException("数组下标越界!");
        }
        data[index] = e;
    }

    @Override
    public void add(int index, E e) {
        if (index<0 || index>size){
            throw new IllegalArgumentException("数组下标越界!");
        }
        if (size == data.length) {
            grow(2*data.length);
        }

        for (int i=size-1;i>=index;i--) {
            data[i+1] = data[i];
        }
        data[index] = e;

        size++;

    }

    @Override
    public E remove(int index) {
        if (index<0 || index>=size){
            throw new IllegalArgumentException("数组下标越界!");
        }
        E val = data[index] ;
        for (int i = index+1; i <size ; i++) {
            data[i-1] = data[i];
        }

        size--;

        data[size] = null;

        if (size < data.length/2) {
            grow(data.length/2);
        }

        return val;
    }

    //
    public void addLast(E e){
        add(size,e);
    }

    private  void grow(int newCapacity){
        /*E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;*/
        data = Arrays.copyOf(data,newCapacity);
    }

    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            list.add(i, i);
        }

        for (int i = 0; i < 100; i++) {
            System.out.println("The" + i + "The Element is:" +list.get(i));
        }

        System.out.println("list.getSize() =s " + list.getSize());

        for (int i = 0; i <50 ; i+=8) {
            list.remove(i);
        }

        System.out.println("list.getSize() = " + list.getSize());

        for (int i = 0; i < list.getSize(); i++) {
            System.out.println("The sd " + i + "The Element is:" +list.get(i));
        }

    }
}
