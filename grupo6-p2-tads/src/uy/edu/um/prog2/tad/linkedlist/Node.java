package uy.edu.um.prog2.tad.linkedlist;

public class Node<T> {

    private T value;

    private Node<T> siguiente;

    private int prioridad;

    public Node(T value) {
        this.value = value;
        this.siguiente = null;
        this.prioridad = 0;
    }

    public Node(T value, int prioridad) {
        this.value = value;
        this.siguiente = null;
        this.prioridad = prioridad;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Node<T> siguiente) {
        this.siguiente = siguiente;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
}
