package com.lanhuai.study.datastructure.list;

/**
 * @author lanhuai
 */
public abstract class AbstractList<E> implements List<E> {
    public void addAll(List<? extends E> list) {
        for (int x = 0; x < list.size(); x++) {
            E element = list.get(x);
            if (indexOf(element) < 0) {
                int index = size();
                insert(element, index);
            }
        }
    }
}
