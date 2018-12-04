package de.hska.iwi.ads.solution.Tests;

import de.hska.iwi.ads.dictionary.MapTest;
import de.hska.iwi.ads.solution.list.DoubleLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class DoubleLinkedListTest extends MapTest {
    @Override
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
        return new DoubleLinkedList<>();
    }
}
