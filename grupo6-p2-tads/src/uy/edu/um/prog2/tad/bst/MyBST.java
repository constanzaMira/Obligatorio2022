package uy.edu.um.prog2.tad.bst;

public interface MyBST <K extends Comparable <K>,T>{

    T find(K key) throws ArbolVacio, NoExisteKey;
    void insertar(K key, T data);
    void borrar(K key) throws NoExisteKey;

    int size();

    //MyList<K> inOrder();

}
