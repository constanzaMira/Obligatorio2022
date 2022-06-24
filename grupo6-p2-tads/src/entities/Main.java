package entities;


import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public void Menu() throws IOException, IllegalAccessException {

        Consultas consultas = null;
        boolean cargaDatos = false;

        while (true) {
            System.out.println();
            System.out.println("Ingrese una opcion del Menu:");
            System.out.println();
            Scanner leer0 = new Scanner(System.in);
            System.out.println("1. Carga de datos");
            System.out.println("2. Relizar consultas");
            System.out.println("3. Exit");
            String numero0 = leer0.next();
            System.out.println();
            if (numero0.equals("1")) {
                consultas = new Consultas();
                cargaDatos=true;
            } else if (numero0.equals("2")) {
                if(cargaDatos==true){
                    Scanner leer = new Scanner(System.in);
                    System.out.println();
                    System.out.println("1. 10 casas de cervezas con mas reviews");
                    System.out.println("2. Top 15 catadores con mas reviews");
                    System.out.println("3. Cantidad de reviews en determinado rango");
                    System.out.println("4. Top 7 estilos de cerveza con mejor aroma");
                    System.out.println("5. Top 5 cervezas con mas reviews");
                    System.out.println("Ingrese la opcion deseada");
                    String numero = leer.next();
                    System.out.println();
                    if (numero.equals("1")) {
                        try {
                            consultas.diezCasasDeCervezaConMasResenias();
                        } catch (IllegalAccessException e) {
                            System.out.println("Error");
                        }
                    } else if (numero.equals("2")) {
                        consultas.top15CatadoresConMasResenias();
                    } else if (numero.equals("3")) {
                        try {
                            consultas.cantidadDeReviewsEnRango();
                        } catch (IllegalAccessException e) {
                            System.out.println("Error");} catch (ParseException e) {
                            e.printStackTrace();} catch (RuntimeException e) {
                            System.out.println("Error");
                            }


                    } else if (numero.equals("4")) {
                        consultas.top7EstilosDeCervezaConMejorAroma();

                    } else if (numero.equals("5")) {
                        try {
                            consultas.top5CervezasConMasReviews();
                        } catch (IllegalAccessException e) {
                            System.out.println("Error");}
                    } else {
                        System.out.println("Error");}
                }
            } else if (numero0.equals("3")) {
                System.exit(0);
            } else {
                System.out.println("Error");

            }
        }
    }

    public static void main(String[] args) throws IOException, IllegalAccessException {
        Main main = new Main();
        main.Menu();
    }
}






