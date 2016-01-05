package com.lanhuai.study.datastructure.list;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author lanhuai
 */
public class ArrayListTest {

    @Test
    public void insert() {
        List<String> list = new ArrayList<String>();
        int size = list.size();
        assertEquals(0, size);

        String element = "element";
        list.insert(element, list.size());
        assertEquals(1, list.size());
        assertEquals(element, list.get(size));

        printList(list);

        list = newArrayList();
        size = list.size();
        list.insert(element, 3);
        assertEquals(size + 1, list.size());
        assertEquals(element, list.get(3));
        assertEquals("d", list.get(4));
        printList(list);

        list.insert(element, list.size() - 1);
        assertEquals("g", list.get(list.size() - 1));
        printList(list);

        list.insert(element, list.size());
        assertEquals(element, list.get(list.size() - 1));
        printList(list);
    }

    @Test(expected = NullPointerException.class)
    public void insertNull() {
        List<String> list = new ArrayList<String>();
        list.insert(null, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertIndexOutOfBoundsException() {
        List<String> list = newArrayList();
        list.insert("xxx", list.size() + 1);
    }

    @Test
    public void get() {
        List<String> list = newArrayList();
        String s = list.get(3);
        assertEquals("d", s);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getIndexOutOfBoundsException() {
        List<String> list = newArrayList();
        list.get(100);
    }

    @Test
    public void remove() {
        List<String> list = newArrayList();
        int size = list.size();

        // 删除最后一个
        String remove = list.remove(list.size() - 1);
        assertEquals("g", remove);
        assertEquals(size - 1, list.size());
        assertEquals("f", list.get(list.size() - 1));
        printList(list);

        // 删除倒数第二个
        remove = list.remove(list.size() - 2);
        assertEquals("e", remove);
        assertEquals(size - 2, list.size());
        assertEquals("f", list.get(list.size() - 1));
        printList(list);

        // 删除第一个
        remove = list.remove(0);
        assertEquals("a", remove);
        assertEquals(size - 3, list.size());
        assertEquals("f", list.get(list.size() - 1));
        assertEquals("b", list.get(0));
        printList(list);

        // 删除第二个
        remove = list.remove(1);
        assertEquals("c", remove);
        assertEquals(size - 4, list.size());
        assertEquals("f", list.get(list.size() - 1));
        assertEquals("b", list.get(0));
        assertEquals("d", list.get(1));
        printList(list);
    }

    @Test
    public void indexOf() {
        List<String> list = newArrayList();

        int index = list.indexOf("e");
        assertEquals(4, index);

        index = list.indexOf("xxxx");
        assertEquals(-1, index);
    }

    @Test
    public void clear() {
        List<String> list = newArrayList();
        list.clear();
        assertEquals(0, list.size());
        assertEquals(true, list.isEmpty());
        printList(list);

        Object[] objects = list.toArray();
        assertEquals(0, objects.length);
    }

    @Test
    public void addAll() {
        List<String> list = newArrayList();
        int size = list.size();

        List<String> strList = new ArrayList<String>();
        strList.insert("h", strList.size());
        list.addAll(strList);
        printList(list);

        assertEquals(size + strList.size(), list.size());
        assertEquals(list.size() - 1, list.indexOf("h"));
    }

    @Test
    public void toArray() {
        List<String> list = newArrayList();

        String[] a = new String[0];
        String[] b = list.toArray(a);
        assertTrue(a != b);
        a = b;
        assertEquals(list.size(), a.length);
        assertEquals("g", a[a.length - 1]);

        a = new String[list.size()];
        b = list.toArray(a);
        assertTrue(a == b);
        assertEquals(list.size(), a.length);
        assertEquals("g", a[a.length - 1]);
    }

    private void printList(List<String> list) {
        System.out.println(StringUtils.join(list.toArray(), ','));
    }

    private List<String> newArrayList() {
        String[] elements = new String[]{"a", "b", "c", "d", "e", "f", "g"};
        List<String> list = new ArrayList<String>();
        for (int x = 0; x < elements.length; x++) {
            list.insert(elements[x], list.size());
        }
        return list;
    }
}
