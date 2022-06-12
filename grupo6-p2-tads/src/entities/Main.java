package entities;

import java.util.Scanner;

public class Main {
    public void menu()  {
        Scanner leer = new Scanner(System.in);
        System.out.println("1. 10 casas de cervezas con mas resenias");
        System.out.println("2. Top 15 catadores con mas resenias");
        System.out.println("3. Cantidad de reviews en determinado rango");
        System.out.println("4. Top 7 estilos de cerveza con mejor aroma");
        System.out.println("5. Top 5 cervezas con mas reviews");
        System.out.println("ingrese la opcion deseada");
        int numero = leer.nextInt();
        if (numero == 1) {
            diezCasasDeCervezaConMasResenias();
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
            menu();
        }


    }

    public void diezCasasDeCervezaConMasResenias() {


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

