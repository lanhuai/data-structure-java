package com.lanhuai.study.datastructure.list;


import java.lang.reflect.Array;

/**
 * @author lanhuai
 */
public class SinglyLinkedList<E> extends AbstractList<E> implements List<E> {

    /**
     * 头结点,不存储数据,head.next指向第一个数据节点
     */
    private final Node<E> head = new Node<E>(null, null);

    private int size;

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (Node<E> node = head.next; node != null;) {
            Node<E> next = node.next;
            node.item = null;
            node.next = null;
            node = next;
        }
        head.next = null;
        head.item = null;
        size = 0;
    }

    public E get(int index) {
        checkIndex(index);

        Node<E> p = head.next;
        int j = 0;

        while (p != null && j < index) {
            p = p.next;
            j++;
        }

        if (p == null || j > index) {
            return null;
        } else {
            return p.item;
        }
    }

    private void checkIndex(int index) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    private void checkIndexForInsert(int index) {
        if (!isValidIndexForInsert(index)) {
            throw new IndexOutOfBoundsException();
        }
    }
    private boolean isValidIndexForInsert(int index) {
        return index >= 0 && index <= size;
    }

    public int indexOf(Object object) {
        int index = 0;
        for (Node<E> node = head.next; node != null; node = node.next) {
            if (object.equals(node.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public void insert(E element, int index) {
        if (element == null) {
            throw new NullPointerException();
        }

        checkIndexForInsert(index);

        int j = 0;
        Node<E> p = head;

        while (p != null && j < index) {
            p = p.next;
            j++;
        }

        if (p == null || j > index) {
            throw new IllegalStateException("position of the index is not exist");
        }

        Node<E> newNode = new Node<E>(element, p.next);
        p.next = newNode;
        size++;
    }

    public E remove(int index) {
        checkIndex(index);
        int j = 0;
        Node<E> p = head;
        while (p != null && j < index) {
            p = p.next;
            j++;
        }

        if (p == null || p.next == null || j > index) {
            throw new IllegalStateException("position of the index is not exist");
        }

        Node<E> next = p.next;
        p.next = next.next;

        E item = next.item;
        next.next = null;
        next.item = null;

        size--;

        return item;
    }

    public int size() {
        return size;
    }

    public Object[] toArray() {
        Object[] objects = new Object[size];

        int j = 0;
        Node<E> p = head;
        while (p != null && j < size) {
            p = p.next;
            objects[j] = p.item;
            j++;
        }

        return objects;
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            // Make a new array of a's runtime type, but my contents:
            Class<?> newType = a.getClass();
            T[] copy = ((Object)newType == (Object)Object[].class)
                    ? (T[]) new Object[size]
                    : (T[]) Array.newInstance(newType.getComponentType(), size);
            int j = 0;
            Node<E> p = head;
            while (p != null && j < size) {
                p = p.next;
                copy[j] = (T) p.item;
                j++;
            }
            return copy;
        }

        int j = 0;
        Node<E> p = head;
        while (p != null && j < size) {
            p = p.next;
            a[j] = (T) p.item;
            j++;
        }

        if (a.length > size)
            a[size] = null;
        return a;

    }
}
