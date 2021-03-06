package fr.gameplaystudio.escapegame;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class ModeDuel {
	
	Computer c = new Computer();// j'appelle la classe computer pour avoir toutes les informations du computer
	Player p = new Player();// j'appelle la classe player pour avoir toutes les informations du player


	Configuration config = new Configuration();// j'appelle la classe config  ou il y a tous mes fichiers de configuration
	ModeCalcul mc = new ModeCalcul();
	ArrayList<Integer> chiffreOrdinateur = c.randomNumberComputer();// ici je mets les chiffres aléatoires du computer dans une ArrayList.

	final static Logger logger = Logger.getLogger(ModeDuel.class);
	
	public void reponseModeDuel() { 
		
		logger.info("Rentre dans la méthode d'envoi de la réponse mode duel");
		
		if(config.modeDeveloppeur() != false) {
			logger.info("Avant //l'affichage du code secret du mode attaque");
			System.out.println("");
			System.out.println("Mode développeur activé (Combinaison secrète : "+ mc.affichelecodeComputerModeAttack()+")");
			logger.info("Après //reçois l'affichage du code secret du mode attaque");
		}
		System.out.println("");
		System.out.println("Bienvenue dans le mode Duel, nous allons nous affronter tour par tour,");
		System.out.println("celui qui trouve le numéro de l'autre à gagné");
		System.out.println("");
		System.out.println("Veuillez entrer "+config.chiffreCombi()+" chiffres aléatoires.");
		
		p.recuperelecodeEnInteger();// ici je demande à ce que l'utilisateur tape son code pas besoin de le mettre dans une variable seul l'utilisateur doit connaître cette information
		
		System.out.println("");
		
		System.out.println("A mon tour de rentrer un chiffre aléatoire.");
		
		System.out.println("");
		
			
		System.out.println("Je vous propose de commencer vous devez taper "+ config.chiffreCombi()+" chiffres puis appuyer sur entrer.");
		boolean Gagner = false;// ici je fais un boolean qui me servira pour ma boucle.
		
		
		
		
		while(Gagner != true) {// tant que la boucle n'est pas égale a true elle ne s'arrête pas
		
		logger.info("Avant // Appelle la méthode calcul du mode attaque");
		ArrayList<String> propositionAndResult = mc.calculModeAttack();
		logger.info("Après // reçois la méthode calcul du mode attaque");
		
		System.out.println("");
		// ici j'affiche le résultat.
		System.out.println("Proposition  : "+ propositionAndResult.get(0) + " -> Résultat : " + propositionAndResult.get(1));
		
		StringBuilder egal = new StringBuilder();// j'utilise stringbuilder pour comparer 2 résultats pour la condition juste en dessous
		

		for(int i = 0; i< config.chiffreCombi();i++)// je fais une boucle pour éviter de répéter
		{
		   
			egal.append("=");// j'ajoute "=" à mon stringbuilder 
		    
		}
		
		// ici je fais une condition au cas où l'utilisateur gagne.	
		if(egal.toString().equals(propositionAndResult.get(1).toString())) {// je rajoute le toString pour qu'il transforme le stringbuilder en string
			Gagner = true;
			System.out.println("Vous avez gagné les humains sont plus forts.");
			break;
			
		}
		
		
		System.out.println("");
		
		logger.info("reçois l'affichage du code du mode défense (random Ordinateur)");
		System.out.println("A mon tour je propose -> : " + mc.affichelecodeComputerModeDefense());
		
		
		System.out.println("Pour chaque chiffre indiquez moi si c'est + , - ou =.");
		
		logger.debug("Avant // Appelle la méthode calcul du mode défense");
		ArrayList<String> propoClientAndChiffreOrdinateur = mc.calculModeDefense();
		String propoChiffreClient = propoClientAndChiffreOrdinateur.get(0);
		logger.debug("Après // reçois la méthode calcul du mode défense");
		
		// ici je fais une condition pour dire que si tout est "=" l'ordinateur a gagné
			if(egal.toString().equals(propoChiffreClient)) {// je rajoute le toString pour qu'il transforme le stringbuilder en string
				
				System.out.println("j'ai gagné les machines sont plus fortes.");
				System.out.println("La réponse était : "+ mc.affichelecodeComputerModeAttack());
				logger.info("reçois l'affichage du code secret du mode attaque");
				Gagner = true;
				break;
			
			}
			System.out.println("");
			System.out.println("A votre tour taper "+ config.chiffreCombi() +" chiffres puis appuyer sur entrer.");
	
	
	
		}
		
		System.out.println("fin de la partie");
		logger.info("fin du mode duel");
	}
	

}
