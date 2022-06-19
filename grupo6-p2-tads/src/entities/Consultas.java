package entities;

import exceptions.Fechainvalida;
import uy.edu.um.prog2.tad.hash.HashTable;
import uy.edu.um.prog2.tad.hash.MyHashTableImp;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Consultas {

    private HashTable<Long, Brewery> breweries = new MyHashTableImp<>(300000);

    private HashTable<Long, Beer> beers = new MyHashTableImp<>(200000);


    public Consultas() throws IOException {
        DataLoad.DataLoad(breweries, beers);
    }

    public HashTable<Long, Beer> getBeers() {
        return beers;
    }

    public HashTable<Long, Brewery> getBreweries() {
        return breweries;
    }

    public void diezCasasDeCervezaConMasResenias() throws Fechainvalida {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Ingrese una año");

        String fecha = scanner.next();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy");
        Date fecha1= null;

        try {
            fecha1 = dateFormat.parse(fecha);
        } catch (ParseException e) {
            throw new Fechainvalida();
        }

    }


    public void top15CatadoresConMasResenias(){

    }


    public void cantidadDeReviewsEnRango(){
        int contador= 0;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Ingrese fecha de comienzo");

        Scanner scanner1= new Scanner(System.in);
        System.out.println("Ingrese fecha de fin");

        String fecha= scanner.next();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy");
        Date fechai= null;

        String fecha0= scanner1.next();
        SimpleDateFormat dateFormat1= new SimpleDateFormat("yyyy");
        Date fechaf= null;

        try {
            fechai=dateFormat.parse(fecha);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        try {
            fechaf=dateFormat.parse(fecha);
        } catch (ParseException e) {

        }


        /*for (int i=0; i<DataLoad.getBeers().size();i++){
            if (DataLoad.getBeers().get(i).getReviewsId().get(i).getDate())

        }*/


    }

    public void top7EstilosDeCervezaConMejorAroma(){

    }

    public void top5CervezasConMasReviews(){

    }




}

