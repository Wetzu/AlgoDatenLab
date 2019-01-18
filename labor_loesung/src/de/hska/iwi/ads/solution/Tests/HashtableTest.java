package de.hska.iwi.ads.solution.Tests;

import de.hska.iwi.ads.dictionary.AbstractDictionary;
import de.hska.iwi.ads.dictionary.MapTest;
import de.hska.iwi.ads.solution.hashtable.Hashtable;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashtableTest extends MapTest {
    @Override
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
        return new Hashtable<>(20);
    }

    private Hashtable<Integer, String> TestHashTable = new Hashtable<>(15);

    private Hashtable<Integer, String> additionalTestHashTable = new Hashtable<>(10);

    @BeforeEach
    void setUp2() {
        additionalTestHashTable.put(0, "Null");
        additionalTestHashTable.put(1, "Eins");
        additionalTestHashTable.put(2, "Zwei");
    }

    @BeforeEach
    void setUp1() {
        // Map with 1,3,5,7,9,11,13
        TestHashTable.put(1, "Eins");
        TestHashTable.put(3, "Drei");
        TestHashTable.put(5, "Fünf");
        TestHashTable.put(7, "Sieben");
        TestHashTable.put(9, "Neun");
        TestHashTable.put(11, "Elf");
        TestHashTable.put(13, "Dreizehn");
    }

    @Test
    void testGetDictionary() {
        assertEquals("Eins", TestHashTable.get(1));
    }

    @Test
    void testGetDictionary2() {
        assertNull(TestHashTable.get(2));
    }

    @Test
    void testGetDictionary3() {
        assertThrows(NullPointerException.class, () -> TestHashTable.get(null));
    }

    @Test
    void testPutDictionary1() {
        TestHashTable.put(2, "Zwei");
        assertEquals("Zwei", TestHashTable.get(2));
    }

    @Test
    void testPutDictionary2() {
        assertEquals("Eins", TestHashTable.put(1, "NeuEins"));
        assertEquals("NeuEins", TestHashTable.get(1));
    }

    @Test
    void testHashtableProbing1() {
        additionalTestHashTable.put(11, "Neue Eins");
        assertEquals("Neue Eins", additionalTestHashTable.get(11));
    }

    @Test
    void testHashtableProbing3() {
        additionalTestHashTable.put(1, new String("Eins"));
        assertFalse("Eins" == additionalTestHashTable.get(1));
    }

    @Test
    void testHashtableProbing2() {
        additionalTestHashTable.put(12, "Neue Zwei");
        assertEquals("Neue Zwei", additionalTestHashTable.get(12));
    }

    @Test
    void testHashtableFull() {
        additionalTestHashTable.put(3, "Drei");
        additionalTestHashTable.put(4, "Vier");
        additionalTestHashTable.put(5, "Fünf");
        additionalTestHashTable.put(6, "Sechs");
        additionalTestHashTable.put(7, "Sieben");
        additionalTestHashTable.put(8, "Acht");
        additionalTestHashTable.put(9, "Neun");
        assertThrows(AbstractDictionary.DictionaryFullException.class, () -> additionalTestHashTable.put(10, "Zehn") );
    }
}
