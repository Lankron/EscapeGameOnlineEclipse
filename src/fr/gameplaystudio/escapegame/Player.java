package fr.gameplaystudio.escapegame;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Player {

	Configuration config = new Configuration();// j'appel la class config la ou y'a tous mes fichiers de configuration
	private Scanner sc;
	final static Logger logger = Logger.getLogger(Player.class);
	
	public ArrayList<Integer>  recuperelecodeEnInteger() {
		logger.info("rentre dans la méthode de récupération du code en integer class player");
		String nb = null;
		ArrayList<Integer> chiffre1 = new ArrayList<Integer>();
	    ArrayList<Integer> chiffreClient = new ArrayList<Integer>(); 
		
	    boolean notEnoughNumber = true;// je fais un boolean pour m'en servir dans une boucle pour savoir si l'utilisateur a tapé assez de chiffre
	    while(notEnoughNumber == true) {// la boucle continue tant que la personne n'a pas tapé assez de chiffre
			
	
	    try {// je test et gère les exceptions grace a un try catch
	    
	    boolean isNotNumber = true;	// ce boolean me servira à tester si c'est un nombre et non une chaine de caractère
	    
	    while(isNotNumber == true) {// ici je fais une boucle tant que la personne n'a pas renter un nombre
		sc = new Scanner(System.in);// j'appel scanner pour que l'utilisateur puisse taper
        nb = sc.nextLine();// ici je récupère ça en string
        
      
        
        try {
			@SuppressWarnings("unused")
			int numSms = Integer.parseInt(nb);// je parseint pour voir si c'est une lettre ou un chiffre.
			isNotNumber = false;// si c'est un chiffre la boucle s'arrête parce que le boolean passe en false.
		} catch (NumberFormatException e){// je gère mon exception ici elle vient quand l'utilsateur ne tape pas un chiffre
			System.out.println("Vous n'avez pas tapé des chiffres.");
			System.out.println("Veuillez réessayer taper " + config.chiffreCombi()+ " chiffres puis appuiyez sur entrer");
		}
        }
       
        for(int i = 0; i < config.chiffreCombi(); i++) {// ici je fais une boucle pour ajouter dans mon tableau d'arraylist les X chiffre a récupérer (en char) ( en fonction de mon chiffre de combinaison) et j'ajoute aussi dans un autre arraylist les char que j'ai transformer en Entier
        	try {
        		chiffre1.add((int) nb.charAt(i));
        		chiffreClient.add(Character.getNumericValue(chiffre1.get(i)));
        		
        	
        	}catch(java.lang.StringIndexOutOfBoundsException e) {// cette erreur signifie qu'il manque des caractères a mettre dans le tableau
        		logger.error("nombre de char inssufisant");
        	} 
        }
       
        if(chiffre1.size() != config.chiffreCombi() && chiffreClient.size() != config.chiffreCombi()) {// si la taille du tableau de chiffre 1 et chiffreClient est différent de l'entier donnés par la configuration alors les tableaux d'arraylist vont être effacé et il sera demandé à l'utilisateur de remettre X chiffres.
        	chiffre1.clear();// l'arraylist chiffre1 est vidé de ces éléments
        	chiffreClient.clear();//l'arraylist chiffreClient est vidé de ces éléments
        	System.out.println("Vous n'avez pas tapé " + config.chiffreCombi()+" chiffres !!");
        	System.out.println("Veuillez réessayer taper " + config.chiffreCombi()+ " chiffres puis appuiyez sur entrer");
        }
       
        if(chiffre1.size() == config.chiffreCombi() && chiffreClient.size() == config.chiffreCombi()) {//si la taille du tableau de chiffre 1 et chiffreClient est égal à l'entier donnés par la configuration alors la boucle s'arrête
        	
        	notEnoughNumber = false;// noEnoughNumber devient false pour que l'a boucle s'arrête
        	
        }
		}catch(java.util.InputMismatchException e) {// cette exception ce passe quand il y'a une erreur lors de la saisi
			
			logger.error("il y'a une erreur au niveau de la saisi");
			
			
			}
		}
       
	    logger.info("sort de la méthode de récupération du code en integer class player");
		return chiffreClient;// je retourne mon ArrayList d'entier
		
	}
	
	public ArrayList<String>  recuperelecodeEnString() {
		logger.info("rentre dans la méthode de récupération du code en String class player");
		String propoClient = null;
		ArrayList<Character> propositionClient = new ArrayList<Character>();
	    ArrayList<String> mot = new ArrayList<String>();
	   
	    boolean notEnoughNumber = true;// je fais un boolean pour m'en servir dans une boucle pour savoir si l'utilisateur a tapé assez de caractère
	    while(notEnoughNumber == true) {// la boucle continue tant que la personne n'a pas tapé assez de caractère
	   
	    	try {
	    
	    	
	    boolean isNotString = true;	// ce boolean me servira à tester si c'est un caractère et non un chiffre
	 	    
	 	while(isNotString == true) {// ici je fais une boucle tant que la personne n'a pas renter un caractère
	    
	 	sc = new Scanner(System.in);
	    propoClient = sc.nextLine();
	    
	  
	    
	    try {
			@SuppressWarnings("unused")// ici je supprime l'erreur Warning
			int numSms = Integer.parseInt(propoClient);// je parseint pour voir si c'est une lettre ou un chiffre.
			System.out.println("Vous n'avez pas tapé =, + ou -.");// ici j'indique qu'il n'a pas tapé les bonnes chaines de caractère
			System.out.println("Veuillez réessayer taper " + config.chiffreCombi()+ " un vrai résultat puis appuiyez sur entrer");
		} catch (NumberFormatException e){// je gère mon exception ici elle vient quand l'utilsateur ne tape pas un chiffre
			isNotString = false;// si il a pas tapé un chiffre la boucle s'arrête
		}
	 	}
	 	
      
	 	
	 	for(int i = 0; i < config.chiffreCombi(); i++) {// ici je fais une boucle en fonction du nombre donnée dans le chiffre de la configuration.properties (chiffre de la combinaison)
      
	 		
	 		
	 	try {
        	
        		propositionClient.add(propoClient.charAt(i));// ici j'ajoute en char dans mon arraylist les X chiffre a récupérer ( en fonction du nombre donnée dans le chiffre de la configuration.properties (chiffre de la combinaison)).
        		
            	mot.add(Character.toString((char) propositionClient.get(i)));// ici je transforme mes char en String et je les ajotues dans mon arrayList "mot".
            	
        		
            		
            	
        }catch(java.lang.StringIndexOutOfBoundsException e) {// ici je gère le fait qu'il n'y a pas assez de caractère.
    		
        	logger.error("nombre de char inssufisant");
    	
        
        }catch(java.lang.IndexOutOfBoundsException e) {// je gère une exception 
        	
        }
	      
	 	
	 	
	 	try {
	        	
	        	if("=".equals(mot.get(i)) || "-".equals(mot.get(i)) || "+".equals(mot.get(i))) {// je fais une condition si "=" ou "-" ou "+" est égal a toute mes positions du ArrayList je ne fais rien sinon je clear mon arrayList
	        		
	            	
	            
	        	}else {
	        			
	            propositionClient.clear();// ici je supprime tous les éléments de mon ArrayList (clear)
	            mot.clear();// ici je supprime tous les éléments de mon arraylist (clear)
	        			
	        	}
	            
	        
	        }catch(java.lang.IndexOutOfBoundsException e) {
        	
	        }
        
        
	    }
        
        
        
        if(propositionClient.size() != config.chiffreCombi() && mot.size() != config.chiffreCombi()) {// si la taille de l'arrayList porpositionClient et mot est différent de l'entier donnés par la configuration alors les tableaux d'arraylist vont être effacé et il sera demandé à l'utilisateur de remettre X résultat dans le format "+","-","=".
        	propositionClient.clear();// ici je supprime tous les éléments de mon ArrayList
        	mot.clear();// ici je supprime tous les éléments de mon ArrayList
        	System.out.println("Vous n'avez pas taper " + config.chiffreCombi()+" résultat!!");// ici j'avertis l'utilisateur qu'il n'a pas tapé des résultats.
        	System.out.println("Veuillez réessayer taper " + config.chiffreCombi()+ " résultat puis appuiyez sur entrer");
        }
        
        if(propositionClient.size() == config.chiffreCombi() && mot.size() == config.chiffreCombi()) {//si la taille l'arrayList porpositionClient et mot  est égal à l'entier donnés par la configuration alors la boucle s'arrête
        	
        	notEnoughNumber = false;// ici notEnoughNumber passe en false
        	
        }
		}catch(java.util.InputMismatchException e) {
			
			logger.error("il y'a une erreur au niveau de la saisi");
			
			
		}
	    }
	    
	    logger.info("sort de la méthode de récupération du code en String class player");
		
		return mot;// ici je retourne mon ArrayList Mot
		
	}

}
