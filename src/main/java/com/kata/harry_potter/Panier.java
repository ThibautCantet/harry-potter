package com.kata.harry_potter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class Panier {
    private final List<Livre> livres;

    public Panier() {
        livres = new ArrayList<>();
    }

    public float computePrice() {
        if (livres.isEmpty()) {
            return 0;
        } else {
            return Livre.PRIX;
        }
    }

    public void ajouter(int quantite, Livre livre) {
        IntStream.range(0, quantite).forEach(x -> livres.add(livre));
    }
}
