package de.hska.iwi.ads.solution.list;

import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;

import java.util.Iterator;

public class DoubleLinkedList<K extends Comparable<K>, V> extends AbstractDoubleLinkedList<K, V> {
    @Override
    public V get(Object o){
        if (o == null) {        //check if key is null
            throw new NullPointerException();
        }
        Entry<K, V> entry = search((K) o);
        if (entry != null) {
            return entry.getValue();
        } else {
            return null;
        }
    }
    public V put(K key, V value){
        if (key == null){       //check for nullPointer
            throw new NullPointerException();
        }
        SimpleEntry<K, V> entry = new SimpleEntry<K, V>(key, value);
        SimpleEntry<K, V> oldEntry = search(key);
        if (oldEntry != null) {             //look for old entry
            V oldValue = oldEntry.getValue();
            oldEntry.setValue(value);       //replace Value
            return oldValue;                //return Value
        } else {
            ListElement element = new ListElement(entry, null, null);
            if (this.head == null) {
                this.head = element;
                size++;
            } else {
                this.head.previous = element;
                element.next = this.head;
                this.head = element;
                size++;
            }
        }
        return null;
    }
    private SimpleEntry<K, V> search(K key){        //search for Key
        for (Entry<K, V> a: this.entrySet()) {
            if(a.getKey().compareTo(key) == 0){     //compare Key to key of current Entry
                return (SimpleEntry <K, V>) a;             //return Entry
            }
        }
        return null;
    }
}
