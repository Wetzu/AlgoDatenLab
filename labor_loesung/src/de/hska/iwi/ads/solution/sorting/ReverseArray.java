package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray implements Reverse {
    @Override
    public void reverse(Comparable[] a, int from, int to) {
        Comparable[] buffer = a.clone();
        int bufferCounter = to;
        for(int i = from; i <= to; i++, bufferCounter--){
            buffer[bufferCounter] = a[i];
        }
        bufferCounter = from;
        for(int i = from; i <= to; i++, bufferCounter++){
            a[i] = buffer[bufferCounter];
        }
    }

    public static void main(String[] args){
        Integer[] toReverse = {5, 4, 3, 2, 1};
        ReverseArray test = new ReverseArray();
        test.reverse(toReverse, 2, 4);
        for(int i = 0; i < toReverse.length; i++){
            System.out.print(toReverse[i] + ", ");
        }
    }
}
