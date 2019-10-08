package fr.gameplaystudio.escapegame;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Home {
	
	private static Scanner sc;
	final static Logger logger = Logger.getLogger(Main.class);

	public void home() {
		
		
		logger.info("Chargement de la page d'accueil et chargement de la classe ChoisirMode");
		
		
		ChoisirMode chooseMode = new ChoisirMode();// j'appelle la classe ChoisirMode qui me servira à choisir un mode.
		System.out.println("");
		System.out.println("Bonjour, veuillez choisir un mode de jeu");
		System.out.println("Pour le mode de jeu Attaque taper 1,");
		System.out.println("pour le mode de jeu Défense taper 2,");
		System.out.println("pour le mode de jeu Duel taper 3.");
		boolean isNan = false;// je déclare mon boolean en false il me servira à savoir si la saisie est un nombre ou non
		
		while(isNan == false) {// je fais une boucle tant que mon boolean est false
			
			
			try {
				
				
			
				sc = new Scanner(System.in);// ici j'appelle la classe scanner qui me sert à récupérer ce que l'utilisateur écrit.
				
				int nb = sc.nextInt();// ici je récupère dans cette variable ce que l'utilisateur écrit en Integer.
				
				logger.info("envoie du nombre à la méthode choixdumode");
				
				boolean isNotCorrect = true;// je déclare mon booléan en true il me servira à savoir si la saisie est 1 2 ou 3.
				
				while(isNotCorrect == true) {// je fais une boucle tant que mon boolean est true
					
					if(nb != 1 && nb != 2 && nb != 3) {// si la saisie est différente de 1 2 et 3 je n'arrête pas la boucle
						System.out.println("Vous n'avez pas tapé 1, 2 ou 3.");
						nb = sc.nextInt();
					}
					if(nb == 1 || nb == 2 || nb == 3) {	// si la saisie est égale à 1 2 ou 3 j'arrête la boucle en déclarant is Not Correct en false
						
						isNotCorrect = false;
							
					}
					
				}
				
				isNan = true;// si la saisie vient ici c'est que c'est un entier je déclare donc mon boolean en true
				if(isNan == true) {// si mon boolean est true j'envoie mon entier dans la méthode choix du mode
					chooseMode.choixdumode(nb);
					break;
				}
			
			
			}catch(java.util.InputMismatchException e) {// je gère mon exception
				System.out.println("");
				System.out.println("Vous n'avez pas tapé un chiffre");
				System.out.println("Veuillez réessayer tapé soit 1, soit 2  soit 3");
				
				logger.error("la saisie n'est pas un chiffre entier ou il y a une erreur au niveau de la saisie");
				
				
			
			}
			
		}
				
				
		
		
		
		
		
	}




}
