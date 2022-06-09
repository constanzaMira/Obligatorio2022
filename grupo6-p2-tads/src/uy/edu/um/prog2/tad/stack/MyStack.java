package uy.edu.um.prog2.tad.stack;


public interface MyStack<T> {

    T pop() throws EmptyStackException;

    T top() throws EmptyStackException;

    void push(T element);

    boolean isEmpty ();

    void makeEmpty();

    int size();

    boolean contains(T value);

}
