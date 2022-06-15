package entities;

import uy.edu.um.prog2.tad.hash.MyHashTableImp;
import uy.edu.um.prog2.tad.linkedlist.MyList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

public class DataLoad {
    public static void DataLoad(MyList<User> users, MyHashTableImp<Review, Review> reviews, MyList<Brewery> breweries, MyList<Beer> beers, MyList<Style> styles) throws IOException {

        String file = "grupo6-p2-tads\\src\\entities\\beer_dataset_full.csv";
        BufferedReader reader = null;
        String line = "";
        boolean comenzar = false;
        boolean saltear = false;

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

        Long progreso = 0l;

        int breweryIndex = 0;
        int beerIndex = 0;


        try {
            reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {
                saltear = false;
                if (comenzar) {
                    String[] fila = line.split(",");
                    for (String elements: fila) {
                        if (elements.length() == 0) {
                            saltear = true;
                        }
                    }
                    if (fila.length == 14 && !saltear) {

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
                    else if (fila.length == 15 && !saltear){
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
                                nuevaFila[index] = fila[index].concat(",".concat(fila[index+1]));
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

                    if (!users.contains(newUser)) {
                        users.add(newUser);
                    }

                    newStyle = new Style(beer_style);

                    if (!styles.contains(newStyle)) {
                        styles.add(newStyle);
                    }

                    newReview = new Review(review_id, review_time, review_overall, review_appearance, review_aroma, beer_palate, review_taste, newUser, brewery_name);

                    if (!reviews.contains(newReview)) {
                        //reviews.add(newReview);
                    }

                    newBeer = new Beer(beer_beerId, beer_name, beer_abv);
                    newBeer.addReview(newReview);

                    if (!beers.contains(newBeer)) {
                        beers.add(newBeer);
                    }
                    else {
                        int i = beers.getIndex(newBeer);
                        newBeer = beers.get(i);
                        newBeer.addReview(newReview);
                        beers.set(i, newBeer);
                    }

                    newBrewery = new Brewery(brewery_id, brewery_name);
                    newBrewery.addBeer(newBeer);

                    if (!breweries.contains(newBrewery)) {
                        breweries.add(newBrewery);
                    }
                    else {
                        int i = breweries.getIndex(newBrewery);
                        newBrewery = breweries.get(i);
                        newBrewery.addBeer(newBeer);
                        breweries.set(i, newBrewery);
                    }
                }
                comenzar = true;
                System.out.println(progreso);
                progreso++;
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
