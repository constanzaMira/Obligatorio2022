package uy.edu.um.prog2.tad.hash;


import uy.edu.um.prog2.tad.arraylist.IndexOutOfBounds;

public interface HashTable<K,V>{

    public void put(K key, V value)throws IllegalAccessException;

    public boolean contains(K key);

    public void remove(K key) throws NoExiste, IndexOutOfBounds;

    public V get(K key) throws IllegalAccessException;

    int size();

    void set(K key, V value) throws NoExiste, IllegalAccessException, IndexOutOfBounds;

    V getByIndex(int index) throws IllegalAccessException;


}
