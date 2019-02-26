package org.Primeau;

import org.Primeau.exception.NombreChangeInvalide;
import org.Primeau.exception.NombreChangeNegatif;
import org.Primeau.impl.ChangePrimeau;
import org.Primeau.impl.ServiceArgentPrimeau;
import org.Primeau.interfaces.Change;
import org.Primeau.interfaces.ServiceArgent;
import org.Primeau.utils.ArgentObjet;
import org.junit.Assert;
import org.junit.Test;

/**
 * Pour rappel, une classe de test par classe testée
 */
public class TestServiceArgentPrimeau {
    @Test
    public void testRound0() {
        ServiceArgentPrimeau c = new ServiceArgentPrimeau();
        Assert.assertEquals(0, c.arrondiA5sous(0.00), 0);
        Assert.assertEquals(0, c.arrondiA5sous(0.01), 0);
        Assert.assertEquals(0, c.arrondiA5sous(0.02), 0);

    }
    @Test
    public void testRound5() {
        ServiceArgentPrimeau c = new ServiceArgentPrimeau();
        Assert.assertEquals(0.05, c.arrondiA5sous(0.03), 0);
        Assert.assertEquals(0.05, c.arrondiA5sous(0.04), 0);
        Assert.assertEquals(0.05, c.arrondiA5sous(0.05), 0);
        Assert.assertEquals(0.05, c.arrondiA5sous(0.06), 0);
        Assert.assertEquals(0.05, c.arrondiA5sous(0.07), 0);


    }
    @Test
    public void testRound1() {
        ServiceArgentPrimeau c = new ServiceArgentPrimeau();
        Assert.assertEquals(0.1, c.arrondiA5sous(0.08), 0);
        Assert.assertEquals(0.1, c.arrondiA5sous(0.09), 0);
        Assert.assertEquals(0.1, c.arrondiA5sous(0.1), 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRoundExceptionNegatifLimite(){
        ServiceArgentPrimeau c = new ServiceArgentPrimeau();
        c.arrondiA5sous(-0.01);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRoundExceptionNegatif(){
        ServiceArgentPrimeau c = new ServiceArgentPrimeau();
        c.arrondiA5sous(-40);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRoundExceptionBigLimite(){
        ServiceArgentPrimeau c = new ServiceArgentPrimeau();
        c.arrondiA5sous(1000000.1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRoundExceptionBig(){
        ServiceArgentPrimeau c = new ServiceArgentPrimeau();
        c.arrondiA5sous(23452345);
    }
    @Test
    public void testAjoutSimpleService()
    {
        ServiceArgentPrimeau c = new ServiceArgentPrimeau();
        c.ajouterItem(ArgentObjet.billet100, 3);
        Assert.assertEquals(300, c.valeurTotale(),0);
        c.ajouterItem(ArgentObjet.billet10, 3);
        Assert.assertEquals(330, c.valeurTotale(),0);
    }
    @Test(expected = NombreChangeInvalide.class)
    public void testAjoutBeaucoupService()
    {
        ServiceArgentPrimeau c = new ServiceArgentPrimeau();
        c.ajouterItem(ArgentObjet.billet100, 3);
        Assert.assertEquals(300, c.valeurTotale(),0);
        c.ajouterItem(ArgentObjet.piece1, 1341234123);
    }
    @Test(expected = NombreChangeInvalide.class)
    public void testAjoutNegatifService()
    {
        ServiceArgentPrimeau c = new ServiceArgentPrimeau();
        c.ajouterItem(ArgentObjet.billet100, 3);
        Assert.assertEquals(300, c.valeurTotale(),0);
        c.ajouterItem(ArgentObjet.piece1, -1);
    }
    @Test
    public void testNombreService()
    {
        ServiceArgentPrimeau c = new ServiceArgentPrimeau();
        c.ajouterItem(ArgentObjet.billet20, 2);
        Assert.assertEquals(2, c.nombreItemsPour(ArgentObjet.billet20), 0);
    }
    @Test
    public void testVideService()  {
        ServiceArgentPrimeau c = new ServiceArgentPrimeau();
        Assert.assertEquals(0, c.valeurTotale(),0);
        Assert.assertEquals(0, c.nombreTotalItems(), 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRetirerNombreNeg(){
        ServiceArgentPrimeau c = new ServiceArgentPrimeau();
        c.ajouterItem(ArgentObjet.billet20, 5);
        c.retirerItems(ArgentObjet.billet20, -2);
    }
    @Test
    public void testretirerItemsMarche(){
        ServiceArgentPrimeau c = new ServiceArgentPrimeau();
        c.ajouterItem(ArgentObjet.billet20, 5);
        c.retirerItems(ArgentObjet.billet20, 3);
        Assert.assertEquals(2 ,c.nombreItemsPour(ArgentObjet.billet20), 0);
    }
    @Test(expected = NombreChangeNegatif.class)
    public void testCapaciteMaxMarche2(){
        ServiceArgentPrimeau c = new ServiceArgentPrimeau();
        c.ajouterItem(ArgentObjet.billet20, 5);
        c.retirerItems(ArgentObjet.billet20, 7);
        Assert.assertEquals(2 ,c.nombreItemsPour(ArgentObjet.billet20), 0);
    }
	
}
