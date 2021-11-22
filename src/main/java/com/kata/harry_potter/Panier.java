package com.kata.harry_potter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


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
            double prixTotal = 0;

            Integer nombreDeLots = Collections.max(livres.values());

            for (int i = 1; i <= nombreDeLots; i++) {
                AtomicInteger nombreDeLivres = new AtomicInteger(0);
                int nombreDeLotCourant = i;
                livres.keySet()
                       .stream()
                       .forEach(livre -> {
                           int nombreDeLivresCourant = livres.getOrDefault(livre, 0);
                           if (nombreDeLivresCourant  >= nombreDeLotCourant) {
                               nombreDeLivres.getAndIncrement();
                           }
                       });

                /***
                 * lot 1 : premier + deuxieme => 5%
                 * lot 2 : premier
                 */

                double discountCourant = DISCOUNT_RULES.getOrDefault(nombreDeLivres.get(), 1d);

                double prixLotCourant = nombreDeLivres.get() * Livre.PRIX * discountCourant;

                prixTotal += prixLotCourant;
            }
            return prixTotal;
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
