package fr.gameplaystudio.escapegame;


import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class ChoisirMode {

	ModeAttack mode1 = new ModeAttack();
	ModeDefense mode2 = new ModeDefense();
	ModeDuel mode3 = new ModeDuel(); 
	Home home = new Home();
	Scanner sc;
	final static Logger logger = Logger.getLogger(ChoisirMode.class);
	
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
		System.out.println("Si vous voulez rejouer taper 1, si vous voulez changer de mode (aller sur l'écran d'acceuil) taper 2, si vous voulez quitté l'application taper 3");
		int choose = 0;

		boolean isNan = false;// je déclare mon booléan en false il me servira a savoir si ma saisi est un nombre ou non
		
		while(isNan == false) {// je fais une boucle tant que mon boolean est false
		
		try {
		sc = new Scanner(System.in);// je récupère les informations qu'il a tapé.
		choose = sc.nextInt();// je récupère dans une varriable sous forme de integer.
		boolean isNotCorrect = true;// je déclare mon booléan en true il me servira a savoir si ma saisi est 1 2 ou 3.
		
		while(isNotCorrect == true) {// je fais une boucle tant que mon boolean est true
			
			if(choose != 1 && choose != 2 && choose != 3) {// si ma saisi est différent de 1 2 et 3 je n'arrête pas la boucle
				System.out.println("Vous n'avez pas tapé 1 2 ou 3.");
				choose = sc.nextInt();
			}
			if(choose == 1 || choose == 2 || choose == 3) {	// si ma sais est égale a 1 2 ou 3 j'arrête ma boucle en déclarant is Not Correct en false
				
				isNotCorrect = false;
					
			}
			
		}
		isNan = true;// si ma saisi vien ici c'est que c'est un entier je déclare donc mon boolean en true
		if(isNan == true) {// si mon boolean est true j'envoie mon entier dans ma méthode choix du mode
			
			break;
		}
		}catch(java.util.InputMismatchException e) {
			System.out.println("Vous n'avez pas tapé un chiffre entier");
			System.out.println("Veuillez réessayer tapé soit 1, soit 2  soit 3");
			
			logger.error("la saisi n'est pas un chiffre entier");
		
		
		}// je gère mon exception
		
		
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
				home.home();// je retourne sur ma classe home pour l'écran d'accueil
				break;
			case 3 :// ici je quitte l'application
				logger.info("rentre dans le choix quitter partie");
				System.exit(0);
				break;
		
		
		}
	
	
	  
	  
	
	
	

	
	}

	

}
