package uy.edu.um.prog2.tad.linkedlist;
import uy.edu.um.prog2.tad.queue.MyDoubleQueue;
import uy.edu.um.prog2.tad.queue.MyPriorityQueue;
import uy.edu.um.prog2.tad.stack.MyStack;
import uy.edu.um.prog2.tad.stack.EmptyStackException;
import uy.edu.um.prog2.tad.queue.MyQueue;
import uy.edu.um.prog2.tad.queue.EmptyQueueException;


public class LinkedList<T> implements MyList<T>, MyStack<T>, MyQueue<T>, MyDoubleQueue<T>, MyPriorityQueue<T> {

    private Node<T> first;

    private Node<T> last;

    private int size;

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;

    }

    public Node<T> getFirst() {
        return first;
    }

    public Node<T> getLast() {
        return last;
    }

    //Métodos de LinkedList
    @Override
    public void add(T value) {
        this.addLast(value);

    }

    @Override
    public void remove(int position) {
        T valorAEliminar = this.get(position);

        removeObj(valorAEliminar);

    }

    @Override
    public void removeObj(T value) {
        Node<T> valorPrevio = null;
        Node<T> valorBuscado = this.first;

        while (valorBuscado != null && !valorBuscado.getValue().equals(value)) {

            valorPrevio = valorBuscado;
            valorBuscado = valorBuscado.getSiguiente();
        }

        if (valorBuscado != null) {
            if (valorBuscado == this.first && valorBuscado != this.last) {

                Node<T> temp = this.first;
                this.first = this.first.getSiguiente();
                temp.setSiguiente(null);

            } else if (valorBuscado != this.first && valorBuscado == this.last) {

                valorPrevio.setSiguiente(null);
                this.last = valorPrevio;

            } else if (valorBuscado == this.first && valorBuscado == this.last) {

                this.first = null;
                this.last = null;

            } else {

                valorPrevio.setSiguiente(valorBuscado.getSiguiente());
                valorBuscado.setSiguiente(null);
            }
            this.size = this.size - 1;
        }
        else {

        }
    }

    @Override
    public T get(int position) {
        Node<T> valorBuscado = null;

        if (position < this.size) {
            valorBuscado = this.first;
            for(int i = 0; i < position; i++){
                valorBuscado = valorBuscado.getSiguiente();
            }
        }

        return valorBuscado.getValue();

    }

    @Override
    public boolean contains(T value) {
        boolean seEncontro = false;
        Node<T> valorBuscado = this.first;

        while (!seEncontro && valorBuscado != null) {
            if (valorBuscado.getValue().equals(value)) {
                seEncontro = true;
            }
            valorBuscado = valorBuscado.getSiguiente();
        }

        return seEncontro;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void set(int position, T value) {
        Node<T> valorBuscado = this.first;
        Node<T> valorPrevio = null;
        Node<T> nuevoNodo = new Node<>(value);

        if (value != null && position < this.size) {
            if (this.size == 1) {

                this.first = nuevoNodo;
                this.last = nuevoNodo;
            }
            else if (position == 0) {
                nuevoNodo.setSiguiente(this.first.getSiguiente());
                this.first.setSiguiente(null);
                this.first = nuevoNodo;
            }
            else {
                for(int i = 0; i < position; i++){
                    valorPrevio = valorBuscado;
                    valorBuscado = valorBuscado.getSiguiente();
                }

                nuevoNodo.setSiguiente(valorBuscado.getSiguiente());
                valorBuscado.setSiguiente(null);
                valorPrevio.setSiguiente(nuevoNodo);

            }
        }

    }

    @Override
    public void intercambiar(T value, int direccion) {
        if (value != null && (direccion == 1 || direccion == -1)) {
            Node<T> valorPrevio = this.first;
            Node<T> valorBuscado = this.first;
            Node<T> valorPrevio2 = null;

            if ((this.first.getValue().equals(value) && direccion == -1) || (this.last.getValue().equals(value) && direccion == 1)) {
                Node<T> first = this.first;

                for (int i = 0; i < this.size-1; i++) {
                    valorPrevio = valorBuscado;
                    valorBuscado = valorBuscado.getSiguiente();
                }
                valorBuscado.setSiguiente(first.getSiguiente());
                first.setSiguiente(null);
                valorPrevio.setSiguiente(first);
                this.first = valorBuscado;
                this.last = first;

            } else if (direccion == -1) {
                if (this.first.getSiguiente().getValue().equals(value)) {
                    valorBuscado = this.first.getSiguiente();
                    this.first.setSiguiente(valorBuscado.getSiguiente());
                    valorBuscado.setSiguiente(this.first);
                    this.first = valorBuscado;
                } else {
                    while (!valorBuscado.getValue().equals(value)) {
                        valorPrevio2 = valorPrevio;
                        valorPrevio = valorPrevio2.getSiguiente();
                        valorBuscado = valorPrevio.getSiguiente();
                    }
                    if (valorBuscado == this.last) {
                        this.last = valorPrevio;
                    }
                    valorPrevio.setSiguiente(valorBuscado.getSiguiente());
                    valorBuscado.setSiguiente(valorPrevio);
                    valorPrevio2.setSiguiente(valorBuscado);


                }
            } else if (direccion == 1) {
                if (this.first.getValue().equals(value)) {
                    valorBuscado = this.first;
                    Node<T> post = this.first.getSiguiente();
                    valorBuscado.setSiguiente(post.getSiguiente());
                    post.setSiguiente(valorBuscado);
                    this.first = post;

                }
                else {
                    while (!valorBuscado.getValue().equals(value)) {
                        valorPrevio = valorBuscado;
                        valorBuscado = valorBuscado.getSiguiente();
                    }
                    if (valorBuscado.getValue().equals(this.get(this.size - 2))) {
                        this.last = valorBuscado;
                    }
                    Node<T> post = valorBuscado.getSiguiente();
                    valorBuscado.setSiguiente(post.getSiguiente());
                    post.setSiguiente(valorBuscado);
                    valorPrevio.setSiguiente(post);
                }

            }
        }

    }

    @Override
    public MyList<T> append(MyList<T> lista) {
        MyList<T> nuevaLista = new LinkedList<>();
        for (int i = 0; i < this.size; i++) {
            nuevaLista.add(this.get(i));
        }
        for (int i = 0; i < lista.size(); i++) {
            nuevaLista.add(lista.get(i));
        }
        return nuevaLista;

    }

    @Override
    public int getIndex(T value) {
        int index = -1;

        if (this.contains(value)) {
            for (int i = 0; i < this.size; i++) {
                if (this.get(i).equals(value)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    private void addFirst(T value) {
        if (value != null) {

            Node<T> elementoAAgregar = new Node<>(value);

            if (this.first == null) {
                this.first = elementoAAgregar;
                this.last = elementoAAgregar;
            }

            else {
                elementoAAgregar.setSiguiente(this.first);
                this.first = elementoAAgregar;
            }
            this.size = this.size + 1;
        }
        else {
        }
    }


    private void addLast(T value) {
        if (value != null) {

            Node<T> elementoAAgregar = new Node<>(value);

            if (this.first == null) {
                this.first = elementoAAgregar;
                this.last = elementoAAgregar;
            }
            else {
                this.last.setSiguiente(elementoAAgregar);
                this.last = elementoAAgregar;
            }
            this.size = this.size + 1;
        }
        else {
        }
    }

    //Métodos de Stack

    @Override
    public T pop() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        Node<T> valorBuscado = this.first;

        if (this.size > 1) {
            this.first = valorBuscado.getSiguiente();
        }
        else {
            this.first = null;
            this.last = null;
        }

        valorBuscado.setSiguiente(null);
        this.size = this.size - 1;

        return valorBuscado.getValue();

    }

    @Override
    public T top() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.first.getValue();
    }

    @Override
    public void push(T element) {
        this.addFirst(element);
    }

    @Override
    public void makeEmpty() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    //Métodos de Queue

    @Override
    public void enqueue(T element) {
        this.addLast(element);
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }

        Node<T> valorBuscado = this.first;

        if (this.size > 1) {
            this.first = valorBuscado.getSiguiente();
        }
        else {
            this.first = null;
            this.last = null;
        }

        valorBuscado.setSiguiente(null);
        this.size = this.size - 1;

        return valorBuscado.getValue();
    }

    @Override
    public T peek() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        return this.first.getValue();
    }

    @Override
    public void enqueueLeft(T element) {
        this.addFirst(element);
    }

    @Override
    public T dequeueLeft() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }

        Node<T> valorBuscado = this.first;

        if (this.size > 1) {
            this.first = valorBuscado.getSiguiente();
        }
        else {
            this.first = null;
            this.last = null;
        }

        valorBuscado.setSiguiente(null);
        this.size = this.size - 1;

        return valorBuscado.getValue();
    }

    @Override
    public void enqueueRight(T element) {
        this.addLast(element);
    }

    @Override
    public T dequeueRight() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }

        Node<T> valorPrevio = null;
        Node<T> valorBuscado = this.first;

        while (valorBuscado != this.last) {
            valorPrevio = valorBuscado;
            valorBuscado = valorBuscado.getSiguiente();
        }

        if (this.size > 1) {
            valorPrevio.setSiguiente(null);
            this.last = valorPrevio;
        }
        else {
            this.first = null;
            this.last = null;
        }
        this.size = this.size - 1;

        return valorBuscado.getValue();
    }

    @Override
    public T peekLeft() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        return this.first.getValue();
    }

    @Override
    public T peekRight() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        return this.last.getValue();
    }

    @Override
    public void enqueueWithPriority(T element, int prioridad) {
        if (element != null) {
            Node<T> nuevoNodo = new Node<>(element, prioridad);
            if (this.isEmpty()) {
                this.first = nuevoNodo;
                this.last = nuevoNodo;
            } else if (this.size == 1) {
                if (prioridad > this.getFirst().getPrioridad()) {
                    nuevoNodo.setSiguiente(this.first);
                    this.first = nuevoNodo;
                } else {
                    this.first.setSiguiente(nuevoNodo);
                    this.last = nuevoNodo;
                }
            } else {
                Node<T> valorPrevio = this.first;
                Node<T> valorSiguiente = valorPrevio.getSiguiente();

                if (prioridad > this.first.getPrioridad()) {
                    this.addFirst(element);
                    this.first.setPrioridad(prioridad);
                } else if (prioridad <= this.last.getPrioridad()) {
                    this.addLast(element);
                    this.last.setPrioridad(prioridad);
                } else {
                    while (!(valorPrevio.getPrioridad() >= prioridad && valorSiguiente.getPrioridad() < prioridad)) {
                        valorPrevio = valorSiguiente;
                        valorSiguiente = valorSiguiente.getSiguiente();
                    }
                    nuevoNodo.setSiguiente(valorSiguiente);
                    valorPrevio.setSiguiente(nuevoNodo);
                }
            }
            this.size = this.size + 1;
        }
    }
}
