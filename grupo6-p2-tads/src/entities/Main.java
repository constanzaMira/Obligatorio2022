package entities;

import exceptions.Fechainvalida;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public void Menu() throws IOException {

        Consultas consultas = null;
        boolean cargaDatos = false;

        while (true) {
            Scanner leer0 = new Scanner(System.in);
            System.out.println("1. Carga de datos");
            System.out.println("2. Relizar consultas");
            System.out.println("3. Exit");
            int numero0 = leer0.nextInt();
            if (numero0 == 1) {
                    consultas = new Consultas();
                    cargaDatos=true;


            }
            if(cargaDatos=true){
                if (numero0 == 2) {
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
                            consultas.diezCasasDeCervezaConMasResenias();
                        } catch (IllegalAccessException e) {
                            break;
                        }
                    } else if (numero == 2) {
                        consultas.top15CatadoresConMasResenias();

                    } else if (numero == 3) {
                        try {
                            consultas.cantidadDeReviewsEnRango();
                        } catch (IllegalAccessException e) {
                            break;
                        }


                    } else if (numero == 4) {
                        consultas.top7EstilosDeCervezaConMejorAroma();

                    } else if (numero == 5) {
                        try {
                            consultas.top5CervezasConMasReviews();
                        } catch (IllegalAccessException e) {
                            break;
                        }
                    } else {
                        System.out.println("error");
                    }
                }
                if (numero0 == 3) {
                        System.exit(0);
                    }


                }

            }

        }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.Menu();
    }
}






