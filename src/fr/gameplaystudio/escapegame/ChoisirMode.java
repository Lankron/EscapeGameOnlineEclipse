package fr.gameplaystudio.escapegame;


import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class ChoisirMode {

	ModeAttack mode1 = new ModeAttack();
	ModeDefense mode2 = new ModeDefense();
	ModeDuel mode3 = new ModeDuel(); 
	Main main = new Main();
	Scanner sc;
	final static Logger logger = Logger.getLogger(ChoisirMode.class);
	private static Accueil home = new Accueil();
	
	public void choixdumode(int nb){
		
		logger.info("recu du nombre de choixdumode");
		
		
		ArrayList<Integer> modeDeJeu = new ArrayList<Integer>();// ici je crée une arraylist pour récupérer ce que la personne a tapé ça me servira à enregistrer le mode de jeu qu'il a choisir pour le réutilisé au cas ou la personne veut rejouer
		modeDeJeu.add(nb);// ici j'ajoute dans mon arraylist la valeur.
		
		switch(nb){// je fais un switch c'est plus pratique qu'un if.
			
			case 1 :
			logger.info("choix du mode attack");
			
			mode1.reponseModeAttack();// ici c'est la classe mode attaque qui est appelé c'est le "Mode 1".
			
			break;
			
			case 2 :
			logger.info("choix du mode défense");
			
			mode2.reponseModeDefense();// ici c'est la classe mode défense qui est appelé c'est le "Mode 2".
			
			break;
			
			case 3 :
			logger.info("choix du mode duel");	
			mode3.reponseModeDuel();// ici c'est la classe mode duel qui est appelé c'est le "Mode 3".
			
			break;
			
		}
		
		// ici je procède au choix de fin de partie si l'utilisateur veut rejouer, changer de mode ou quitter l'application.
		logger.info("fin du mode on rerentre dans la méthode choixdumode");
		System.out.println("");
		System.out.println("Si vous voulez rejouer taper 1, ");
		System.out.println("si vous voulez changer de mode (aller sur l'écran d'acceuil) taper 2, ");
		System.out.println("si vous voulez quitté l'application taper 3.");
		System.out.println("");
		
		int choose = 0;// je déclare la variable choose a 0
		
		
		boolean itsNan = false;// je fais un boolean qui me servira a arrêté ma boucle si ma saisi est un nombre.
		while(itsNan == false) {// je fais une boucle tant que scanner n'est pas un nombre elle ne s'arrêtera pas.
		
		try {
		
		sc = new Scanner(System.in);// je récupère les informations qu'il a tapé.
		choose = sc.nextInt();// je récupère dans une varriable sous forme de integer.
		
		
		boolean saisiIsNotCorrect = true;// si la saisi n'est pas 1 2 ou 3 mon boolean est true
			
		while(saisiIsNotCorrect == true) {//je fais une boucle tant que ma saisi n'est pas 1 2 ou 3
				
				
				if(choose != 1 && choose != 2 && choose != 3) {//je fais une condition si ma saisi est différente de 1 2 ou 3 je demande une nouvelle saisi.
					
					System.out.println("Vous devez taper uniquement le chiffre 1, 2 ou 3 !!");
					System.out.println("Veuillez réessayer");
					choose = sc.nextInt();
					
				}
				
				
				if(nb == 1 || nb == 2 || nb == 3) {// je fais une condition si ma saisi est 1 ou 2 ou 3 j'arrête la boucle
					
					saisiIsNotCorrect = false;// je passe donc saisiIsNotCorrect en false
					
				}
			}
		
		
		itsNan = true;// si je passe par ici c'est que ma saisi est un chiffre entier donc je passe mon boolean en true
		if(itsNan == true) {// je fais une condition si mon boolean est true je peux envoyer en parametre mon entier
			break;// je break pour sortir de la boucle
		}
		
		
		
		}catch(java.util.InputMismatchException e) {// si je reçois cette erreur c'est que je n'ai aps entrer un chiffre entier
			System.out.println("Vous n'avez pas saisi un chiffre entier !!");
			System.out.println("Veuillez réessayer");
		logger.error("la saisi n'est pas un chiffre entier");
		
		
		}
		
		}
		switch(choose) {// je fais un switch c'est plus pratique qu'un if.
		
			case 1 :// le cas ou il relance la partie.
				logger.info("rentre dans le choix rejouer");
				ChoisirMode chooseMode = new ChoisirMode();// je réapelle la classe choisir mode sinon il ne relance pas les nombres aléatoire du computer du coup on se retrouvera avec le même nombre.
				chooseMode.choixdumode(modeDeJeu.get(0));// je lui demande de choisir le mode qu'il avait déjà choisis avant grace a la valeur dans l'arraylist crée au dessus.
				break;
			case 2 :// cas ou il veut choisir un autre mode.
				
				logger.info("rentre dans le choix accueil");
				modeDeJeu.clear();// j'efface la valeur de l'arraylist vue qu'elle va devenir une nouvelle valeur parce que la personne changera de mode de jeu.
				home.accueil();// je retourne sur la classe Accueil pour l'écran d'accueil
				break;
			case 3 :// ici je quitte l'application
				logger.info("rentre dans le choix quitter partie");
				System.exit(0);
				break;
		
		
		}
	
	
	}

	

}
