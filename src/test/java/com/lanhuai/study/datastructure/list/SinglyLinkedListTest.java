package com.lanhuai.study.datastructure.list;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author lanhuai
 */
public class SinglyLinkedListTest {

    @Test
    public void insert() {
        List<String> list = newSinglyLinkedList();
        printList(list);
        assertEquals("1", list.get(1));

        list.insert("333", 7);
        printList(list);
        assertEquals("7", list.get(8));
        assertEquals("6", list.get(6));

        list.insert("111", 0);
        printList(list);
        assertEquals("111", list.get(0));
        assertEquals("0", list.get(1));

        list.insert("999", list.size() - 1);
        printList(list);
        assertEquals("999", list.get(list.size() - 2));
        assertEquals("9", list.get(list.size() - 1));

        list.insert("xxx", list.size());
        printList(list);
        assertEquals("xxx", list.get(list.size() - 1));
        assertEquals("9", list.get(list.size() - 2));
    }

    @Test(expected = NullPointerException.class)
    public void insertNull() {
        List<String> list = newSinglyLinkedList();
        list.insert(null, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertIndexOutOfBoundsException() {
        List<String> list = newSinglyLinkedList();
        list.insert("xxx", list.size() + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getIndexOutOfBoundsException() {
        List<String> list = newSinglyLinkedList();
        list.get(100);
    }

    @Test
    public void remove() {
        List<String> list = newSinglyLinkedList();
        int size = list.size();
        printList(list);

        list.remove(3);
        printList(list);
        assertEquals(size - 1, list.size());
        assertEquals("4", list.get(3));
        assertEquals("2", list.get(2));
    }

    @Test
    public void clear() {
        List<String> list = newSinglyLinkedList();
        list.clear();
        printList(list);

        assertEquals(0, list.size());
        assertEquals(true, list.isEmpty());

        Object[] objects = list.toArray();
        assertEquals(0, objects.length);
    }

    @Test
    public void indexOf() {
        List<String> list = newSinglyLinkedList();
        printList(list);
        int i = list.indexOf("4");
        assertEquals(4, i);

        i = list.indexOf("xxx");
        assertEquals(-1, i);
    }

    @Test
    public void addAll() {
        List<String> list = newSinglyLinkedList();
        int size = list.size();

        List<String> strList = new SinglyLinkedList<String>();
        strList.insert("h", strList.size());
        list.addAll(strList);
        printList(list);

        assertEquals(size + strList.size(), list.size());
        assertEquals(list.size() - 1, list.indexOf("h"));
    }

    @Test
    public void toArray() {
        List<String> list = newSinglyLinkedList();

        String[] a = new String[0];
        String[] b = list.toArray(a);
        assertTrue(a != b);
        a = b;
        assertEquals(list.size(), a.length);
        assertEquals("9", a[a.length - 1]);

        a = new String[list.size()];
        b = list.toArray(a);
        assertTrue(a == b);
        assertEquals(list.size(), a.length);
        assertEquals("9", a[a.length - 1]);
    }

    private List<String> newSinglyLinkedList() {
        List<String> list = new SinglyLinkedList<String>();
        for (int i = 0; i < 10; i++) {
            list.insert(String.valueOf(i), list.size());
        }
        return list;
    }

    private void printList(List<?> list) {
        System.out.println(StringUtils.join(list.toArray(), ','));
    }

}
