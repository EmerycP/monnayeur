package org.Primeau;

import org.Primeau.impl.ChangePrimeau;
import org.Primeau.utils.ArgentObjet;
import org.junit.Assert;
import org.junit.Test;

/**
 * Pour rappel, une classe de test par classe testée
 */
public class TestServiceArgentPrimeau {

    @Test
    public void testAjoutSimple()
    {
        ChangePrimeau c = new ChangePrimeau();
        c.ajouterItem(ArgentObjet.billet100, 3);
        Assert.assertEquals(300, c.valeurTotale(),0);
        c.ajouterItem(ArgentObjet.billet10, 3);
        Assert.assertEquals(330, c.valeurTotale(),0);
    }
    @Test
    public void testAjoutBeaucoup()
    {
        ChangePrimeau c = new ChangePrimeau();
        c.ajouterItem(ArgentObjet.billet100, 3);
        Assert.assertEquals(300, c.valeurTotale(),0);
        c.ajouterItem(ArgentObjet.piece1, 1341234123);
        Assert.assertEquals(1341234423, c.valeurTotale(),0);
    }
    @Test
    public void testAjoutNegatif()
    {
        ChangePrimeau c = new ChangePrimeau();
        c.ajouterItem(ArgentObjet.billet100, 3);
        Assert.assertEquals(300, c.valeurTotale(),0);
        c.ajouterItem(ArgentObjet.piece1, -1);
        Assert.assertEquals(300, c.valeurTotale(),0);
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
        // TODO
        ChangePrimeau c = new ChangePrimeau();
        Assert.assertEquals(c.valeurTotale(), 0,0);
        Assert.assertEquals(c.nombreTotalItems(), 0, 0);
    }
	
}
