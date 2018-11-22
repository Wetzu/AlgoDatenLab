package de.hska.iwi.ads.solution.sorting;


import de.hska.iwi.ads.sorting.AbstractMergesort;

public class Mergesort<E extends Comparable<E>> extends AbstractBaseMergesort {
    /*
    Created by:
        Johannes Essig
        johannes@johannes-essig.de
    Version 1.0
    created on 08.11.2018 at 20:31
    */
    protected void merge(Comparable[] a, int left, int median, int right) {
        int l = left;
        int r = median + 1;
        for (int i = left; i <= right; i++) {
            if (r > right || ((l <= median) && (a[l].compareTo(a[r]) <= 0))) {
                b[i] = a[l];
                l += 1;
            } else {
                b[i] = a[r];
                r += 1;
            }
        }
        for (int i = left; i <= right; i++) {
            a[i] = b[i];
        }
    }
}
