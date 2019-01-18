package de.hska.iwi.ads.solution.tree;

import de.hska.iwi.ads.dictionary.AbstractBinaryTree;

public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractBinaryTree<K, V> {

    private Node search(Node node, K key) {
        if (node == null || node.entry.getKey().compareTo(key) == 0) {   //checking if node is null or key is equal
            return node;    //returning current node
        }

        if (node.entry.getKey().compareTo(key) > 0){
            return search(node.left, key);      //searching recursive on left side
        }
        return search(node.right, key);         //searching recursive on right side
    }

    private Node insertRecursive(Node node, K key, V value) {
        if (node == null) {     //checking for null
            node = new Node(key, value);
            return node;
        }

        if (key.compareTo(node.entry.getKey()) < 0) {   //recursive search to the left
            node.left = insertRecursive(node.left, key, value);
        } else if (key.compareTo(node.entry.getKey()) > 0) {        //recursive search to the right
            node.right = insertRecursive(node.right, key, value);
        }
        return node;
    }

    public V get(Object key) {
        Node node = search(root, (K) key);  //getting node via search
        if (node != null) { //checking that node is not null
            return node.entry.getValue();   //returning entry
        } else {
            return null;    //returning null
        }
    }

    public V put(K key, V value) {
        Node searchNode = search(root, key);    //getting node via search
        V oldValue; //creating buffer for oldValue

        if (searchNode == null) {   //checking if node is not existing yet
            root = insertRecursive(root, key, value);   //inserting node
            size++;
            return null;
        } else {
            oldValue = searchNode.entry.getValue(); //getting oldValue
            searchNode.entry.setValue(value);   //overwriting oldValue
        }
        return oldValue;
    }
}
