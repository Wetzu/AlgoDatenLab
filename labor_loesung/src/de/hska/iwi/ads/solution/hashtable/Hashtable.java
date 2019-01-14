package de.hska.iwi.ads.solution.hashtable;

import de.hska.iwi.ads.dictionary.AbstractHashMap;

public class Hashtable<K extends Comparable<K>, V> extends AbstractHashMap<K, V> {
    public Hashtable(int capacity) {    //passing constructor to parent class
        super(capacity);
    }

    /**
     * get method to get an Entry by its hashed Key
     * throws null pointer exception if Object o is null
     * @param   o of type Object (Key)
     * @return  value of generic type V if found, else null
     */
    @SuppressWarnings("unchecked")
    public V get(Object o) {
        if( o == null) {        //checking for null
            throw new NullPointerException();   //throwing exception
        }
        for (Entry entry : hashtable) { //iterating through the entry's in the hashtable
            if( entry != null && entry.getKey() == o) {
                return (V) entry.getValue();    //returning Entry with matching Key
            }
        }
        return null;    //returning null, no matching entry was found
    }

    /**
     * Put method for inserting elements into the Hashtable
     * @param key Key object of generic type K, which is used as key for inserting the entry
     * @param value Value of generic type V to store in the hashtable
     * @return returns generic type V if the given key already holds a value, the old value is returned
     * before its override
     * If there is no old Value null is returned and if no free Key is found through quadratic probing a
     * DictionaryFullException is thrown
     */
    public V put(K key, V value) throws DictionaryFullException {
        int index = 0;
        SimpleEntry<K, V> entry = new SimpleEntry<>(key, value);
        do {
            index = hashProbe(key, index);
            if ( hashtable[index] == null) {    //checking if a value is stored behind the hash value of Key
                hashtable[index] = entry;
                size++;
                return null;    //returning null as there is no prevoius
            }
            if( hashtable[index].getKey().compareTo(key) == 0) {
                V oldValue = hashtable[index].getValue();
                hashtable[index].setValue(value);
                return oldValue;
            }
            index++;
        } while (index < hashtable.length);
        throw new DictionaryFullException();
    }


//    @SuppressWarnings("unchecked")
//    private V rekursivesEinfuegen(SimpleEntry entry, int index) {
//        if (size == hashtable.length || sondierungsschritt == hashtable.length) {
//            throw new DictionaryFullException();
//        } else if(hashtable[index] == null) {
//            hashtable[index] = entry;
//            size++;
//            return null;
//        } else if (hashtable[index].getKey() == entry.getKey()) {
//            V oldValue = hashtable[index].getValue();
//            hashtable[index] = entry;
//            return oldValue;
//        } else {
//            sondierungsschritt++;
//            int newIndex = hashProbe((K)entry.getKey(), sondierungsschritt);
//            rekursivesEinfuegen(entry, newIndex);
//        }
//        return null;
//    }

    /**
     * Hash Funktion: Berechnung des Index durch den key mod m, dabei ist m die Länge der hashtable
     * @param   key   übergebener Schlüssel vom Typ K vom Objekt SimpleEntry
     * @return  errechneter Index
     */
    private int hash(K key) {
        return Math.abs(key.hashCode() % hashtable.length);
    }
    /**
        Hash Funktion mit Sondierung
        @param  key                     übergebener Schlüssel vom Typ K vom Objekt SimpleEntry
        @param  sondierungsschritt      wird bei Kollision um eins erhöht
        @return neu errechneter Index
     */
    private int hashProbe(K key, int sondierungsschritt) {
        return ( ( hash(key) + sondierungsschritt * sondierungsschritt ) % hashtable.length);
    }
}


