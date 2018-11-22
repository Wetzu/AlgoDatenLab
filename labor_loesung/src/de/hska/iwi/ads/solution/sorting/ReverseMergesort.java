package de.hska.iwi.ads.solution.sorting;


import de.hska.iwi.ads.sorting.Reverse;

public class ReverseMergesort extends AbstractBaseMergesort {
    /*
    Created by:
        Johannes Essig
        johannes@johannes-essig.de
    Version 1.0
    created on 17.11.2018 at 14:51
    */
    private ReverseArray reverse = new ReverseArray();

    @Override
    protected void merge(Comparable[] a, int left, int median, int right){
        int l = left;
        int r = right;
        reverse.reverse(a, median + 1, right);
        for(int i = left; i <= right; i++){
            if(a[l].compareTo(a[r]) <= 0){
                b[i] = a[l];
                l += 1;
            }
            else{
                b[i] = a[r];
                r -= 1;
            }
        }
        for(int i = left; i <= right; i++){
            a[i] = b[i];
        }
    }
}