package entities;

import uy.edu.um.prog2.tad.arraylist.ArrayList;

public class Style {

    private String name;

    private ArrayList<Double> aromaScores = new ArrayList<>(10);

    public Style(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getAromaScores() {
        return aromaScores;
    }

    public void setAromaScores(ArrayList<Double> aromaScores) {
        this.aromaScores = aromaScores;
    }

    @Override
    public boolean equals(Object obj) {
        boolean exit = false;
        if (obj instanceof Style){
            Style tmp = (Style) obj;
            exit = this.getName() == tmp.getName();
        }
        return exit;
    }
}
