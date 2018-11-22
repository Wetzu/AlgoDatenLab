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
    void testSortIntegerArray4() {
        Sort<Integer> sort = createSort();
        Integer[] a = {-5, 3, -8, -10, 9, -100};
        Integer[] b = {-100, -10, -8, -5, 3, 9};
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
        Sort<Character> sort = createSort();
        Character[] a = {'F', 'e', 'A', 'F'};
        Character[] b = {'A', 'F', 'F', 'e'};
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
    void testSortEmptyArray1() {
        Sort<Integer> sort = createSort();
        Integer[] a = null;

        assertArrayEquals(a, a);
    }
    @Test
    void testSortDoubleArray1() {
        Sort<Double> sort = createSort();
        Double[] a = {15.154, 2.456, 3.0, -5.3892, 1.125};
        Double[] b = {-5.3892, 1.125, 2.456, 3.0, 15.154};
        sort.sort(a);

        assertArrayEquals(b, a);
    }
    @Test
    void testSortDoubleArray2() {
        Sort<Double> sort = createSort();
        Double[] a = {3.00000000000002, 3.000000000000001, 3.00000000000005, 3.00000000000001};
        Double[] b = {3.000000000000001, 3.00000000000001, 3.00000000000002, 3.00000000000005};
        sort.sort(a);

        assertArrayEquals(b, a);
    }
}
