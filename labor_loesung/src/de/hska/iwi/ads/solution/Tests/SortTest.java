package de.hska.iwi.ads.solution.Tests;


import de.hska.iwi.ads.sorting.Sort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class SortTest {
    /*
    Created by:
        Johannes Essig
        johannes@johannes-essig.de
    Version 1.0
    created on 17.11.2018 at 16:31
    */
    public abstract <E extends Comparable<E>> Sort<E> createSort();
    @Test
    void testSortIntegerArray1() {
        Sort<Integer> sort = createSort();
        Integer[] a = {7, 9, 2, 0, 4, 11, 10};
        Integer[] b = {0, 2, 4, 7, 9, 10, 11};
        sort.sort(a);

        assertArrayEquals(b , a);
    }
    @Test
    void testSortIntegerArray2() {
        Sort<Integer> sort = createSort();
        Integer[] a = {0, 2, 4, 7, 9, 10, 11};
        Integer[] b = {0, 2, 4, 7, 9, 10, 11};
        sort.sort(a);

        assertArrayEquals(b, a);
    }
    @Test
    void testSortIntegerArray3() {
        Sort<Integer> sort = createSort();
        Integer[] a = {1, 0, 2, 0, 0, 0, 2, 1, 0};
        Integer[] b = {0, 0, 0, 0, 0, 1, 1, 2, 2};
        sort.sort(a);

        assertArrayEquals(b, a);
    }
    @Test
    void testSortStringArray1() {
        Sort<String> sort = createSort();
        String[] a = {"a", "z", "A", "E", "l"};
        String[] b = {"A", "E", "a", "l", "z" };
        sort.sort(a);

        assertArrayEquals(b, a);
    }
    @Test
    void testSortStringArray2() {
        Sort<String> sort = createSort();
        String[] a = {"F", "e", "A", "F"};
        String[] b = {"A", "F", "F", "e"};
        sort.sort(a);

        assertArrayEquals(b, a);
    }
    @Test
    void testSortStringArray3() {
        Sort<String> sort = createSort();
        String[] a = {"lo", "Hal"};
        String[] b = {"Hal", "lo"};
        sort.sort(a);

        assertArrayEquals(b, a);
    }
    private enum testEnum {Red, Two, Fifteen, MarinaBlue};
    @Test
    void testSortEnumArray1() {
        Sort<testEnum> sort = createSort();
        testEnum[] a = {testEnum.Fifteen, testEnum.Red, testEnum.MarinaBlue, testEnum.Two, testEnum.Two, testEnum.Fifteen};
        testEnum[] b = {testEnum.Red, testEnum.Two, testEnum.Two, testEnum.Fifteen, testEnum.Fifteen, testEnum.MarinaBlue};
        sort.sort(a);

        assertArrayEquals(b, a);
    }
    @Test
    void testEmptyArray1() {
        Sort<Integer> sort = createSort();
        Integer[] a = null;

        assertArrayEquals(a, a);
    }
}
