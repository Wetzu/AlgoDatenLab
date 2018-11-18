package de.hska.iwi.ads.solution.Tests;


import de.hska.iwi.ads.solution.sorting.ReverseMergesort;
import de.hska.iwi.ads.sorting.Sort;

public class ReverseMergesortTest extends SortTest {
    /*
    Created by:
        Johannes Essig
        johannes@johannes-essig.de
    Version 1.0
    created on 17.11.2018 at 15:53
    */

    @Override
    public <E extends Comparable<E>> Sort<E> createSort() { return new ReverseMergesort(); }
}
