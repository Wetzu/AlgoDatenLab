//package de.hska.iwi.ads.solution.hashtable;
//
//
//import de.hska.iwi.ads.dictionary.AbstractHashMap;
//
//public class Hashtable<K extends Comparable<K>, V> extends AbstractHashMap {
//    /*
//    Created by:
//        Johannes Essig
//        johannes@johannes-essig.de
//    Version 1.0
//    created on 04.12.2018 at 17:12
//    */
//    public static void main(String[] args) {
//        //TODO add Main Method
//    }
//
//    public Hashtable(int capacity) {
//        super(capacity);
//    }
//
//    public V get(K key) {
//        if(key == null){
//            throw new NullPointerException();
//        }
//        Entry<K, V> entry = new search((K) key);
//        if(entry != null){
//            return entry.getValue();
//        }
//        else {
//            return null;
//        }
//    }
//
//    public V put(K key, V value) {
//        if(key == null){
//            throw new NullPointerException();
//        }
//        SimpleEntry<K, V> entry = new SimpleEntry<>(key, value);
//    }
//    private SimpleEntry<K, V> search(K key){
//        for(SimpleEntry<K, V> a: this.entrySet()){
//
//        }
//    }
//}
