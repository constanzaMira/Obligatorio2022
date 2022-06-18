package entities;

import exceptions.Fechainvalida;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public void Menu(){

        Principal principal= new Principal();


        while (true){
            Scanner leer0 = new Scanner(System.in);
            System.out.println("1. Carga de datos" );
            System.out.println("2. Relizar consultas");
            System.out.println("3. Exit");
            int numero0 = leer0.nextInt();
            if(numero0==1){
                try {
                    DataLoad.dataLoad();
                } catch (IOException e) {

                }
                //aca va lo correspondiente a la craga de datos
            }
            if(numero0==2){
                Scanner leer = new Scanner(System.in);
                System.out.println("1. 10 casas de cervezas con mas resenias");
                System.out.println("2. Top 15 catadores con mas resenias");
                System.out.println("3. Cantidad de reviews en determinado rango");
                System.out.println("4. Top 7 estilos de cerveza con mejor aroma");
                System.out.println("5. Top 5 cervezas con mas reviews");
                System.out.println("ingrese la opcion deseada");
                int numero = leer.nextInt();
                if (numero == 1) {
                    try {
                        principal.diezCasasDeCervezaConMasResenias();
                    } catch (Fechainvalida e) {

                    }

                }
                if (numero == 2) {
                    principal.top15CatadoresConMasResenias();

                }
                if (numero == 3) {
                    principal.cantidadDeReviewsEnRango();


                } else if (numero == 4) {
                    principal.top7EstilosDeCervezaConMejorAroma();

                } else if (numero == 5) {
                    principal.top5CervezasConMasReviews();
                } else {
                    System.out.println("error");
                }

            }
            if (numero0==3){
                System.exit(0);

            }



        }



    }


    public static void main(String[] args) {
        Main main= new Main();
        main.Menu();

    }
}


