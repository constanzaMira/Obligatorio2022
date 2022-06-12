package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class DataLoad {
    public static void main(String[] args) throws IOException {

        String file = "E:\\Copias de Seguridad\\Facultad\\3er Semestre\\Programación 2\\Repositorios\\Obligatorio\\Url\\src\\beer_dataset_test.csv";
        BufferedReader reader = null;
        String line = "";
        int i = 0;

        Long hora = (12951533795l*100);

        Date tiempo = new Date(hora);
        System.out.println(tiempo);

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null && i < 4) {

                String[] row = line.split(",");

                for(String index : row) {
                    System.out.printf("%-10s", index);
                }
                System.out.println();
                i++;
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
        }
    }
}
