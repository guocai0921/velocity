package com.guocai.DatasTructureAndAlgorithm.LinkedAndLinearOfList.list;

/**
 * java类简单作用描述
 *
 * @ClassName: List
 * @Package: com.guocai.DatasTructureAndAlgorithm.LinkedAndLinearOfList.list
 * @Description: 自定义List集合接口
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2018-12-09-10:40
 */
public interface List<E> {

    // 返回线性表的大小
    public int getSize();

    // 判断线性表中是否为空
    public boolean isEmpty();

    // 判断线性表中是否包含元素e
    boolean contains(E e);

    // 在线性表中查找元素e,若成功找到，返回其位置index；否则返回-1
    public int indexOf(E e);

    // 获取线性表中位置为index的元素
    public E get(int index);

    // 将线性表中位置为index的元素设置为e
    public void set(int index, E e);

    // 在线性表中位置为index出添加元素e
    public void add(int index, E e);

    // 在线性表的末尾添加数据
    public void addLast(E e);

    // 删除并发回线性表中位置为index的元素
    public E remove(int index);
}
