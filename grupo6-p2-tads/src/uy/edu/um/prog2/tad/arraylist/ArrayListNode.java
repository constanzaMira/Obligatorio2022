package uy.edu.um.prog2.tad.arraylist;

public class ArrayListNode<T> {

    private T value;

    public ArrayListNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
