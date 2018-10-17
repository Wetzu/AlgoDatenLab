package de.hska.iwi.ads.solution.search;

public class BinarySearch implements de.hska.iwi.ads.search.Search {

    @Override
    public int search(Comparable[] a, Comparable key) {
        int index = -1;
        if (key.compareTo(a[0]) < 0) {
            index = -1;
        } else if (key.compareTo(a[a.length - 1]) > 0) {
            index = a.length;
        } else {
            boolean found = false;
            for (int i = 0; i <= a.length - 1 & !found; i++) {
                if (a[i] == key) {
                    index = i;
                    found = true;
                }
            }
            if (!found) {
                for (int i = 0; i <= a.length - 1 & !found; i++) {
                    if (key.compareTo(a[i]) > 0 && key.compareTo(a[i + 1]) < 0) {
                        index = i + 1;
                        found = true;
                    }
                }
            }
        }
        return index;
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
            for (int i = left; i <= right & !found; i++) {
                if (a[i] == key) {
                    index = i;
                    found = true;
                }
            }
            for(int i = left; i <= right & !found; i++) {
                if (key.compareTo(a[i]) > 0 && key.compareTo(a[i + 1]) < 0) {
                    index = i + 1;
                    found = true;
                }
            }
        }
        return index;
    }
}
