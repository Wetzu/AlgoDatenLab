package de.hska.iwi.ads.solution.Tests;

import de.hska.iwi.ads.dictionary.MapTest;
import de.hska.iwi.ads.solution.list.DoubleLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleLinkedListTest extends MapTest {
    @Override
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
        return new DoubleLinkedList<>();
    }

    @Test
    void testBigMap() {
        Map<Integer, Integer> myMap = createMap();
        Integer[] testData = new Integer[10000];
        Random randomize = new Random();
        for (int i = 0; i < 10000; i++) {
            int data = randomize.nextInt();
            testData[i] = data;
            myMap.put(i, data);
        }
        Integer[] storedData = new Integer[10000];
        for (int i = 0; i < 10000; i++) {
            storedData[i] = myMap.get(i);
        }
        assertArrayEquals(testData, storedData);
    }

    @Test
    void testArrayMap() {
        Map<Integer, Integer[]> myMap = createMap();
        Integer[][] testArray = {{0, 1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}, {5, 4, 3, 2, 1}, {4, 3, 10, 1, 50}};
        for (int i = 0; i < 4; i++) {
            myMap.put(i, testArray[i]);
        }
        Integer[][] resultArray = new Integer[4][];
        for (int i = 0; i < 4; i++) {
            resultArray[i] = myMap.get(i);
        }
        assertArrayEquals(resultArray, testArray);
    }

    @Test
    void testReplaceInMap() {
        Map<Character, Integer> myMap = createMap();
        char[] enums = {'A', 'c', 'E', 'A', 'F', 'A', 'g'};
        for (int i = 0; i < enums.length; i++) {
            myMap.put(enums[i], i);
        }
        assertEquals(5, (int) myMap.get('A'));
    }

    public enum myEnum {one, three, haus, affe}

    @Test
    void testPutReturnVal() {
        Map<myEnum, String> myMap = createMap();
        myMap.put(myEnum.one, "Test");
        myMap.put(myEnum.affe, "Value");
        myMap.put(myEnum.three, "Wert");
        myMap.put(myEnum.haus, "String");
        assertEquals("Value", myMap.put(myEnum.affe, "Override"));
    }

    @Test
    void testEnumMap() {
        Map<myEnum, String> myMap = createMap();
        myMap.put(myEnum.one, "Test");
        myMap.put(myEnum.affe, "Value");
        myMap.put(myEnum.three, "Wert");
        myMap.put(myEnum.haus, "String");

        assertEquals("Test", myMap.get(myEnum.one));
        assertEquals("Wert", myMap.get(myEnum.three));
        assertEquals("Value", myMap.get(myEnum.affe));
        assertEquals("String", myMap.get(myEnum.haus));
    }

    @Test
    void testStringStringMap() {
        Map<String, String> myMap = createMap();
        myMap.put("entry1", "one");
        myMap.put("a entry", "content");
        myMap.put("another entry", "more content");
        myMap.put("seven", "test");
        myMap.put("CaPsLOCK", "case");
        myMap.put("ALLUPPER", "CASE");
        myMap.put("CamelCase", "sensitive");
        assertEquals(7, myMap.size());
        assertEquals("one", myMap.get("entry1"));
        assertEquals("content", myMap.get("a entry"));
        assertEquals("more content", myMap.get("another entry"));
        assertEquals("test", myMap.get("seven"));
        assertEquals("case", myMap.get("CaPsLOCK"));
        assertEquals("CASE", myMap.get("ALLUPPER"));
        assertEquals("sensitive", myMap.get("CamelCase"));
    }
}