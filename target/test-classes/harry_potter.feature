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

  Scénario: 5% de réduction pour 2 livres différents
    Etant donné 1 du "premier" livre
    Etant donné 1 du "deuxieme" livre
    Quand on calcule le prix
    Alors le total est égal à 15.20€

  Scénario: 10% de réduction pour 3 livres différents
    Etant donné 1 du "premier" livre
    Etant donné 1 du "deuxieme" livre
    Etant donné 1 du "troisieme" livre
    Quand on calcule le prix
    Alors le total est égal à 21.60€

  Scénario: 20% de réduction pour 4 livres différents
    Etant donné 1 du "premier" livre
    Etant donné 1 du "deuxieme" livre
    Etant donné 1 du "troisieme" livre
    Etant donné 1 du "quatrieme" livre
    Quand on calcule le prix
    Alors le total est égal à 25.60€

  Scénario: 25% de réduction pour 5 livres différents
    Etant donné 1 du "premier" livre
    Etant donné 1 du "deuxieme" livre
    Etant donné 1 du "troisieme" livre
    Etant donné 1 du "quatrieme" livre
    Etant donné 1 du "cinquieme" livre
    Quand on calcule le prix
    Alors le total est égal à 30€

  Scénario: 5% de réduction pour 2 livres différents mais pas sur un autre identique
    Etant donné 2 du "premier" livre
    Etant donné 1 du "deuxieme" livre
    Quand on calcule le prix
    Alors le total est égal à 23.2€

  Scénario: 5% de réduction pour chaque couple de 2 livres différents
    Etant donné 2 du "premier" livre
    Etant donné 2 du "deuxieme" livre
    Quand on calcule le prix
    Alors le total est égal à 30.40€

  Scénario: 5% de réduction pour chaque couple de 2 livres différents mais pas pour les restant
    Etant donné 2 du "premier" livre
    Etant donné 1 du "deuxieme" livre
    Etant donné 2 du "troisieme" livre
    Etant donné 1 du "quatrieme" livre
    Quand on calcule le prix
    Alors le total est égal à 40.80€

  Scénario: 5% de réduction pour chaque couple de 2 livres différents mais pas pour les restant
    Etant donné 1 du "premier" livre
    Etant donné 2 du "deuxieme" livre
    Etant donné 1 du "troisieme" livre
    Etant donné 1 du "quatrieme" livre
    Etant donné 1 du "cinquieme" livre
    Quand on calcule le prix
    Alors le total est égal à 38.00€

  Scénario: dernier
    Etant donné 2 du "premier" livre
    Etant donné 2 du "deuxieme" livre
    Etant donné 2 du "troisieme" livre
    Etant donné 1 du "quatrieme" livre
    Etant donné 1 du "cinquieme" livre
    Quand on calcule le prix
    Alors le total est égal à 51.20€

    #51,6 : 2 groupes
    #1 de 5 livres = 30€
    #1 de 3 livres = 21,6€
    #total = 51.6€
    #
    #2 de 4 livres = 2* 25.60 = 51,2