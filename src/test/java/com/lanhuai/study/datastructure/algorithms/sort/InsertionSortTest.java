package com.lanhuai.study.datastructure.algorithms.sort;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author lanhuai
 */
public class InsertionSortTest {

    public static final Logger logger = LoggerFactory.getLogger(InsertionSortTest.class);

    @Test
    public void testSort() {
        Integer[] arrayForTest = new Integer[]{4, 1, 9, 3, 8, 2, 6};

        logger.info("InsertionSort : DESC Sort {}", Arrays.toString(arrayForTest));
        InsertionSort<Integer> insertionSort = new InsertionSort<>(arrayForTest);
        insertionSort.sort(true);

        logger.info("Result: {}", Arrays.toString(arrayForTest));
        assertNotNull("Result array is null", Arrays.toString(arrayForTest));
        assertArrayEquals("Desc sort error", new Integer[]{9, 8, 6, 4, 3, 2, 1}, arrayForTest);

        arrayForTest = new Integer[]{4, 1, 9, 3, 8, 2, 6};

        logger.info("InsertionSort : ASC Sort {}", Arrays.toString(arrayForTest));
        insertionSort = new InsertionSort<>(arrayForTest);
        insertionSort.sort(false);
        logger.info("Result: {}", Arrays.toString(arrayForTest));

        assertNotNull("Result array is null", arrayForTest);
        assertArrayEquals("Asc sort error", new Integer[]{1, 2, 3, 4, 6, 8, 9}, arrayForTest);

    }
}
