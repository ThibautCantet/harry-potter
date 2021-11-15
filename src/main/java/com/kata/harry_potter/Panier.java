package com.kata.harry_potter;

import java.util.HashMap;
import java.util.Map;


public class Panier {
    private final Map<Livre, Integer> livres;

    public Panier() {
        livres = new HashMap<>();
    }

    public double computePrice() {
        if (livres.isEmpty()) {
            return 0;
        } else {
            Integer nombreTotalDeLivres = livres.values().stream()
                    .reduce(Integer::sum).orElse(0);
            return nombreTotalDeLivres * Livre.PRIX;
        }
    }

    public void ajouter(int quantite, Livre livre) {
        livres.put(livre, quantite);
    }
}
