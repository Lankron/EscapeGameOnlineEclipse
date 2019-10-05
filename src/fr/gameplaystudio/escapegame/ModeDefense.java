package fr.gameplaystudio.escapegame;

import java.util.ArrayList;

import org.apache.log4j.Logger;


public class ModeDefense {

	
	
	Computer c = new Computer();// j'appel la classe computer pour avoir toute les informations du computer
	Player p = new Player();// j'appel la classe player pour avoir toute les informations du player

	Configuration config = new Configuration();// j'appel la class config la ou y'a tous mes fichiers de configuration
	ModeCalcul mc = new ModeCalcul();
	final static Logger logger = Logger.getLogger(ModeDefense.class);
	  
	
	



	
	public void reponseModeDefense() {// ici c'est ma méthode pour calculer et envoyer la réponse du mode défense
		logger.info("rentre dans la méthode d'envoie de la réponse du mode défense");
		System.out.println("Bienvenu dans le mode défense le but du jeu est simple ");
		System.out.println("vous devez déclarer un chiffre aléatoire que je dois trouver puis m'indiquer si c'est plus, moin ou égal");
		System.out.println("au nombre que j'aurais indiqué.");
		System.out.println("");// je fais un saut de ligne (plus lisible)
		System.out.println("déffinissez "+ config.chiffreCombi()+" chiffres aléatoire puis Appuiyez sur Entrer.");
		 
		p.recuperelecodeEnInteger();
		logger.debug("Avant // Appelle la méthode calcul du mode défense");
		
		logger.debug("Après // reçois la méthode calcul du mode défense");
		// ici j'affiche le nombre aléatoire que l'ordinateur donne.
		
		
		System.out.println("Je vous propose : " + mc.affichelecodeComputerModeDefense());
		
		
		
		int tour = 0;// ici je déclare que le tour est a zéro.
		for (;tour < config.essais(); tour++){// dans cette boucle je met un ; au début sinon j'ai une erreur, cette boucle doit être faite 5 fois.
		
			ArrayList<String> propoClientAndChiffreOrdinateur;
			propoClientAndChiffreOrdinateur = mc.calculModeDefense();
			logger.info("reçois une nouvelle fois la méthode calcul du mode défense");
			
		
			if(propoClientAndChiffreOrdinateur.get(2).equals(propoClientAndChiffreOrdinateur.get(0))) {// je rajoute le toString pour qu'il transforme le stringbuilder en string
				
				System.out.println("");
				System.out.println("j'ai gagné les machines sont plus fortes fin de la partie.");
				break;// ici il sort de la boucle pour éviter qu'il refasse un tour de boucle.
			
			}
		
		// ici je met ma réponse.
		System.out.println("Peut être ceci : "+ propoClientAndChiffreOrdinateur.get(1));
		System.out.println("");
	
		
		
		}	
		
		// ici je fais une condition après la boucle ou je dit que si ma variable tour est égal a 5 j'affiche la fin de partie et je déclare que l'ordinateur a perdu.
		if(tour == config.essais()) {
			System.out.println("");
			System.out.println("fin de la partie j'ai perdu, les humains sont plus fort.");
			
		
		}
		
		logger.info("fin du mode défense");
	}
	
	// ici j'affiche le code Computer me servira pour le mode développeur.
	


}
