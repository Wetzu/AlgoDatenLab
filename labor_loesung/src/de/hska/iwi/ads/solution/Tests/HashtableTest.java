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

    private Hashtable<Integer, String> ownTestMap = new Hashtable<>(15);

    private Hashtable<Integer, String> newTestHashtable = new Hashtable<>(10);

    @BeforeEach
    void setUp2() {
        newTestHashtable.put(0, "Null");
        newTestHashtable.put(1, "Eins");
        newTestHashtable.put(2, "Zwei");
    }

    @BeforeEach
    void setUp1() {
        // Map with 1,3,5,7,9,11,13
        ownTestMap.put(1, "Eins");
        ownTestMap.put(3, "Drei");
        ownTestMap.put(5, "Fünf");
        ownTestMap.put(7, "Sieben");
        ownTestMap.put(9, "Neun");
        ownTestMap.put(11, "Elf");
        ownTestMap.put(13, "Dreizehn");
    }

    // Testen der get Methode für vorhandenes Element
    @Test
    void testGetDictionary() {
        assertEquals("Eins", ownTestMap.get(1));
    }

    // Testen der get Methode für nicht vorhandenes Element
    @Test
    void testGetDictionary2() {
        assertNull(ownTestMap.get(2));
    }

    // Testen der get Methode für ein Objekt, welches null ist
    @Test
    void testGetDictionary3() {
        assertThrows(NullPointerException.class, () -> ownTestMap.get(null));
    }

    // Testen der put Methode - ein neues Element hinzufügen in sofort leerem Feld
    @Test
    void testPutDictionary1() {
        ownTestMap.put(2, "Zwei");
        assertEquals("Zwei", ownTestMap.get(2));
    }

    // Testen der put Methode - ein neues Element hinzufügen in einem belegtem Feld mit gleichem key
    @Test
    void testPutDictionary2() {
        assertEquals("Eins", ownTestMap.put(1, "NeuEins"));
        assertEquals("NeuEins", ownTestMap.get(1));
    }

    // Testen der put Methode - ein neues Element hinzufügen, wo die Hash Funktion mittels Sondieren genutzt wird
    // Dabei ist der vorhandene key != neuem key
    @Test
    void testHashtableSondieren1() {
        newTestHashtable.put(11, "Neue Eins");
        assertEquals("Neue Eins", newTestHashtable.get(11));
    }

    @Test
    void testHashtableSondieren3() {
        newTestHashtable.put(1, new String("Eins"));
        assertFalse("Eins" == newTestHashtable.get(1));
    }

    @Test
    void testHashtableSondieren2() {
        newTestHashtable.put(12, "Neue Zwei");
        assertEquals("Neue Zwei", newTestHashtable.get(12));
    }

    // DictionaryFullException wird geworfen durch size >= hashtable.length
    @Test
    void testHashtableFull() {
        newTestHashtable.put(3, "Drei");
        newTestHashtable.put(4, "Vier");
        newTestHashtable.put(5, "Fünf");
        newTestHashtable.put(6, "Sechs");
        newTestHashtable.put(7, "Sieben");
        newTestHashtable.put(8, "Acht");
        newTestHashtable.put(9, "Neun");
        assertThrows(AbstractDictionary.DictionaryFullException.class, () -> newTestHashtable.put(10, "Zehn") );
    }
}
