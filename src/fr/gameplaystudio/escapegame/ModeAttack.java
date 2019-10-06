package fr.gameplaystudio.escapegame;


import java.util.ArrayList;

import org.apache.log4j.Logger;

//import org.apache.log4j.Logger;


public class ModeAttack {

	Computer c = new Computer();// j'appel la class computer pour avoir toute les informations du computer
	Player p = new Player();// j'appel la class player pour avoir toute les informations du player
	Configuration config = new Configuration();// j'appel la class config la ou y'a tous mes fichiers de configuration
	ModeCalcul mc = new ModeCalcul();
	final static Logger logger = Logger.getLogger(ModeAttack.class);
 
	//private Logger log = Logger.getLogger(ModeAttack.class); 
	
	
	public void reponseModeAttack(){// ici c'est ma méthode pour calculer et envoyer la réponse du mode Attack
		logger.info("rentre dans la méthode  d'envoie de la réponse du mode attaque");
		if(config.modeDeveloppeur() != false) {
			System.out.println("Mode développeur activé (Combinaison secrète : " + mc.affichelecodeComputerModeAttack() + ")");
		}
		
		
		
		
		int tour = 0;
		
		System.out.println("Bienvenu sur le jeu d'attaque,");
		System.out.println("je pense a un chiffre et vous devez deviner quel est ce chiffre et je vous donnerez une réponse exemple\\\"+-=+\\\"");
		System.out.println("si c'est + vous devez mettre un chiffre plus grand,");
		System.out.println("si c'est - vous devez mettre un chiffre plus petit,");
		System.out.println("si c'est = le chiffre est bon.");
		System.out.println("");
		System.out.println("Vous pouvez commencer en me donnant " + config.chiffreCombi() +" chiffres aléatoire de 0 à 9 puis appuiyez sur entrer pour valider votre réponse.");
		
		System.out.println("Veuillez taper une réponse");
		for(int countorder = 0; countorder < config.essais(); countorder++) {// ici je fais ma boucle pour limité le nombre d'essais.
			System.out.println("");
			
			
			
		logger.debug("Avant // Appelle la méthode calcul du mode attaque");
		ArrayList<String> test = mc.calculModeAttack();
		logger.debug("Après // reçois la méthode calcul du mode attaque");
		
		// ici j'affiche le résultat.
		System.out.println("Proposition : "+test.get(0)+" -> Reponse : " + test.get(1));
		
		
		StringBuilder egal = new StringBuilder();// j'utiliste stringbuilder pour comparer 2 résultats pour la condition juste en dessous
		

		for(int i = 0; i< config.chiffreCombi();i++)// je fais une boucle pour éviter de me répéter
		{
		   
			egal.append("=");// j'ajoute "=" a mon stringbuilder 
		    
		}
		
	
		// ici je fais une condition au cas ou l'utilisateur gagne.
	
		if(egal.toString().equals(test.get(1))) {// je rajoute le toString pour qu'il transforme le stringbuilder en string
				System.out.println("fin du jeu vous avez gagné");
				break;// je fais un break pour sortir de la boucle plus tôt sinon il relance la boucle.
			
			
		}
		
		
		
		
		
		System.out.println("Veuillez taper une nouvelle réponse");
		tour++;
		}
		

			// ici je fais une condition au cas ou l'utilisateur perd.
			if(tour == config.essais()) {
				
				System.out.println("Vous avez perdu la réponse était : " + mc.affichelecodeComputerModeAttack());
				
			}
		
		
		
		logger.info("fin du mode attaque");
		
		
		
		
		
		}
	
	
	// ici j'affiche le code Computer me servira pour le mode développeur.
	/*public String affichelecodeComputer(){
	
		
		 StringBuilder chiffreOrdinateurEnstring = new StringBuilder();// j'utiliste stringbuilder pour afficher mes integer
		

		for(int i = 0; i< config.chiffreCombi();i++)// je fais une boucle pour éviter de me répéter
		{
		   
			chiffreOrdinateurEnstring.append(chiffreOrdinateur.get(i));// j'ajoute le chiffre de l'ordinateur a mon stringbuilder
		    
		    
		}
		return "(Combinaison secrète : "+ chiffreOrdinateurEnstring +").";
		
		
	}*/
	
}
