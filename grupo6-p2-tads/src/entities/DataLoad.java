package entities;

import uy.edu.um.prog2.tad.arraylist.MyArrayList;
import uy.edu.um.prog2.tad.hash.HashTable;
import uy.edu.um.prog2.tad.linkedlist.MyList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class DataLoad {
    public static void DataLoad(HashTable<Long, Brewery> breweries, HashTable<Long, Beer> beers) throws IOException {

        String file = "grupo6-p2-tads\\src\\entities\\beer_dataset_test.csv";
        BufferedReader reader = null;
        String line = "";
        boolean comenzar = false;

        Long review_id = null;
        Long brewery_id = null;
        String brewery_name = null;
        Date review_time = null;
        double review_overall = 0;
        double review_aroma = 0;
        double review_appearance = 0;
        String review_profileName = null;
        String beer_style = null;
        double beer_palate = 0;
        double review_taste = 0;
        String beer_name = null;
        double beer_abv = 0;
        Long beer_beerId = null;

        User newUser;
        Style newStyle;
        Beer newBeer;
        Brewery newBrewery;
        Review newReview;

        double progreso = 0;
        double percentage = 0;

        long tiempoInicio = System.currentTimeMillis();
        long tiempoFinal;


        try {
            reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {
                if (comenzar) {
                    String[] fila = line.split(",");
                    if(fila[12]!=null){
                        for (int k = 0; k < fila.length; k++) {
                            if (fila[k].length() == 0) {
                                fila[k] = "0";
                            }
                        }
                        if (fila.length == 14) {

                            review_id = Long.valueOf(fila[0]);
                            //System.out.println(review_id);
                            brewery_id = Long.valueOf(fila[1]);
                            brewery_name = fila[2];
                            review_time = new Date(Long.valueOf(fila[3]) * 1000);
                            // System.out.println(review_time);
                            review_overall = Double.valueOf(fila[4]);
                            review_aroma = Double.valueOf(fila[5]);
                            review_appearance = Double.valueOf(fila[6]);
                            review_profileName = fila[7];
                            beer_style = fila[8];
                            beer_palate = Double.valueOf(fila[9]);
                            review_taste = Double.valueOf(fila[10]);
                            beer_name = fila[11];
                            beer_abv = Double.valueOf(fila[12]);
                            beer_beerId = Long.valueOf(fila[13]);
                        }
                        else if (fila.length == 15){
                            int j = 0;

                            for (int index = 0; index < fila.length; index++) {
                                if (fila[index].charAt(0) == '"') {
                                    j = index;
                                    break;
                                }
                            }
                            String[] nuevaFila = new String[14];
                            for (int index = 0; index < 14; index++) {
                                if (index < j) {
                                    nuevaFila[index] = fila[index];
                                }
                                else if (index == j) {
                                    String s = String.valueOf('"');
                                    nuevaFila[index] = fila[index].concat(",".concat(fila[index+1])).replaceAll(s,"");
                                }
                                else {
                                    nuevaFila[index] = fila[index+1];
                                }
                            }
                            fila = nuevaFila;
                            //System.out.println(Arrays.asList(fila));

                            review_id = Long.valueOf(fila[0]);
                            //System.out.println(review_id);
                            brewery_id = Long.valueOf(fila[1]);
                            brewery_name = fila[2];
                            review_time = new Date(Long.valueOf(fila[3]) * 1000);
                            review_overall = Double.valueOf(fila[4]);
                            review_aroma = Double.valueOf(fila[5]);
                            review_appearance = Double.valueOf(fila[6]);
                            review_profileName = fila[7];
                            beer_style = fila[8];
                            beer_palate = Double.valueOf(fila[9]);
                            review_taste = Double.valueOf(fila[10]);
                            beer_name = fila[11];
                            beer_abv = Double.valueOf(fila[12]);
                            beer_beerId = Long.valueOf(fila[13]);

                        }

                        newUser = new User(review_profileName);


                        newStyle = new Style(beer_style);


                        newReview = new Review(review_id, review_time, review_overall, review_appearance, review_aroma, beer_palate, review_taste, newUser, brewery_id);

                        newBeer = new Beer(beer_beerId, beer_name, beer_abv, newStyle);
                        newBeer.addReview(newReview);

                        newBrewery = new Brewery(brewery_id, brewery_name);

                        if (!breweries.contains(brewery_id)) {
                            newBrewery.addBeer(beer_beerId);
                            breweries.put(brewery_id, newBrewery);
                            beers.put(beer_beerId, newBeer);
                        }
                        else {
                            newBrewery = breweries.get(brewery_id);
                            if (!beers.contains(beer_beerId)) {
                                newBrewery.addBeer(beer_beerId);
                                breweries.set(brewery_id, newBrewery);
                                beers.put(beer_beerId, newBeer);
                            }
                            else {
                                newBeer = beers.get(beer_beerId);
                                newBeer.addReview(newReview);
                                beers.set(beer_beerId, newBeer);

                            }
                        }

                    }
                    }

                comenzar = true;

                //percentage = (progreso/1586614)*100;
                //System.out.println(String.format("%.2f", (percentage)).concat("%"));
                progreso++;
            }
            tiempoFinal = System.currentTimeMillis();
            System.out.println("Tiempo: " + (tiempoFinal-tiempoInicio) + "milisegundos");
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
