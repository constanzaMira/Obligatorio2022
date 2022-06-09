package uy.edu.um.prog2.tad.linkedlist;

public interface MyList<T> {

    void add(T value);

    void remove(int position);

    T get(int position);

    boolean contains(T value);

    void removeObj(T value);

    int size();

    void set(int position, T value);

    void intercambiar(T value, int direccion);

    MyList<T> append(MyList<T> lista);

    Node<T> getFirst();

    Node<T> getLast();


}
