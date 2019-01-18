package de.hska.iwi.ads.solution.hashtable;

import de.hska.iwi.ads.dictionary.AbstractHashMap;

public class Hashtable<K extends Comparable<K>, V> extends AbstractHashMap<K, V> {
    public Hashtable(int capacity) {    //passing constructor to parent class
        super(capacity);
    }

    /**
     * Get-method to get an Entry by its hashed Key
     * throws null pointer exception if Object o is null
     * @param   o of type Object (Key)
     * @return  value of generic type V if found, else null
     */
    @SuppressWarnings({"unchecked", "ConstantConditions"})
    public V get( Object o) {
        K key = (K) o;
        int index, probing = 0;
        do {
            index = hashProbe(key, probing);    //getting index based on hash and the current probeWidth
            if (hashtable[index] == null) {    //checking if index doesn't hold an entry
                return null;    //returning null as there is no entry with the key
            }
            if(hashtable[index].getKey().compareTo(key) == 0) {    //checking if Keys are equal
                return hashtable[index].getValue();        //returning Entry with matching Key
            }
            probing++;    //iterating
        } while (probing < hashtable.length);
        return null;    //returning null, no matching entry was found
    }

    /**
     * Put-method for inserting elements into the Hashtable
     * @param key Key object of generic type K, which is used as key for inserting the entry
     * @param value Value of generic type V to store in the hashtable
     * @return returns generic type V if the given key already holds a value, the old value is returned
     * before its override
     * If there is no old Value null is returned and if no free Key is found through quadratic probing a
     * DictionaryFullException is thrown
     */
    public V put(K key, V value) throws DictionaryFullException {
        int index, probing = 0;
        SimpleEntry<K, V> entry = new SimpleEntry<>(key, value);
        do {
            index = hashProbe(key, probing);    //getting index based on hash and the current probeWidth
            if (hashtable[index] == null) {    //checking if index doesn't hold an entry yet
                hashtable[index] = entry;       //storing the entry in the hashtable
                size++;
                return null;    //returning null as there is no previous
            }
            if(hashtable[index].getKey().compareTo(key) == 0) {    //checking if Keys are equal
                V oldValue = hashtable[index].getValue();
                hashtable[index].setValue(value);   //storing newValue
                return oldValue;        //returning oldValue
            }
            probing++;    //iterating
        } while (probing < hashtable.length);
        throw new DictionaryFullException();    //less than 50% free indices, dictionary is not necessarily
                                                //completely filled, current hash didn't find a free index
    }
    /**
        hash function implementing quadratic probing
        @param  key of generic Type K, get's hashed
        @param  probeWidth gets incremented with each collision, responsible for the quadratic growth
        @return the new index, based on the hash value and the current probeWidth
     */
    private int hashProbe(K key, int probeWidth) {
        return (Math.abs(key.hashCode()) + probeWidth * probeWidth) % hashtable.length;
    }
}


