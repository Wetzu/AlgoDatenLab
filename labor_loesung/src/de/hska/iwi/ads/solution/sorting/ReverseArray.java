package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray implements Reverse {
    /*
    Created by:
        Johannes Essig
        johannes@johannes-essig.de
    Version 1.1
    created on 14.11.2018 at 14:13
    */
    @Override
    public void reverse(Comparable[] a, int from, int to) {
        Comparable[] buffer = a.clone();        //create storage buffer
        int bufferCounter = to;
        for(int i = from; i <= to; i++, bufferCounter--){   //move a[from] to b[to], incrementing from and decrementing to
            buffer[bufferCounter] = a[i];
        }
        bufferCounter = from;           //reset counter
        for(int i = from; i <= to; i++, bufferCounter++){   //move reversed objects from b to a within specified range
            a[i] = buffer[bufferCounter];
        }
    }
}