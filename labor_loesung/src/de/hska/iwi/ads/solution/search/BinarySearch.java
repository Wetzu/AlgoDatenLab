package de.hska.iwi.ads.solution.search;

import de.hska.iwi.ads.search.Search;

public class BinarySearch implements de.hska.iwi.ads.search.Search {

    @Override
    public int search(Comparable[] a, Comparable key) {
        return 0;
    }

    @Override

    public int search(Comparable[] a, Comparable key, int left, int right) {
        int index = -1;
        if(key.compareTo(a[left]) < 0){
            index = left - 1;
        }
        else if(key.compareTo(a[right]) > 0){
            index = right + 1;
        }
        else {
            boolean found = false;
            for (int i = left; i <= right; i++) {
                if (a[i] == key) {
                    index = i;
                    found = true;
                }
            }
            if(!found){
                for(int i = left; i <= right; i++) {
                    if (key.compareTo(a[i - 1]) < 0 & key.compareTo(a[i]) > 0){
                        index = i;
                    }
                }
            }
        }
        return index;
    }

    public void main(String[] args){
        int[] a = {1, 3, 5, 6, 7, 9};
    }
}
