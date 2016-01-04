package com.lanhuai.study.datastructure.list;

/**
 * @author lanhuai
 */
public interface List<E> {

    /**
     * List 是否为空
     * @return true/false
     */
    boolean isEmpty();

    /**
     * 清空 List
     */
    void clear();

    /**
     * 获取 index 位置的元素
     * @param index 从 0 开始
     * @return 元素
     */
    E get(int index);

    /**
     * 元素在 List 中的位置
     * @param object 元素
     * @return 位置index
     */
    int indexOf(Object object);

    /**
     * 在 index 位置插入元素
     * @param element 等待插入的元素
     * @param index 目标位置
     */
    void insert(E element, int index);

    /**
     * 删除 index 位置的元素
     * @param index 目标位置
     * @return 被删除的元素
     */
    E remove(int index);

    /**
     * List 中元素个数
     * @return 元素个数
     */
    int size();

    /**
     * 将一个 List 合并进来
     * @param list 等待并入的 List
     */
    void addAll(List<? extends E> list);

    Object[] toArray();

    <T> T[] toArray(T[] a);
}
