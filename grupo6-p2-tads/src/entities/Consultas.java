package entities;

import uy.edu.um.prog2.tad.arraylist.ArrayList;
import uy.edu.um.prog2.tad.arraylist.MyArrayList;
import uy.edu.um.prog2.tad.hash.HashTable;
import uy.edu.um.prog2.tad.hash.MyHashTableImp;
import uy.edu.um.prog2.tad.heap.Heap;
import uy.edu.um.prog2.tad.heap.MyHeap;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Consultas {

    private HashTable<Long, Brewery> breweries = new MyHashTableImp<>(300000);

    private HashTable<Long, Beer> beers = new MyHashTableImp<>(200000);

    private HashTable<String, User> users = new MyHashTableImp<>(100000);

    private HashTable<String, Style> styles = new MyHashTableImp<>(100000);


    public Consultas() throws IOException {
        DataLoad.DataLoad(breweries, beers, users, styles);
    }

    public HashTable<Long, Beer> getBeers() {
        return beers;
    }

    public HashTable<Long, Brewery> getBreweries() {
        return breweries;
    }

    public HashTable<String, User> getUsers() {
        return users;
    }

    public HashTable<String, Style> getStyles() {
        return styles;
    }


    public void diezCasasDeCervezaConMasResenias() throws  IllegalAccessException {
        long tiempoInicio = System.currentTimeMillis();
        long tiempoFinal;

        Heap<Long,Brewery> top10 = new Heap<>(1);
        Scanner scanner= new Scanner(System.in);
        System.out.println("Ingrese un anio en formato yyyy");

        String fecha = scanner.next();
        System.out.println();

        for(int i=0; i<beers.size();i++){
            if (beers.getByIndex(i)!=null ){
                for (int m=0; m< getBeers().getByIndex(i).getReviewsId().size();m++){
                        SimpleDateFormat dateString=new SimpleDateFormat("yyyy");
                        String dateString1= dateString.format(beers.getByIndex(i).getReviewsId().get(m).getDate());
                        if(dateString1.equals(fecha)){
                                Long brewId=beers.getByIndex(i).getReviewsId().get(m).getBreweryId();
                                breweries.get(brewId).setCantReviews(breweries.get(brewId).getCantReviews()+1);
                        }
                    }
                }
            }

        for(int i=0; i< breweries.size();i++){
            top10.insert((long) breweries.getByIndex(i).getCantReviews(),breweries.getByIndex(i));
        }

        for (int j=0; j<10;j++){
            System.out.println(String.valueOf(j+1).concat(")"));
            System.out.println("Id: "+ top10.getContenido().get(0).getData().getId() +
                    "   Nombre: "+ top10.getContenido().get(0).getData().getName() +    "   Cantidad de reviews: "
                    + top10.getContenido().get(0).getKey());
            System.out.println();

            top10.delete(top10.getContenido().get(0).getKey());
        }

        for(int i=0 ; i<breweries.size();i++){
            breweries.getByIndex(i).setCantReviews(0);
        }
        tiempoFinal = System.currentTimeMillis();
        System.out.println("Tiempo: ".concat(Long.toString((tiempoFinal-tiempoInicio)/1000).concat("s")));
    }




    public void top15CatadoresConMasResenias() throws IllegalAccessException {
        long tiempoInicio = System.currentTimeMillis();
        long tiempoFinal;

        MyHeap<Long, User> top15 = new Heap<>(1);
        int progress = 0;

        for (int i = 0; i < beers.size(); i++) {
            MyArrayList<Review> reviews = beers.getByIndex(i).getReviews();
            User tmp = null;

            for (int j = 0; j < reviews.size(); j++) {
                tmp = reviews.get(j).getUser();
                tmp.sumarResenia();
            }
        }

        for (int i = 0; i < users.size(); i++) {
            User tmp = users.getByIndex(i);
            top15.insert((long) tmp.getCantResenias(), tmp);
        }

        for (int i = 0; i < 15; i++){
            System.out.println(String.valueOf(i+1).concat(")"));
            System.out.println("   Nombre: "+ top15.getContenido().get(0).getData().getUserName() +    "   Cantidad de reviews: "
                    + top15.getContenido().get(0).getKey());
            System.out.println();

            top15.delete(top15.getContenido().get(0).getKey());
        }

        for (int i = 0; i < users.size(); i++) {
            User tmp = users.getByIndex(i);
            tmp.setCantResenias(0);
        }
        tiempoFinal = System.currentTimeMillis();
        System.out.println("Tiempo: ".concat(Long.toString((tiempoFinal-tiempoInicio)/1000).concat("s")));
    }


    public void cantidadDeReviewsEnRango() throws IllegalAccessException, ParseException, RuntimeException{
        long tiempoInicio = System.currentTimeMillis();
        long tiempoFinal;

        int contador= 0;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Ingrese fecha de comienzo dd/mm/yyyy ");

        String fecha= scanner.next();
        System.out.println();
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        Date fechai=null;

        Scanner scanner1= new Scanner(System.in);
        System.out.println();
        System.out.println("Ingrese fecha de fin dd/mm/yyyy ");

        String fecha0= scanner1.next();
        System.out.println();
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
                    if(beers.getByIndex(i).getReviewsId().get(j)!=null) {
                            SimpleDateFormat dateString = new SimpleDateFormat("dd/MM/yyyy");
                            String fechar = dateString.format(beers.getByIndex(i).getReviewsId().get(j).getDate());
                            if (beers.getByIndex(i).getReviewsId().get(j).getDate().after(fechai) &&
                                    beers.getByIndex(i).getReviewsId().get(j).getDate().before(fechaf)) {
                                contador++;
                            }
                            if (fechar.equals(fecha0)) {
                                contador++;}
                    }
            }
        }
        tiempoFinal = System.currentTimeMillis();
        System.out.println("Tiempo: ".concat(Long.toString((tiempoFinal-tiempoInicio)/1000).concat("s")));
        System.out.println("Entre la fecha: "+ fecha + " y la fecha: " +  fecha0 +  " Cantidad total de reviews: " + contador);
    }

    public void top7EstilosDeCervezaConMejorAroma() throws IllegalAccessException {
        long tiempoInicio = System.currentTimeMillis();
        long tiempoFinal;

        MyHeap<Double, Style> top7 = new Heap<>(1);

        for (int i= 0; i < beers.size(); i++) {
            Beer act = beers.getByIndex(i);
            MyArrayList<Review> reviews = act.getReviews();
            Style tmp = act.getStyle();

            for (int j = 0; j < reviews.size(); j++) {
                tmp.getAromaScores().add(reviews.get(j).getAromaScore());
            }
        }

        for (int i = 0; i < styles.size(); i++) {
            Style tmp = styles.getByIndex(i);
            MyArrayList<Double> aromaScores = tmp.getAromaScores();
            double avgAromaScore = 0;

            for (int j = 0; j < aromaScores.size(); j++) {
                avgAromaScore += aromaScores.get(j);
            }
            avgAromaScore /= aromaScores.size();

            top7.insert(avgAromaScore, tmp);
        }

        for (int j = 0; j < 7; j++){
            System.out.println(String.valueOf(j+1).concat(")"));
            System.out.println("   Nombre: "+ top7.getContenido().get(0).getData().getName() +    "   Puntuacion: "
                    + top7.getContenido().get(0).getKey());
            System.out.println();

            top7.delete(top7.getContenido().get(0).getKey());
        }

        for (int i = 0; i < styles.size(); i++) {
            Style tmp = styles.getByIndex(i);
            tmp.setAromaScores(new ArrayList<>(1000));
        }
        tiempoFinal = System.currentTimeMillis();
        System.out.println("Tiempo: ".concat(Long.toString((tiempoFinal-tiempoInicio)/1000).concat("s")));
    }

    public void top5CervezasConMasReviews() throws IllegalAccessException {
        long tiempoInicio= System.currentTimeMillis();
        long tiempoFinal;

        Heap<Long,Beer> top5 = new Heap<>(1);
        for(int i=0; i<beers.size();i++){
            if (beers.getByIndex(i)!=null){

                int tamanio=getBeers().getByIndex(i).getReviewsId().size();
                top5.insert((long) tamanio,getBeers().getByIndex(i));

                for (int m=0; m< tamanio;m++){
                    if(beers.getByIndex(i).getReviewsId().get(m)!=null){
                        double puntaje= beers.getByIndex(i).getReviewsId().get(m).getOverallScore();
                        beers.getByIndex(i).agregarPuntaje( puntaje);

                    }
                }
            }
        }

        for (int j=0; j<5;j++){
            double prom= top5.getContenido().get(0).getData().getPuntaje()/ top5.getContenido().get(0).getKey();
            String prom1= String.valueOf(prom);
            String first4char = prom1.substring(0,6);

            System.out.println(String.valueOf(j+1).concat(")"));
            System.out.println("Nombre: "+ top5.getContenido().get(0).getData().getName() +
                    "    Cantidad reviews: "+ top5.getContenido().get(0).getKey() +    "    Puntaje general promedio: "
                    + first4char);
            System.out.println();

            top5.delete(top5.getContenido().get(0).getKey());

        }
        tiempoFinal = System.currentTimeMillis();
        System.out.println("Tiempo: ".concat(Long.toString((tiempoFinal-tiempoInicio)/1000).concat("s")));


        for(int i=0 ; i<beers.size();i++){
            beers.getByIndex(i).setPuntaje(0);
        }
    }

}






