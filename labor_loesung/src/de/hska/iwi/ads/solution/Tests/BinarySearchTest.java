package de.hska.iwi.ads.solution.Tests;

import de.hska.iwi.ads.search.Search;
import de.hska.iwi.ads.search.SearchTest;
import de.hska.iwi.ads.solution.search.BinarySearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest extends SearchTest {
    @Override
    public <E extends Comparable<E>> Search<E> createSearch() {
        return new BinarySearch();
    }

    @Test
    public void testSearchEmptyIntArray() {
        Search<Integer> search = createSearch();
        Integer[] a = {};

        assertThrows(ArrayIndexOutOfBoundsException.class , () -> search.search(a, 0) );
    }

    @Test
    void testSearchThreadStateEnum1() {
        Search<Thread.State> search = createSearch();
        Thread.State[] a = {Thread.State.RUNNABLE, Thread.State.TERMINATED,  Thread.State.BLOCKED};

        assertEquals(0, search.search(a, Thread.State.RUNNABLE));
    }

    public enum colours {Red, Green, Blue};

    @Test
    void testSearchEnum1() {
        Search<colours> search = createSearch();
        colours[] a = {colours.Red, colours.Blue, colours.Green, colours.Blue};

        assertEquals(2, search.search(a,colours.Green));
    }

    @Test
    void testSearchEnum2() {
        Search<colours> search = createSearch();
        colours[] a = {colours.Red, colours.Blue, colours.Blue, colours.Green, colours.Red};

        assertEquals(0, search.search(a,colours.Red));
    }

    @Test
    void testSearchKeySmaller() {
        Search<Integer> search = createSearch();
        Integer[] a = {5, 7, 9, 12, 1119};

        assertEquals(-1, search.search(a, 3));
    }

    @Test
    void testSearchKeyBigger() {
        Search<Integer> search = createSearch();
        Integer[] a = {5, 7, 9, 12, 1119};

        assertEquals(5, search.search(a, 1500));
    }
}
