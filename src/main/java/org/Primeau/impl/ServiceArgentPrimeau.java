package org.Primeau.impl;

import org.Primeau.exception.ajoutInvalide;
import org.Primeau.interfaces.Change;
import org.Primeau.interfaces.ServiceArgent;
import org.Primeau.utils.ArgentObjet;


public class ServiceArgentPrimeau implements ServiceArgent {

    public Change calculerChange(double montantDu, Change argentDonne) { throw new UnsupportedOperationException(); }

    public double arrondiA5sous(double montant) {

        if(montant < 0 || montant > 1000000 || Double.isNaN(montant))
            throw new IllegalArgumentException();

        return Math.round(montant* 20.0) / 20.0;
    }

    public String nomEtudiant() {

        return "Émeryc Primeau";
    }

    public int nombreItemsPour(ArgentObjet m) {
        throw new UnsupportedOperationException();
    }

    public void ajouterItem(ArgentObjet m, int nombre) {
        throw new UnsupportedOperationException();
    }

    public double valeurTotale() {
        throw new UnsupportedOperationException();
    }

    public int nombreTotalItems() {
        throw new UnsupportedOperationException();
    }

    public int capaciteMaxPour(ArgentObjet m) {
        throw new UnsupportedOperationException();
    }

    public void retirerItems(ArgentObjet m, int nombre) {
        throw new UnsupportedOperationException();
    }
}

