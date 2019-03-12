package org.Primeau.app;

import org.Primeau.impl.ChangePrimeau;
import org.Primeau.impl.ServiceArgentPrimeau;
import org.Primeau.interfaces.Change;
import org.Primeau.utils.ArgentObjet;
import org.Primeau.utils.StringUtils;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class ScrapApp
{

	public static void main( String[] args )
	{
		Locale.setDefault(Locale.CANADA);
		Random rand = new Random();
		Scanner s = new Scanner(System.in);
		
		/**
		 * Changez ici pour tester vos propres classes
		 */
		ServiceArgentPrimeau m = new ServiceArgentPrimeau();  // changez le monnayeur par le vôtre
		
		while(true){
			double amount = 0.0;
			System.out.println("Entrez un montant entre 0 et 100 $ : (x POUR UN MONTANT AU HASARD)");
			if(!s.hasNextDouble()){
				s.next();
				amount = rand.nextInt(1000)*1.0 / 100;
			}
			else{
				amount = s.nextDouble();
			}
			System.out.println("################################## Calcul en cours pour "+amount + " sur 100$");
			try{
				System.out.println("Contenu du service tiroir caisse total : " + m.valeurTotale());
				Change donne = new ChangePrimeau();
				donne.ajouterItem(ArgentObjet.billet100,1);
				Change c = m.calculerChange(amount, donne);
				System.out.println("Change total : " + c.valeurTotale());
				System.out.println(StringUtils.toString(c));
				System.out.println("Contenu du service tiroir caisse total : " + m.valeurTotale());
				System.out.println(StringUtils.toString(m));
			}catch(Throwable e){
				e.printStackTrace();
			}
			System.out.println("##################################");
		}
	}
}
