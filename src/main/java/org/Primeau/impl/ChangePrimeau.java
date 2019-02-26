package org.Primeau.impl;

import com.sun.org.apache.xpath.internal.Arg;
import org.Primeau.utils.ArgentObjet;
import org.Primeau.interfaces.Change;
import java.util.HashMap;
import java.util.List;


public class ChangePrimeau implements Change {
    private HashMap<ArgentObjet, Integer> map = new HashMap<ArgentObjet, Integer>(ArgentObjet.values().length){
        {
            for (ArgentObjet argent : ArgentObjet.values())
            {
                put(argent, 0);
            }
        }
    };

    public int nombreItemsPour(ArgentObjet m) {

        return map.get(m);
    }

    public void ajouterItem(ArgentObjet m, int nombre) {

        if (nombre < 0 || nombre > 1000000)
            throw new IllegalArgumentException();

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
}
