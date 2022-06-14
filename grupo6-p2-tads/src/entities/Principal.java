package entities;

import exceptions.Fachainvalida;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Principal {
    public void menu()  {

        while (true){
            Scanner leer = new Scanner(System.in);
            System.out.println("1. 10 casas de cervezas con mas reseñas");
            System.out.println("2. Top 15 catadores con mas reseñas");
            System.out.println("3. Cantidad de reviews en determinado rango");
            System.out.println("4. Top 7 estilos de cerveza con mejor aroma");
            System.out.println("5. Top 5 cervezas con mas reviews");
            System.out.println("Ingrese la opción deseada");
            int numero = leer.nextInt();
            if (numero == 1) {
                try {
                    diezCasasDeCervezaConMasResenias();
                } catch (Fachainvalida e) {

                }
            }
            if (numero == 2) {
                top15CatadoresConMasResenias();

            }
            if (numero == 3) {
                cantidadDeReviewsEnRango();

            } else if (numero == 4) {
                top7EstilosDeCervezaConMejorAroma();

            } else if (numero == 5) {
                top5CervezasConMasReviews();
            } else {
                System.out.println("error");
                break;
            }
        }



    }

    public void diezCasasDeCervezaConMasResenias() throws Fachainvalida {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Ingrese una año");

        String fecha = scanner.next();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy");
        Date fecha1= null;

        try {
            fecha1 = dateFormat.parse(fecha);
        } catch (ParseException e) {
            throw new Fachainvalida();
        }
        

    }


    public void top15CatadoresConMasResenias(){

    }


    public void cantidadDeReviewsEnRango(){

    }

    public void top7EstilosDeCervezaConMejorAroma(){

    }

    public void top5CervezasConMasReviews(){

    }




}

