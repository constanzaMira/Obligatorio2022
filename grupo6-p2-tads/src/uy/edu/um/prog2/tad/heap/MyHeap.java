package uy.edu.um.prog2.tad.heap;

import java.util.ArrayList;

public interface MyHeap<K extends Comparable<K>, T> {

    void insert(K key, T data);

    T find(K key);

    T remove(K key);

    void delete(K key);

    int size();

    void print();

    boolean contains(K key);

    ArrayList<HeapNode<K, T>> getContenido();

}
