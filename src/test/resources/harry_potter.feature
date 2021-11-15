# language: fr
Fonctionnalité: Calculer le prix d'un panier avec différents livres Harry Potter

  Scénario: Prix pour 0 livre
    Etant donné pas de livre
    Quand on calcule le prix
    Alors le total est égal à 0€

  Scénario: Prix pour un seul livre
    Etant donné 1 du "premier" livre
    Quand on calcule le prix
    Alors le total est égal à 8€