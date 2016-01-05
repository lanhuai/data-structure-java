package com.lanhuai.study.datastructure.list;

import java.util.Arrays;

/**
 * @author lanhuai
 */
public class ArrayList<E> extends AbstractList<E> implements List<E> {

    private static final int MAX_SIZE = 20;

    private Object[] elements = new Object[MAX_SIZE];

    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int x = 0; x < size; x++) {
            elements[x] = null;
        }
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    public void insert(E element, int index) {
        if (element == null) {
            throw new NullPointerException();
        }

        if (size == MAX_SIZE) {
            throw new IllegalStateException("ArrayList is full");
        }

        if (index < 0 || index > size) {
            // 末端只允许在紧接着最后一个元素的后面插入
            throw new IndexOutOfBoundsException("Invalid position for insert");
        }

        if (index <= size - 1) {
            // 在现有元素的位置插入
            for (int k = size - 1; k >= index; k--) {
                elements[k + 1] = elements[k];
            }
        }
        elements[index] = element;
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int indexOf(Object object) {
        for (int x = 0; x < size; x++) {
            if (elements[x].equals(object)) {
                return x;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        checkIndex(index);

        E oldValue = (E) elements[index];

        if (index < size - 1) {
            for (int x = index; x < size - 1; x++) {
                elements[x] = elements[x + 1];
            }
        }
        elements[size - 1] = null;// 帮助 GC
        size--;

        return oldValue;
    }

    public int size() {
        return size;
    }

    public Object[] toArray() {
        // 偷懒了,用个现成的
        return Arrays.copyOf(elements, size);
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        // 偷懒了,用个现成的
        if (a.length < size) {
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(elements, size, a.getClass());
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }
}
