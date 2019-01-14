package de.hska.iwi.ads.solution.Tests;

import de.hska.iwi.ads.dictionary.MapTest;
import de.hska.iwi.ads.solution.tree.BinarySearchTree;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BinarySearchTreeTest extends MapTest {
    @Override
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
        return new BinarySearchTree<>();
    }

    @Test
    void testEmpty() {
        Map<Integer, String> commonTestMap = new HashMap<>();
        assertEquals(0, commonTestMap.size());
    }

    @Test
    void testPutNode() {
        Map<Integer, String> commonTestMap = new HashMap<>();
        assertNull(commonTestMap.put(2, "Zwei"));
    }

    @Test
    void testPutSameKey() {
        Map<Integer, String> commonTestMap = new HashMap<>();
        assertNull(commonTestMap.put(2, "Zwei"));
        assertEquals("Zwei", commonTestMap.put(2, "NeueZwei"));
        assertEquals("NeueZwei", commonTestMap.get(2));
    }

    @Test
    void testPutSize() {
        Map<Integer, String> commonTestMap = new HashMap<>();
        commonTestMap.put(1, "Eins");
        commonTestMap.put(2, "Zwei");

        assertEquals(2, commonTestMap.size());
    }

    @Test
    void testGet() {
        Map<Integer, String> commonTestMap = new HashMap<>();
        commonTestMap.put(1, "Eins");
        commonTestMap.put(2, "Zwei");
        assertEquals("Zwei", commonTestMap.get(2));
    }

    @Test
    void testGet2() {
        Map<Integer, String> commonTestMap = new HashMap<>();
        commonTestMap.put(1, "Eins");
        commonTestMap.put(2, "Zwei");
        assertNull(commonTestMap.get(3));
    }
}

