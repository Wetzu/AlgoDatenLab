package de.hska.iwi.ads.solution.sorting;


import de.hska.iwi.ads.sorting.AbstractMergesort;

public class Mergesort<E extends Comparable<E>> extends AbstractMergesort {
    /*
    Created by:
        Johannes Essig
        johannes@johannes-essig.de
    Version 1.0
    created on 08.11.2018 at 20:31
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

    protected void mergesort(Comparable[] a){
        mergesort(a, 0, a.length - 1);
    }

    private void merge(Comparable[] a, int left, int median, int right){
        int l = left;
        int r = median++;
        for(int i = left; i <= right; i++){
            if(r < right | ((l <= median) & (a[l].compareTo(a[r]) <= 0))){
                b[i] = a[i];
                l = l++;
            }
            else{
                b[i] = a[r];
                r = r++;
            }
        }
        for(int i = left; i <= right; i++){
            a[i] = b[i];
        }
        for(int i =  0; i < a.length; i++){
            System.out.print(a[i]+", ");
        }
    }

    public static void main(String[] args){
        Mergesort merge = new Mergesort();
        Integer[] a = {7, 9, 2, 0, 4, 11, 10};
        merge.sort(a);
        for(int i =  0; i < a.length; i++){
            System.out.print(a[i]+", ");
        }
    }
}
