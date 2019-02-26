package org.Primeau.impl;

import org.Primeau.exception.NombreChangeInvalide;
import org.Primeau.exception.NombreChangeNegatif;
import org.Primeau.interfaces.Change;
import org.Primeau.impl.ChangePrimeau;
import org.Primeau.interfaces.ServiceArgent;
import org.Primeau.utils.ArgentObjet;

import java.util.Collections;
import java.util.HashMap;


public class ServiceArgentPrimeau implements ServiceArgent {

    private HashMap<ArgentObjet, Integer> map = new HashMap<ArgentObjet, Integer>(ArgentObjet.values().length){
        {
            for (ArgentObjet argent : ArgentObjet.values())
            {
                put(argent, 0);
            }
        }
    };

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
        return map.get(m);
    }

    public void ajouterItem(ArgentObjet m, int nombre) {
        if (nombre < 0 || nombre > capaciteMaxPour(m))
            throw new NombreChangeInvalide();

        int arg =  map.get(m);
        arg += nombre;
        map.put(m, arg);
    }

    public double valeurTotale() {
        int sum = 0;
        for (ArgentObjet a : map.keySet())
            sum += (a.valeur() * map.get(a));

        return  sum;
    }

    public int nombreTotalItems() {
        int sum = 0;
        for(ArgentObjet i: map.keySet())
            sum += (map.get(i));
        return  sum;
    }

    public int capaciteMaxPour(ArgentObjet m) {
        return 40;
    }

    public void retirerItems(ArgentObjet m, int nombre) {
        if (nombre < 0)
           throw new IllegalArgumentException();
        if (nombreItemsPour(m) - nombre < 0)
            throw new NombreChangeNegatif();

        map.put(m, nombreItemsPour(m) - nombre);
    }
}

