package com.lanhuai.study.datastructure.list;


/**
 * @author lanhuai
 */
public class SinglyLinkedList<E> implements List<E> {

    /**
     * 头结点,不存储数据,head.next指向第一个数据节点
     */
    private Node<E> head;

    private int size;

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    public SinglyLinkedList() {
        this.head = new Node<E>(null, null);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

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
        return 0;
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
        return null;
    }

    public int size() {
        return size;
    }

    public void addAll(List<? extends E> list) {

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

    public <T> T[] toArray(T[] a) {
        return null;
    }
}
