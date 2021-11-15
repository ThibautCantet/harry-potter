# language: fr
Fonctionnalité: Calculer le prix d'un panier avec différents livres Harry Potter

  Scénario: Prix pour 0 livre
    Etant donné pas de livre
    Quand on calcule le prix
    Alors le total est égal à 0€

  Scénario: Prix pour un seul premier livre
    Etant donné 1 du "premier" livre
    Quand on calcule le prix
    Alors le total est égal à 8€

  Scénario: Prix pour un seul deuxieme livre
    Etant donné 1 du "deuxieme" livre
    Quand on calcule le prix
    Alors le total est égal à 8€

  Scénario: Prix pour un seul troisieme livre
    Etant donné 1 du "troisieme" livre
    Quand on calcule le prix
    Alors le total est égal à 8€

  Scénario: Prix pour un seul quatrieme livre
    Etant donné 1 du "quatrieme" livre
    Quand on calcule le prix
    Alors le total est égal à 8€

  Scénario: Prix pour un seul cinquieme livre
    Etant donné 1 du "cinquieme" livre
    Quand on calcule le prix
    Alors le total est égal à 8€

  Scénario: Prix pour trois fois le cinquieme livre
    Etant donné 3 du "cinquieme" livre
    Quand on calcule le prix
    Alors le total est égal à 24€