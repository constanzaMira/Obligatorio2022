package entities;

import exceptions.Fechainvalida;
import uy.edu.um.prog2.tad.hash.HashTable;
import uy.edu.um.prog2.tad.hash.MyHashTableImp;
import uy.edu.um.prog2.tad.heap.Heap;
import uy.edu.um.prog2.tad.linkedlist.LinkedList;
import uy.edu.um.prog2.tad.linkedlist.MyList;
import uy.edu.um.prog2.tad.mergesort.MergeSortImp;

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

    public void diezCasasDeCervezaConMasResenias() throws Fechainvalida, IllegalAccessException {
        Heap<Long,Brewery> top10 = new Heap<>(1);
        Scanner scanner= new Scanner(System.in);
        System.out.println("Ingrese una año en formato yyyy");

        String fecha = scanner.next();

        for(int i=0; i<beers.size();i++){
            if (beers.getByIndex(i)!=null){
                for (int m=0; m< getBeers().getByIndex(i).getReviewsId().size();m++){
                        SimpleDateFormat dateString=new SimpleDateFormat("yyyy");
                        String dateString1= dateString.format(beers.getByIndex(i).getReviewsId().get(m).getDate());
                        if(dateString1.equals(fecha)){
                            if (getBreweries()!=null){
                                int tamanio=beers.getByIndex(i).getReviewsId().get(m).getBrewery().setCantReviews(beers.getByIndex(i).getReviewsId().get(m).getBrewery().getCantReviews()+1);
                                top10.insert((long) tamanio,getBeers().getByIndex(i).getReviewsId().get(m).getBrewery());
                            }
                        }
                    }
                }
            }

        for (int j=0; j<10;j++){
            System.out.println("Id: "+ top10.getContenido().get(0).getData().getId() +
                    "    Nombre: "+ top10.getContenido().get(0).getData().getName() +    "    Cantidad de resenias: "
                    + top10.getContenido().get(0).getKey());

            top10.delete(top10.getContenido().get(0).getKey());
        }
    }




    public void top15CatadoresConMasResenias(){


    }


    public void cantidadDeReviewsEnRango() throws IllegalAccessException {
        long tiempoInicio;
        long tiempoFinal;

        int contador= 0;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Ingrese fecha de comienzo dd/mm/yyyy ");

        String fecha= scanner.next();
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        Date fechai=null;

        Scanner scanner1= new Scanner(System.in);
        System.out.println("Ingrese fecha de fin dd/mm/yyyy ");

        String fecha0= scanner1.next();
        SimpleDateFormat dateFormat1= new SimpleDateFormat("dd/MM/yyyy");
        Date fechaf= null;

        try {
            fechai=dateFormat.parse(fecha);

            fechaf=dateFormat1.parse(fecha0);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        tiempoInicio = System.currentTimeMillis();
        for (int i=0; i<beers.size();i++){
            if (beers.getByIndex(i)!=null){
                for(int j=0; j<beers.getByIndex(i).getReviewsId().size();j++)
                    if(beers.getByIndex(i).getReviewsId().get(j)!=null){
                        if (beers.getByIndex(i).getReviewsId().get(j).getDate().after(fechai) &&
                                beers.getByIndex(i).getReviewsId().get(j).getDate().before(fechaf)){
                            contador++;}
                        SimpleDateFormat dateString=new SimpleDateFormat("dd/MM/yyyy");
                        String dateString1= dateString.format(beers.getByIndex(i).getReviewsId().get(j).getDate());
                        if( fecha.equals(dateString1) || fecha0.equals(dateString1)){
                            contador++;
                        }// ver por que me da 14162 entre 01/01/2002 y 01/01/2005
                    }


            }
        }
        tiempoFinal = System.currentTimeMillis();
        System.out.println("Tiempo: " + (tiempoFinal-tiempoInicio) + " milisegundos");
        System.out.println("entre el anio: "+ fecha + " y el anio: " +  fecha0 +  " Cantidad total de reviews: " + contador);//agregar los anios entre los que estoy trabajando
    }

    public void top7EstilosDeCervezaConMejorAroma(){

    }

    public void top5CervezasConMasReviews() throws IllegalAccessException {
        Heap<Long,Beer> top5 = new Heap<>(1);
        for(int i=0; i<beers.size();i++){
            if (beers.getByIndex(i)!=null){
                int tamanio=getBeers().getByIndex(i).getReviewsId().size();
                top5.insert((long) tamanio,getBeers().getByIndex(i));
                for (int m=0; m< getBeers().getByIndex(i).getReviewsId().size();m++){
                    if(beers.getByIndex(i).getReviewsId().get(m)!=null){
                        getBeers().getByIndex(i).setPuntaje((int) (getBeers().getByIndex(i).getPuntaje() + getBeers().getByIndex(i).getReviewsId().get(m).getOverallScore()));
                    }
                }
            }
        }

        //recorro e imprimo top 5

        for (int j=0; j<5;j++){
            System.out.println("Nombre: "+ top5.getContenido().get(0).getData().getName() +
                    "    Cantidad reviews: "+ top5.getContenido().get(0).getKey() +    "    Puntaje general promedio: "
                    + top5.getContenido().get(0).getData().getPuntaje()/top5.getContenido().get(0).getData().getReviewsId().size()  );

            top5.delete(top5.getContenido().get(0).getKey()); // los promedios estan dando mal

        }
    }



}






