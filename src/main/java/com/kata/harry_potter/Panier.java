package com.kata.harry_potter;

import java.util.HashMap;
import java.util.Map;


public class Panier {
    private final static Map<Integer, Double> DISCOUNT_RULES = Map.of(
            1, 1d,
            2, 0.95,
            3, 0.9,
            4, 0.8,
            5, 0.75
    );

    private final Map<Livre, Integer> livres;


    public Panier() {
        livres = new HashMap<>();
    }

    public double computePrice() {
        if (livres.isEmpty()) {
            return 0;
        } else {
            double discount = DISCOUNT_RULES.get(livres.keySet().size());
            Integer nombreTotalDeLivres = getNombreTotalDeLivres();
            return nombreTotalDeLivres * Livre.PRIX * discount;
        }
    }

    private Integer getNombreTotalDeLivres() {
        return livres.values().stream()
                .reduce(Integer::sum).orElse(0);
    }

    public void ajouter(int quantite, Livre livre) {
        livres.put(livre, quantite);
    }
}
