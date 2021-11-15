package com.kata.harry_potter;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;

import static org.assertj.core.api.Assertions.*;

public class HarryPotterATest {

    private float result;
    private Panier panier = new Panier();

    @Etantdonné("pas de livre")
    public void pasDeLivre() {

    }

    @Etantdonné("{int} du {string} livre")
    public void duLivre(int quantite, String titre) {
        Livre livre = new Livre(titre);
        panier.ajouter(quantite, livre);
    }

    @Quand("on calcule le prix")
    public void onCalculeLePrix() {
        result = panier.computePrice();
    }

    @Alors("le total est égal à {int}€")
    public void leTotalEstÉgalÀ€(int total) {
        assertThat(result).isEqualTo(total);
    }
}
