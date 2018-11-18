package de.hska.iwi.ads.solution.Tests;

import de.hska.iwi.ads.solution.sorting.Mergesort;
import de.hska.iwi.ads.sorting.Sort;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.ChronoLocalDate;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MergesortTest extends SortTest {
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
}
