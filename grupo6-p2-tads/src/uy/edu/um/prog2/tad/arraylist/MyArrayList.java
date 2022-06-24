package uy.edu.um.prog2.tad.arraylist;

public interface MyArrayList<T> {

    void add(T value);

    int size();

    T get(int position);

    void set(int position, T value) throws IndexOutOfBounds;

    void remove(int position) throws IndexOutOfBounds;

    void removeObj(T value) throws IndexOutOfBounds;

    boolean contains(T value);

    int getIndex(T value);




}
