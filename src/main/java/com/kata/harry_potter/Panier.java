package com.kata.harry_potter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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

            Integer nombreDeGroupeDeLivres = Collections.max(livres.values());

            for (int numeroDeGroupe = 1; numeroDeGroupe <= nombreDeGroupeDeLivres; numeroDeGroupe++) {
                Integer nombreDeLivresDansLeGroupe = compterNombreDeLivreDansLeGroupe(numeroDeGroupe);

                double discount = DISCOUNT_RULES.getOrDefault(nombreDeLivresDansLeGroupe, 1d);

                double prixGroupeCourant = nombreDeLivresDansLeGroupe * Livre.PRIX * discount;

                prixTotal += prixGroupeCourant;
            }
            return prixTotal;
        }
    }

    private Integer compterNombreDeLivreDansLeGroupe(int numeroGroupeDeLivresCourant) {
        AtomicInteger nombreDeLivres = new AtomicInteger(0);
        Set<Livre> livresDuPanier = livres.keySet();
        livresDuPanier
               .forEach(livre -> {
                   boolean livreAjoutableDansLeGroupe = livreAjoutableDansLeGroupe(numeroGroupeDeLivresCourant, livre);
                   if (livreAjoutableDansLeGroupe) {
                       nombreDeLivres.getAndIncrement();
                   }
               });
        return nombreDeLivres.get();
    }

    private boolean livreAjoutableDansLeGroupe(int numeroGroupeDeLivresCourant, Livre livre) {
        int nombreDeLivresCourant = livres.getOrDefault(livre, 0);
        return nombreDeLivresCourant >= numeroGroupeDeLivresCourant;
    }

    public void ajouter(int quantite, Livre livre) {
        livres.put(livre, quantite);
    }
}
