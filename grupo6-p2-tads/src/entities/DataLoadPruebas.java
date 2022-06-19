package entities;

import uy.edu.um.prog2.tad.arraylist.ArrayList;
import uy.edu.um.prog2.tad.arraylist.MyArrayList;
import uy.edu.um.prog2.tad.hash.HashTable;
import uy.edu.um.prog2.tad.hash.MyHashTableImp;
import uy.edu.um.prog2.tad.linkedlist.LinkedList;
import uy.edu.um.prog2.tad.linkedlist.MyList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class DataLoadPruebas {
    public static void main(String[] args) throws IOException {

        HashTable<Long, Beer> beers = new MyHashTableImp<>(200000);
        HashTable<Long, Brewery> breweries = new MyHashTableImp<>(300000);

        //Esto es para probar el monitoreo de memoria

        Scanner leer0 = new Scanner(System.in);
        int numero0 = leer0.nextInt();

        Consultas consultas = new Consultas();

        numero0 = leer0.nextInt();


        System.out.println();


        /*String file = "grupo6-p2-tads\\src\\entities\\beer_dataset_test.csv";
        BufferedReader reader = null;
        String line = "";
        boolean comenzar = false;
        int i = 0;

        MyList<Integer> numeros = new LinkedList<>();


        Date fecha = new Date(1295153379l*1000);

        System.out.println(Double.valueOf("4,5"));

        try {
            reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null && i < 4) {
                if (comenzar) {
                    String[] fila = line.split(",");

                    for (int columna = 0; columna < fila.length; columna++) {
                        System.out.println(fila[columna]);
                    }
                    System.out.println();
                    i++;
                }
                comenzar = true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }
}
