package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray implements Reverse {
    @Override
    public void reverse(Comparable[] a, int from, int to) {
        int length = to - from;
        Comparable[] buffer = new Comparable[length];
        int bufferCounter = length - 1;
        for(int i = from; i <= to; i++){
            buffer[bufferCounter] = a[i];
            bufferCounter--;
        }
        bufferCounter = 0;
        for(int i = from; i <= to; i++){
            a[i] = buffer[bufferCounter];
            bufferCounter++;
        }
    }
}
