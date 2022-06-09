package uy.edu.um.prog2.tad.queue;

public interface MyDoubleQueue<T> {

    void enqueueLeft(T element);

    T dequeueLeft() throws EmptyQueueException;

    void enqueueRight(T element);

    T dequeueRight() throws EmptyQueueException;

    boolean isEmpty();

    T peekLeft() throws EmptyQueueException;

    T peekRight() throws EmptyQueueException;

    int size();

    boolean contains(T value);
}
