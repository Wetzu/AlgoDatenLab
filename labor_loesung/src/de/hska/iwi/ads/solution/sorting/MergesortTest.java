package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Sort;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.ChronoLocalDate;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MergesortTest {
    /*
    Created by:
        Johannes Essig
        johannes@johannes-essig.de
    Version V1
    created on 08.11.2018 at 20:48
    */

    public <E extends Comparable<E>> Mergesort<E> createSort() {
        return new Mergesort();
    }

    @Test
    void testSortIntegerArray() {
        Mergesort<Integer> sort = createSort();
        Integer[] a = {7, 9, 2, 0, 4, 11, 10};
        Integer[] b = {0, 2, 4, 7, 9, 10, 11};
        sort.sort(a);

        assertArrayEquals(b , a);
    }


}
