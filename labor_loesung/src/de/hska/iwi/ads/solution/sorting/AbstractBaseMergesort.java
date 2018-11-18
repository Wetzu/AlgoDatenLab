package de.hska.iwi.ads.solution.sorting;


import de.hska.iwi.ads.sorting.AbstractMergesort;

public abstract class AbstractBaseMergesort extends AbstractMergesort {
    /*
    Created by:
        Johannes Essig
        johannes@johannes-essig.de
    Version 1.0
    created on 17.11.2018 at 14:52
    */
    @Override
    protected void mergesort(Comparable[] a, int left, int right) {
        if(left < right){
            int median = (left + right) / 2;
            mergesort(a, left, median);
            mergesort(a, median + 1, right);
            merge(a, left, median, right);
        }
    }
    abstract void merge(Comparable[] a, int left, int median, int right);

    protected void mergesort(Comparable[] a){
        mergesort(a, 0, a.length - 1);
    }
}
