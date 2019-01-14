package de.hska.iwi.ads.solution.tree;

import de.hska.iwi.ads.dictionary.AbstractBinaryTree;

public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractBinaryTree<K, V> {

    private Node search(Node node, K key) {
        if (node == null || node.entry.getKey() == key) {
            return node;
        }

        if (node.entry.getKey().compareTo(key) > 0) {
            return search(node.left, key);
        }
        return search(node.right, key);
    }

    private Node insertRecursive(Node node, K key, V value) {
        if (node == null) {
            node = new Node(key, value);
            return node;
        }

        if (key.compareTo(node.entry.getKey()) < 0) {
            node.left = insertRecursive(node.left, key, value);
        } else if (key.compareTo(node.entry.getKey()) > 0) {
            node.right = insertRecursive(node.right, key, value);
        }
        return node;
    }

    public V get(Object key) {
        Node node = search(root, (K) key);
        if (node != null) {
            return node.entry.getValue();
        } else {
            return null;
        }
    }

    public V put(K key, V value) {
        Node searchNode = search(root, key);
        V oldValue;

        if (searchNode == null) {
            root = insertRecursive(root, key, value);
            size++;
            return null;
        } else {
            oldValue = searchNode.entry.getValue();
            searchNode.entry.setValue(value);
        }
        return oldValue;
    }
}
