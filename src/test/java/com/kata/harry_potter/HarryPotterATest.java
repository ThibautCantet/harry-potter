package com.kata.harry_potter;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;

public class HarryPotterATest {

    @Etantdonné("le {string} livre")
    public void leLivre(String arg0) {
    }

    @Quand("on calcule le prix")
    public void onCalculeLePrix() {
    }

    @Alors("le total est égal à {int}€")
    public void leTotalEstÉgalÀ€(int total) {
    }
}
