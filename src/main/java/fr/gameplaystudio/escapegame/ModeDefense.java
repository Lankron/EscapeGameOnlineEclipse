package fr.gameplaystudio.escapegame;

import java.util.ArrayList;

import org.apache.log4j.Logger;


public class ModeDefense {

	
	
	Computer c = new Computer();// j'appelle la classe computer pour avoir toutes les informations du computer
	Player p = new Player();// j'appelle la classe player pour avoir toutes les informations du player

	Configuration config = new Configuration();// j'appelle la classe config là ou il y a tous les fichiers de configuration
	ModeCalcul mc = new ModeCalcul();
	final static Logger logger = Logger.getLogger(ModeDefense.class);
	  
	
	



	
	public void reponseModeDefense() {// ici c'est la méthode pour calculer et envoyer la réponse du mode défense
		logger.info("rentre dans la méthode d'envoi de la réponse du mode défense");
		System.out.println("");
		System.out.println("Bienvenue dans le mode défense le but du jeu est simple ");
		System.out.println("vous devez déclarer un chiffre aléatoire que je dois trouver ");
		System.out.println("puis m'indiquer si c'est plus, moins ou égal");
		System.out.println("(sous forme de \"+-=\" )");
		System.out.println("au nombre que j'aurais indiqué.");
		System.out.println("");// je fais un saut de ligne (plus lisible)
		System.out.println("définissez "+ config.chiffreCombi()+" chiffres aléatoires puis Appuyez sur Entrer.");
		 
		
		logger.debug("Avant // Appelle la méthode calcul du mode défense");
		ArrayList<Integer> propoChiffreClient =	p.recuperelecodeEnInteger();
		StringBuilder propoChiffreClientEnString = new StringBuilder();
		for(int i=0; i < config.chiffreCombi(); i++) {
			propoChiffreClientEnString.append(propoChiffreClient.get(i));
		}
		logger.debug("Après // reçois la méthode calcul du mode défense");
		// ici j'affiche le nombre aléatoire que l'ordinateur donne.
		
		System.out.println("");
		System.out.println("Je vous propose : " + mc.affichelecodeComputerModeDefense());
		
		int tour = 0;// ici je déclare que le tour est a zéro.
		for (;tour < config.essais(); tour++){// dans cette boucle je mets un ; au début sinon j'ai une erreur, cette boucle doit être faite 5 fois.
		
			System.out.println("Pour chaque chiffre indiquez moi si c'est + , - ou =.");
			ArrayList<String> propoClientAndChiffreOrdinateur = mc.calculModeDefense();
			
		

			logger.info("reçois une nouvelle fois la méthode calcul du mode défense");
			
		
			if(propoClientAndChiffreOrdinateur.get(0).equals(propoClientAndChiffreOrdinateur.get(2)) || propoChiffreClientEnString.toString().equals(propoClientAndChiffreOrdinateur.get(1))) {// je rajoute le toString pour qu'il transforme le stringbuilder en string
				
				System.out.println("");
				System.out.println("j'ai gagné les machines sont plus fortes fin de la partie.");
				break;// ici il sort de la boucle pour éviter qu'il refasse un tour de boucle.
			
			}
		
		// ici je mets ma réponse.
		System.out.println("");
		System.out.println("Peut être ceci : "+ propoClientAndChiffreOrdinateur.get(1));
		
	
		
		
		}	
		
		// ici je fais une condition après la boucle ou je dis que si ma variable tour est égal à 5 j'affiche la fin de partie et je déclare que l'ordinateur a perdu.
		if(tour == config.essais()) {
			System.out.println("");
			System.out.println("fin de la partie j'ai perdu, les humains sont plus forts.");
			
		
		}
		
		logger.info("fin du mode défense");
	}
	
	// ici j'affiche le code Computer me servira pour le mode développeur.
	


}
