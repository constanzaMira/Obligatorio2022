package entities;

import exceptions.Fechainvalida;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Principal {

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


        for (int i=0; i<DataLoad.getBeers().size();i++){
            if (DataLoad.getBeers().get(i).getReviewsId().get(i).getDate())

        }


    }

    public void top7EstilosDeCervezaConMejorAroma(){

    }

    public void top5CervezasConMasReviews(){

    }




}

