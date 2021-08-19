package com.lanhuai.study.datastructure.algorithms.sort;

/**
 * @author lanhuai
 */
public class InsertionSort<T> {
    private Comparable<T>[] elements;

    public InsertionSort(Comparable<T>[] elements) {
        this.elements = elements;
    }

    public void sort(boolean desc) {
        assert elements != null : "elements is null";

        // sort asc
        if (!desc) {
            for (int j = 1; j < elements.length; j++) {
                Comparable<T> element = elements[j];

                // insert elements[j] into the sorted sequence elements[0...j - 1]
                int i = j - 1;
                while (i >= 0 && elements[i].compareTo((T) element) > 0) {
                    elements[i + 1] = elements[i];
                    i = i - 1;
                }
                elements[i + 1] = element;
            }
        }

        // sort desc
        if (desc) {
            for (int j = elements.length - 2; j >= 0; j--) {
                Comparable<T> element = elements[j];

                // insert elements[j] into the sorted sequence elements[j + 1...n - 1]
                int i = j + 1;
                while (i < elements.length && elements[i].compareTo((T) element) > 0) {
                    elements[i - 1] = elements[i];
                    i = i + 1;
                }
                elements[i - 1] = element;
            }
        }
    }
}
