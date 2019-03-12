package org.Primeau;

import org.Primeau.impl.ChangePrimeau;
import org.Primeau.utils.ArgentObjet;
import org.junit.Assert;
import org.junit.Test;

public class TestChangePrimeau {
    @Test
    public void testAjoutSimple()
    {
        ChangePrimeau c = new ChangePrimeau();
        c.ajouterItem(ArgentObjet.piece25s, 3);
        Assert.assertEquals(0.75, c.valeurTotale(),0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAjoutBeaucoup()
    {
        ChangePrimeau c = new ChangePrimeau();
        c.ajouterItem(ArgentObjet.billet100, 3);
        Assert.assertEquals(300, c.valeurTotale(),0);
        c.ajouterItem(ArgentObjet.piece1, 1341234123);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAjoutNegatif()
    {
        ChangePrimeau c = new ChangePrimeau();
        c.ajouterItem(ArgentObjet.billet100, 3);
        Assert.assertEquals(300, c.valeurTotale(),0);
        c.ajouterItem(ArgentObjet.piece1, -1);
    }
    @Test
    public void testNombre()
    {
        ChangePrimeau c = new ChangePrimeau();
        c.ajouterItem(ArgentObjet.billet20, 2);
        Assert.assertEquals(2, c.nombreItemsPour(ArgentObjet.billet20), 0);
    }
    @Test
    public void testVide()  {
        ChangePrimeau c = new ChangePrimeau();
        Assert.assertEquals(0, c.valeurTotale(),0);
        Assert.assertEquals(0, c.nombreTotalItems(), 0);
    }
    @Test
    public void testValeur() {
        ChangePrimeau c = new ChangePrimeau();
        c.ajouterItem(ArgentObjet.billet5, 1);
        Assert.assertEquals(5, c.valeurTotale(), 0);
    }
    @Test
    public void testValeurNombreTotalParItem() {
        ChangePrimeau c = new ChangePrimeau();
        c.ajouterItem(ArgentObjet.billet5, 5);
        Assert.assertEquals(5, c.nombreItemsPour(ArgentObjet.billet5), 0);

    }
}
