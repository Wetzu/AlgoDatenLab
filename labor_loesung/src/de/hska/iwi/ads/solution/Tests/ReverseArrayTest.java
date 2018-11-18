package de.hska.iwi.ads.solution.Tests;


import de.hska.iwi.ads.solution.sorting.ReverseArray;
import de.hska.iwi.ads.sorting.Reverse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseArrayTest {
    /*
    Created by:
        Johannes Essig
        johannes@johannes-essig.de
    Version 1.0
    created on 17.11.2018 at 14:24
    */
    public ReverseArray createReverseArray() {
        return new ReverseArray();
    }

    @Test
    void testIntArray1() {
        ReverseArray array = createReverseArray();
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] b = {8, 7, 6, 5, 4, 3, 2, 1};
        array.reverse(a, 0, 7);

        assertArrayEquals(b, a);
    }
    @Test
    void testIntArray2() {
        ReverseArray array = createReverseArray();
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] b = {1, 2, 6, 5, 4, 3, 7, 8};
        array.reverse(a, 2, 5);

        assertArrayEquals(b, a);
    }
    @Test
    void testIntArray3() {
        ReverseArray array = createReverseArray();
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] b = {1, 2, 3, 4, 5, 6, 7, 8};
        array.reverse(a, 3, 3);

        assertArrayEquals(b, a);
    }
    @Test
    void testStringArray1() {
        ReverseArray array = createReverseArray();
        String[] a = {"!", "lo", "Hal"};
        String[] b = {"Hal", "lo", "!"};
        array.reverse(a, 0, 2);

        assertArrayEquals(b, a);
    }
    @Test
    void testStringArray2() {
        ReverseArray array = createReverseArray();
        String[] a = {"abc","def","ghi","jkl","mno"};
        String[] b = {"abc","def","ghi","jkl","mno"};
        array.reverse(a, 2, 2);

        assertArrayEquals(b, a);
    }
    public enum colours {Red, Green, Yellow};
    @Test
    void testEnumArray1() {
        ReverseArray array = createReverseArray();
        colours[] a = {colours.Red, colours.Green, colours.Yellow, colours.Red, colours.Green};
        colours[] b = {colours.Red, colours.Green, colours.Yellow, colours.Red, colours.Green};
        array.reverse(a, 0, 4);
        array.reverse(a, 0, 4);

        assertArrayEquals(b, a);
    }
}
