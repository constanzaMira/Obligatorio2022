package uy.edu.um.prog2.tad.arraylist;

import uy.edu.um.prog2.tad.linkedlist.MyList;

import java.util.Arrays;

public class ArrayList<T> implements MyArrayList<T> {

    private int initialSize = 20;

    private final static int FACTOR_CRECIMIENTO = 2;

    private ArrayListNode<T>[] content;

    private int size;

    public ArrayList() {
        this.content = new ArrayListNode[initialSize];
        this.size = 0;
    }

    public ArrayList(int initialSize) {
        this.content = new ArrayListNode[initialSize];
        this.size = 0;
    }

    public ArrayListNode<T>[] getContent() {
        return content;
    }

    public void setContent(ArrayListNode<T>[] content) {
        this.content = content;
    }

    private void makeLarger() {
        ArrayListNode<T>[] nuevoArray = Arrays.copyOf(this.content, this.size*FACTOR_CRECIMIENTO);
        this.content = nuevoArray;
    }

    @Override
    public void add(T value) {
        if (this.size == this.content.length) {
            this.makeLarger();
        }

        ArrayListNode<T> nodeToAdd = new ArrayListNode<>(value);

        this.content[this.size] = nodeToAdd;
        this.size++;

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int position) {
        return this.content[position].getValue();
    }

    @Override
    public void set(int position, T value) throws IndexOutOfBounds {
        if (position > this.size - 1) {
            throw new IndexOutOfBounds();
        }

        ArrayListNode<T> nodeToAdd = new ArrayListNode<>(value);

        this.content[position] = nodeToAdd;

    }


    @Override
    public void remove(int position) throws IndexOutOfBounds {
        if (position == this.size - 1) {
            this.set(this.size - 1, null);
            this.size--;
        } else {
            this.content[position] = this.content[this.size - 1];
            this.set(this.size - 1, null);
            this.size--;
        }
    }

    @Override
    public void removeObj(T value) throws IndexOutOfBounds {
        int index = this.getIndex(value);
        if (index > -1 && index < this.size) {
            this.remove(this.getIndex(value));
        }
    }

    @Override
    public boolean contains(T value) {
        boolean found = false;

        for (int i = 0; i < this.size; i++) {
            if (this.get(i).equals(value)) {
                found = true;
                break;
            }
        }
        return found;
    }

    @Override
    public int getIndex(T value) {
        int index = -1;

        for (int i = 0; i < this.size; i++) {
            if (this.get(i).equals(value)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
