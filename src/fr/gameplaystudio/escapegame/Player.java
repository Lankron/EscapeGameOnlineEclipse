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
		
        
        boolean isNan = true;// je déclare mon booléan en false il me servira a savoir si ma saisi est un chiffre ou non
        boolean isNotCorrect = true;// je déclare mon booléan en false il me servira a savoir si ma saisi est inférieur a mon chiffre de combinaison
        
       
        
        while(isNotCorrect == true) {// ici je fais une boucle tant que variable est true
        	 
        	 
        try {
        
        	
        while(isNan == true ) {  // ici je fais une boucle tant que ma saisi n'est pas un nombre
		        sc = new Scanner(System.in);
		        nb = sc.nextLine();
		        try {		 
						Integer.parseInt(nb);// ici je teste si ma saisi est un nombre
						isNan = false;// ici je déclare que si c'est un nombre isNan passe en false donc la boucle s'arrête
			        		
			        
		        }
		        
		    	catch (NumberFormatException e){// ici j'ai une exception quand la saisi n'est pas un nombre
					
		    		System.out.println("Vous n'avez pas tapé " + config.chiffreCombi() + " chiffres");// ici je déclare a l'utilisateur qu'il n'a pas écrit un nombre
					System.out.println("Veuillez réessayer en tapant " + config.chiffreCombi() + " chiffres");
				}
         }
         
        
        }
		catch(java.util.InputMismatchException e) {// ici je gere une exception
		
		logger.error("il y'a une erreur au niveau de la saisi");
		
		
		}
       
		
		
        for(int i = 0; i < config.chiffreCombi(); i++) {// ici je fais une boucle pour éviter de me répéter
        	try {
        	
        			chiffre1.add((int) nb.charAt(i));// ici je récupère les caractères par rapport au chiffre de combinaison grace a charAt  
            		chiffreClient.add(Character.getNumericValue(chiffre1.get(i)));	// je transforme mes caractères en integer
        		
                
        	}catch(java.lang.StringIndexOutOfBoundsException e) {// ici je gère une exception.
        		logger.error("nombre de char inssufisant");
        	} 
        	catch(java.lang.IndexOutOfBoundsException e) {// ici je gère une exception.
        		
        	}
        	
        	
        }
       
        if(chiffre1.size() == config.chiffreCombi() && chiffreClient.size() == config.chiffreCombi()) {// si la taille de mon arrayList est la même que mon chiffre de combinaison j'arrête la boucle 
        	
        	isNotCorrect = false;// je le met en false vue que j'ai tapé le bon nombre de chiffre.
        }
		
        if(chiffre1.size() != config.chiffreCombi() && chiffreClient.size() != config.chiffreCombi()) {// si la taille de mon arrayList est différent de mon chifre de combinaison je continue la boucle
			
        	System.out.println("Vous n'avez pas tapé " + config.chiffreCombi() + " chiffres");
			System.out.println("Veuillez réessayer en tapant " + config.chiffreCombi() + " chiffres");
			chiffre1.clear();// j'éfface tous les éléments de l'arraylist chiffre1 pour avoir de nouveau éléments
			chiffreClient.clear();// j'éfface tous les éléments de l'arraylist chiffreClient pour avoir de nouveau éléments
			isNan = true;// je redéclare isnan true pour activer la boucle et vérifier si c'est un chiffre entier
        }
       
        
        }
         
        
        logger.info("sort de la méthode de récupération du code en integer class player");
		
		return chiffreClient;// je retourne mon arraylist chiffreClient
		
	}
	
	public ArrayList<String>  recuperelecodeEnString() {
		
		
		logger.info("rentre dans la méthode de récupération du code en String class player");
		String propoClient = null;
		
		ArrayList<Character> propositionClient = new ArrayList<Character>();
        ArrayList<String> mot = new ArrayList<String>();
		boolean isString = false;// je déclare mon booléan en false il me servira a savoir si ma saisi est un String ou non
	    boolean isNotCorrect = true;// je déclare mon booléan en false il me servira a savoir si ma saisi est inférieur a mon chiffre de combinaison
	    
	    
	    while(isNotCorrect == true) {// ici je fais une boucle tant que variable est true
	    	
	  
		try {
		

        
        while(isString == false ) {  // ici je fais une boucle tant que ma saisi n'est pas un String
        	sc = new Scanner(System.in);
	        propoClient = sc.nextLine();
	        try {		 
					Integer.parseInt(propoClient);// ici je teste si ma saisi est un nombre si elle ne l'est pas j'ai une l'exception suivante NumberFormatException que je gère avec un try catch.
					System.out.println("Vous n'avez pas tapé " + config.chiffreCombi() + " résultats");// je lui déclare qu'il n'a pas tapé X résultats.
					System.out.println("Veuillez réessayer en tapant " + config.chiffreCombi() + " résultats");
					
		        		
		        
	        }catch (NumberFormatException e){
	    		isString = true;// si j'ai l'exception c'est que j'ai autre chose qu'un entier ( une string ) je peux donc  arrêter ma boucle
	    		
	    		
	    	}
        	
        }
        
		}catch(java.util.InputMismatchException e) {// je gère une exception
			
			logger.error("il y'a une erreur au niveau de la saisi");
			
			
		}
        
		
        for(int i = 0; i < config.chiffreCombi(); i++) {// ici je fais une boucle pour éviter de me répéter
		        try {
		        	propositionClient.add(propoClient.charAt(i));// ici je récupère les caractères par rapport au chiffre de combinaison grace a charAt  
		        	mot.add(Character.toString((char) propositionClient.get(i)));// je transforme mes caractères en String
		        }catch(java.lang.StringIndexOutOfBoundsException e) {
		    		logger.error("nombre de char inssufisant");
		    	} 
		    	catch(java.lang.IndexOutOfBoundsException e) {
		    		
		    	}
		        	
		}
       
        
        try {
        	
        	for(int i = 0; i < config.chiffreCombi(); i++) {// ici je fais une boucle pour éviter de me répéter
                
                if("+".equals(mot.get(i)) || "-".equals(mot.get(i))|| "=".equals(mot.get(i))) {// si il y'a un =,+ou- dans mon arraylist tu ne fais rien sinon tu clear les arrayList
            		
            	}
                else {
            		propositionClient.clear();// ici j'éfface tous les éléments de l'arraylist propositionClient 
            		mot.clear();// ici j'éfface tous les éléments de l'arraylist mot 
            }
        }  
        }catch(java.lang.StringIndexOutOfBoundsException e) {
    		logger.error("nombre de char inssufisant");
    	} 
    	catch(java.lang.IndexOutOfBoundsException e) {
    		
    	}
        
        
        
        if(propositionClient.size() == config.chiffreCombi() && mot.size() == config.chiffreCombi()) {// si la taille de mon arrayList est la même que mon chiffre de combinaison j'arrête la boucle 
        	
        	isNotCorrect = false;// je le met en false vue que j'ai tapé le bon nombre de chiffre.
        }
		
        if(propositionClient.size() != config.chiffreCombi() && mot.size() != config.chiffreCombi()) {// si la taille de mon arrayList est différent de mon chifre de combinaison je continue la boucle
			
        	System.out.println("Vous n'avez pas tapé " + config.chiffreCombi() + " résultat");
			System.out.println("Veuillez réessayer en tapant " + config.chiffreCombi() + " résultat");
			propositionClient.clear();// j'éfface tous les éléments de l'arraylist propositionClient pour avoir de nouveau éléments
			mot.clear();// j'éfface tous les éléments de l'arraylist mot pour avoir de nouveau éléments
			isString = false;// je redéclare isnan true pour activer la boucle et vérifier si c'est un chiffre entier
        }
	    
	    
	    }
	    
	    
        logger.info("sort de la méthode de récupération du code en String class player");
		
		return mot;// je retourne mon arraylist mot
		
	}

}
