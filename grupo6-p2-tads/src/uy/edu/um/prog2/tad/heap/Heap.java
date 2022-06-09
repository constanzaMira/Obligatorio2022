package uy.edu.um.prog2.tad.heap;

import java.util.ArrayList;

public class Heap<K extends Comparable<K>, T> implements MyHeap<K, T> {

    private ArrayList<HeapNode<K, T>> contenido;

    private int lastFreeLeaf;

    private int size;

    private String tipo;

    public Heap(int tipo) {
        this.contenido = new ArrayList<>();
        this.lastFreeLeaf = 0;
        this.size = 0;
        if (tipo == 1) {
            this.tipo = "Max";
        }
        else if (tipo == -1) {
            this.tipo = "Min";
        }
    }

    @Override
    public ArrayList<HeapNode<K, T>> getContenido() {
        return contenido;
    }

    @Override
    public void insert(K key, T data) {
        HeapNode<K, T> nodoAInsertar = new HeapNode<>(key, data);
        int hijo = this.lastFreeLeaf;
        int padre = (hijo - 1) / 2;

        this.contenido.add(nodoAInsertar);

        if (padre >= 0) {
            while ((this.contenido.get(hijo).getKey().compareTo(this.contenido.get(padre).getKey()) == 1 && this.tipo.equals("Max")) ||
                    (this.contenido.get(hijo).getKey().compareTo(this.contenido.get(padre).getKey()) == -1 && this.tipo.equals("Min")))  {

                HeapNode<K, T> tmp = this.contenido.get(padre);
                this.contenido.set(padre, this.contenido.get(hijo));
                this.contenido.set(hijo, tmp);

                hijo = padre;
                padre = (hijo - 1) / 2;
            }
        }
        this.size = this.size + 1;
        this.lastFreeLeaf = this.lastFreeLeaf + 1;
    }

    @Override
    public T find(K key) {
        T elementoAEncontrar = null;

        if (key != null && this.size > 0) {
            for (int i = 0; i < this.size; i++) {
                if (key.compareTo(this.contenido.get(i).getKey()) == 0) {
                    elementoAEncontrar = this.contenido.get(i).getData();
                    break;
                }
            }
        }
        return elementoAEncontrar;
    }

    @Override
    public T remove(K key) {
        T elementoARemover = this.find(key);

        if (elementoARemover != null) {
            this.delete(key);
        }
        return elementoARemover;
    }

    @Override
    public void delete(K key) {
        HeapNode<K, T> nodoAEliminar = null;
        int indNodoEliminar = 0;
        int indHijoL = 0;
        int indHijoR = 0;
        int hijoMayor = 0;
        int hijoMenor = 0;
        int padre = 0;
        int hijo = 0;

        if (this.contains(key)) {
            for (int i = 0; i < this.size; i++) {
                if (key.compareTo(this.contenido.get(i).getKey()) == 0) {
                    nodoAEliminar = this.contenido.get(i);
                    indNodoEliminar = i;
                    break;
                }
            }
            this.contenido.set(indNodoEliminar, this.contenido.get(this.size-1));
            this.contenido.remove(this.size-1);
            this.size = this.size - 1;
            this.lastFreeLeaf = this.lastFreeLeaf - 1;
            hijo = indNodoEliminar;
            indHijoL = 2*hijo + 1;
            indHijoR = 2*hijo + 2;
            padre = (hijo - 1) / 2;
            boolean termino = false;

            if (hijo != this.size) {

                while ((this.contenido.get(hijo).getKey().compareTo(this.contenido.get(padre).getKey()) == 1 && this.tipo.equals("Max")) ||
                        (this.contenido.get(hijo).getKey().compareTo(this.contenido.get(padre).getKey()) == -1 && this.tipo.equals("Min"))) {

                    HeapNode<K, T> tmp = this.contenido.get(padre);
                    this.contenido.set(padre, this.contenido.get(hijo));
                    this.contenido.set(hijo, tmp);

                    hijo = padre;
                    padre = (hijo - 1) / 2;

                }
            }

            while (indHijoL < this.size && !termino) {
                if (indHijoR < this.size) {

                    if (this.contenido.get(indHijoL).getKey().compareTo(this.contenido.get(indHijoR).getKey()) == 1) {
                        hijoMayor = indHijoL;
                        hijoMenor = indHijoR;
                    } else if (this.contenido.get(indHijoL).getKey().compareTo(this.contenido.get(indHijoR).getKey()) == -1) {
                        hijoMayor = indHijoR;
                        hijoMenor = indHijoL;
                    }
                    }
                else {
                    hijoMayor = indHijoL;
                    hijoMenor = indHijoL;
                }

                if ((this.contenido.get(hijo).getKey().compareTo(this.contenido.get(hijoMayor).getKey())) == -1 && this.tipo.equals("Max")) {
                    HeapNode<K, T> tmp = this.contenido.get(hijoMayor);
                    this.contenido.set(hijoMayor, this.contenido.get(hijo));
                    this.contenido.set(hijo, tmp);
                    hijo = hijoMayor;
                }
                else if ((this.contenido.get(hijo).getKey().compareTo(this.contenido.get(hijoMenor).getKey()) == 1 && this.tipo.equals("Min"))) {
                    HeapNode<K, T> tmp = this.contenido.get(hijoMenor);
                    this.contenido.set(hijoMenor, this.contenido.get(hijo));
                    this.contenido.set(hijo, tmp);
                    hijo = hijoMenor;
                }
                else {
                    termino = true;
                }
                indHijoL = 2*hijo + 1;
                indHijoR = 2*hijo + 2;

            }

                }
            }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void print() {
        for (int i = 0; i < this.size; i++) {
            if (i == 0) {
                System.out.print("[" + this.contenido.get(i).getData() + ",");
            }
            else if (i == this.size - 1) {
                System.out.print(this.contenido.get(i).getData() + "]");
            }
            else {
                System.out.print(this.contenido.get(i).getData() + ",");
            }

        }

    }

    @Override
    public boolean contains(K key) {
        return (this.find(key) != null);
    }
}
