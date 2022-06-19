package uy.edu.um.prog2.tad.hash;


import uy.edu.um.prog2.tad.arraylist.ArrayList;
import uy.edu.um.prog2.tad.arraylist.IndexOutOfBounds;
import uy.edu.um.prog2.tad.arraylist.MyArrayList;
import uy.edu.um.prog2.tad.linkedlist.MyList;

import java.security.Key;
import java.util.Enumeration;

public class MyHashTableImp<K,V> implements HashTable<K,V> {

    private final static int SIZE_INICIAL=10000;// declaracion de cte
    private final static int FACTOR_CRECIMIENTO=2;
    int cant_elementos=0;

    private HashNode<K,V>[] elements;

    private MyList<V>[] values;

    private MyArrayList<K> keys;

    public MyList<V>[] getValues() {
        return values;
    }

    public void setValues(MyList<V>[] values) {
        this.values = values;
    }

    public int getCant_elementos() {
        return cant_elementos;
    }

    public void setCant_elementos(int cant_elementos) {
        this.cant_elementos = cant_elementos;
    }

    public HashNode<K, V>[] getElements() {
        return elements;
    }

    public void setElements(HashNode<K, V>[] elements) {
        this.elements = elements;
    }

    public MyArrayList<K> getKeys() {
        return keys;
    }

    public void setKeys(MyArrayList<K> keys) {
        this.keys = keys;
    }

    public MyHashTableImp(){
        elements = new HashNode[SIZE_INICIAL];
        keys = new ArrayList<>(SIZE_INICIAL);
    }

    public MyHashTableImp(int initialSize) {
        elements = new HashNode[initialSize];
        keys = new ArrayList<>(initialSize);
    }

    private int colison(int prueba){
        return prueba;
    }

    public  HashNode<K,V> [] redimensionarArreglo (HashNode <K,V>[] arreglo){
        HashNode<K, V>[] elementsDup;
        elementsDup=new HashNode[elements.length*FACTOR_CRECIMIENTO];
        System.arraycopy(arreglo,0,elementsDup,0,arreglo.length);
        return elementsDup;
    }


    @Override
    public void put(K key, V value) throws IllegalAccessException{
        if(key==null || value==null){
            throw new IllegalAccessException();
        }
            //aplicar funcion de hash a la key para determinar posicion
        int position= Math.abs(key.hashCode())% elements.length;   //lo que me devuelve el hash code aplico el modulo del tamano de tabla
                                                    //llama a la funcion hashcode del objeto que yo pase como primer argumento(k.hashcode)
        float division= (float)cant_elementos/elements.length;
        if(division>= 0.8f){
            elements=redimensionarArreglo(elements);
        }
        // verifico si la poscion esta libre para colocar elemento
        if (elements[position]==null || elements[position].isDelete() ||  elements[position].getKey().equals(key) ){
            HashNode<K,V> node=new HashNode<>(key, value);
            elements[position]= node;
            cant_elementos++;
        }else{
            int nroColision=1;
            int nuevaPosicion= 0;

            do {
                nuevaPosicion= (key.hashCode() + colison(nroColision)) % elements.length;
                nroColision ++;

            } while(this.elements[nuevaPosicion]!= null && !elements[nuevaPosicion].isDelete()
                    && nuevaPosicion < elements.length);
            if (nroColision< elements.length) {
                HashNode<K, V> node = new HashNode<>(key, value);
                elements[nuevaPosicion] = node; //antes de chekear esto fijarse que factor de carga este por debajo de el freshcod que voy a definir, aumentar tamanio y dsp operar
                cant_elementos++;
            }
            }
        this.keys.add(key);
        }


    public V get(K key) throws IllegalAccessException{
        int position= Math.abs(key.hashCode())% elements.length;
        V exit= null;
        if (key==null){
            throw new IllegalAccessException();
        }
        if(this.elements[position]!=null){//estoy accediendo a una posicion de una clave que tiene algo
            if(!this.elements[position].isDelete() && this.elements[position].getKey().equals(key)){//encontre valor
                exit= this.elements[position].getValue();
            }else {//elemento borrado pudo haber habido una colision
                int nroColision=1;
                int nuevaPosicion= 0;

                do {
                    nuevaPosicion= (key.hashCode() + colison(nroColision)) % elements.length;
                    nroColision ++;

                } while(elements[nuevaPosicion]!= null && this.elements[position].getKey().equals(key)
                        && nroColision < elements.length);
                if(nroColision< elements.length){
                    if(elements[nuevaPosicion]!= null && this.elements[nuevaPosicion].isDelete() ){
                        exit= this.elements[nuevaPosicion].getValue();
                    }
                }
            }

        }


        return exit;
    }

    @Override
    public boolean contains(K key) {
        boolean exit = false;
        try {
            if(get(key)!=null){
                exit = true;
            }else{
                exit = false;
            }
        } catch (IllegalAccessException e) {

        }
        return exit;
    }

    @Override
    public void remove(K key) throws NoExiste, IndexOutOfBounds {
        int position= Math.abs(key.hashCode())% elements.length;
        //V exit= null;
        if(this.elements[position]!=null){//estoy accediendo a una posicion de una clave que tiene algo
            if(!this.elements[position].isDelete() && this.elements[position].getKey().equals(key)){//encontre valor
                this.elements[position].setDelete(true);
            }else {//elemento borrado pudo haber habido una colision
                int nroColision=1;
                int nuevaPosicion= 0;

                do {
                    nuevaPosicion= (key.hashCode() + colison(nroColision)) % elements.length;
                    nroColision ++;

                } while(elements[nuevaPosicion]!= null && this.elements[position].getKey().equals(key)
                        && nroColision < elements.length);

                if(nroColision< elements.length){
                    if(elements[nuevaPosicion]!= null && this.elements[nuevaPosicion].isDelete() ){
                        throw new NoExiste();
                    }
                }
            }

        }
        cant_elementos--;
        this.keys.removeObj(key);
    }

    @Override
    public int size() {
        return cant_elementos;
    }

    @Override
    public void set(K key, V value) throws NoExiste, IllegalAccessException, IndexOutOfBounds {
        if (this.get(key).equals(value)) {
            int position= Math.abs(key.hashCode())% elements.length;
            //V exit= null;
            if(this.elements[position]!=null){//estoy accediendo a una posicion de una clave que tiene algo
                if(!this.elements[position].isDelete() && this.elements[position].getKey().equals(key)){//encontre valor
                    this.elements[position].setDelete(true);
                }else {//elemento borrado pudo haber habido una colision
                    int nroColision=1;
                    int nuevaPosicion= 0;

                    do {
                        nuevaPosicion= (key.hashCode() + colison(nroColision)) % elements.length;
                        nroColision ++;

                    } while(elements[nuevaPosicion]!= null && this.elements[position].getKey().equals(key)
                            && nroColision < elements.length);

                    if(nroColision< elements.length){
                        if(elements[nuevaPosicion]!= null && this.elements[nuevaPosicion].isDelete() ){
                            throw new NoExiste();
                        }
                    }
                }

            }
            cant_elementos--;

            if(key==null || value==null){
                throw new IllegalAccessException();
            }
            //aplicar funcion de hash a la key para determinar posicion
            position= Math.abs(key.hashCode())% elements.length;   //lo que me devuelve el hash code aplico el modulo del tamano de tabla
            //llama a la funcion hashcode del objeto que yo pase como primer argumento(k.hashcode)
            float division= (float)cant_elementos/elements.length;
            if(division>= 0.8f){
                elements=redimensionarArreglo(elements);
            }
            // verifico si la poscion esta libre para colocar elemento
            if (elements[position]==null || elements[position].isDelete() ||  elements[position].getKey().equals(key) ){
                HashNode<K,V> node=new HashNode<>(key, value);
                elements[position]= node;
                cant_elementos++;
            }else{
                int nroColision=1;
                int nuevaPosicion= 0;

                do {
                    nuevaPosicion= (key.hashCode() + colison(nroColision)) % elements.length;
                    nroColision ++;

                } while(this.elements[nuevaPosicion]!= null && !elements[nuevaPosicion].isDelete()
                        && nuevaPosicion < elements.length);
                if (nroColision< elements.length) {
                    HashNode<K, V> node = new HashNode<>(key, value);
                    elements[nuevaPosicion] = node; //antes de chekear esto fijarse que factor de carga este por debajo de el freshcod que voy a definir, aumentar tamanio y dsp operar
                    cant_elementos++;
                }
            }
        }

    }

    @Override
    public V getByIndex(int index) throws IllegalAccessException {
        return this.get(this.keys.get(index));
    }
}
