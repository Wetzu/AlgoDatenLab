package de.hska.iwi.ads.solution.sorting;

public class ReverseMergesort extends AbstractBaseMergesort {
    /*
    Created by:
        Johannes Essig
        johannes@johannes-essig.de
    Version 1.2
    created on 14.11.2018 at 14:51
    */
    private ReverseArray reverse = new ReverseArray();

    @Override
    protected void merge(Comparable[] a, int left, int median, int right){
        int l = left;
        int r = right;
        reverse.reverse(a, median + 1, right);      //reverse array
        for(int i = left; i <= right; i++){
            if(a[l].compareTo(a[r]) <= 0){  //sort
                b[i] = a[l];    //move value to storage
                l += 1;
            }
            else{
                b[i] = a[r];    //move value to storage
                r -= 1;         //decrement, because right half is reversed
            }
        }
        for(int i = left; i <= right; i++){
            a[i] = b[i];        //rebuild a with sorted values in b
        }
    }
}