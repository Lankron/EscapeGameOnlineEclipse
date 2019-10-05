package fr.gameplaystudio.escapegame;

import java.util.Scanner;

import org.apache.log4j.Logger;
public class Accueil {
	
	private static Scanner sc;
	final static Logger logger = Logger.getLogger(Main.class);
	
	
	public void accueil() {
		
		logger.info("Chargement de la page d'accueil et chargement de la classe ChoisirMode");
		
		
		ChoisirMode chooseMode = new ChoisirMode();// j'appelle la classe ChoisirMode qui me servira a choisir un mode.
		
		System.out.println("Bonjour, veuillez choisir un mode de jeu");
		System.out.println("Pour le mode de jeu Attaque taper 1, ");
		System.out.println("pour le mode de jeu Défense taper 2,");
		System.out.println("pour le mode de jeu Duel taper 3 .");
		
		boolean itsNan = false;// je fais un boolean qui me servira a arrêté ma boucle si ma saisi est un nombre.
		
		while(itsNan == false) {// je fais une boucle tant que scanner n'est pas un nombre elle ne s'arrêtera pas.
			
		
		try {
			
			
			sc = new Scanner(System.in);// ici j'appelle la classe scanner qui me ser t a récupérer ce que l'utilisateur écrit.
			
			int nb = sc.nextInt();// ici je récupère dans cette variable ce que l'utilisateur écrit en Integer.
			
			
			logger.info("envoie du nombre à la méthode choixdumode");
			boolean saisiIsNotCorrect = true;// si la saisi n'est pas 1 2 ou 3 mon boolean est true
			
			while(saisiIsNotCorrect == true) {//je fais une boucle tant que ma saisi n'est pas 1 2 ou 3
			
			if(nb != 1 && nb != 2 && nb != 3) {//je fais une condition si ma saisi est différente de 1 2 ou 3 je demande une nouvelle saisi.
				
				System.out.println("Vous devez taper uniquement le chiffre 1, 2 ou 3 !!");
				System.out.println("Veuillez réessayer");
				nb = sc.nextInt();
				
			}
			if(nb == 1 || nb == 2 || nb == 3) {// je fais une condition si ma saisi est 1 ou 2 ou 3 j'arrête la boucle
				
				saisiIsNotCorrect = false;// je passe donc saisiIsNotCorrect en false
				
			}
			
			}
			
			itsNan = true;// si je passe par ici c'est que ma saisi est un chiffre entier donc je passe mon boolean en true
			if(itsNan == true) {// je fais une condition si mon boolean est true je peux envoyer en parametre mon entier
				chooseMode.choixdumode(nb);// j'envoie à la classe choix du mode mon entier
				break;// je break pour sortir de la boucle
			
			}
			
			}catch(java.util.InputMismatchException e) {// si je reçois cette erreur c'est que je n'ai aps entrer un chiffre entier
			
			System.out.println("Vous n'avez pas saisi un chiffre entier !!");// je précise donc a l'utilisateur qu'il n'a pas saisi de chiffre entier donc itsNan est bien en false.
			System.out.println("Veuillez réessayer");
			logger.error("la saisi n'est pas un chiffre entier ou il y'a une erreur au niveau de la saisi");
			
			
		}
		
		}
	}
	
}
