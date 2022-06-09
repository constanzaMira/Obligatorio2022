package uy.edu.um.prog2.tad.queue;

public interface MyQueue<T> {

    void enqueue(T element);

    T dequeue() throws EmptyQueueException;

    boolean isEmpty();

    T peek() throws EmptyQueueException;

    int size();

    boolean contains(T value);
}
