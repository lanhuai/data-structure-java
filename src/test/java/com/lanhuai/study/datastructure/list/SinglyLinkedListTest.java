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
        List<Integer> list = new SinglyLinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.insert(i, list.size());
        }
        printList(list);
        assertEquals(Integer.valueOf(1), list.get(1));

        list.insert(333, 7);
        printList(list);
        assertEquals(Integer.valueOf(7), list.get(8));
        assertEquals(Integer.valueOf(6), list.get(6));
    }

    private void printList(List<?> list) {
        System.out.println(StringUtils.join(list.toArray(), ','));
    }

}
