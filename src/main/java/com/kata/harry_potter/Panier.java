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
            double discount = computeDiscount();

            Integer nombreTotalDeLivres = livres.values().stream()
                    .reduce(Integer::sum).orElse(0);
            return nombreTotalDeLivres * Livre.PRIX * discount;
        }
    }

    private double computeDiscount() {
        double discount = 1;
        if (livres.keySet().size() == 3) {
            discount = 0.9;
        }
        else if (livres.keySet().size() == 2) {
            discount = 0.95;
        }
        return discount;
    }

    public void ajouter(int quantite, Livre livre) {
        livres.put(livre, quantite);
    }
}
