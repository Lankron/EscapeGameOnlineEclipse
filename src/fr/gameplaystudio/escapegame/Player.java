package fr.gameplaystudio.escapegame;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Player {

	Configuration config = new Configuration();// j'appelle la classe config où il y a tous les fichiers de configuration
	private Scanner sc;
	final static Logger logger = Logger.getLogger(Player.class);
	
	public ArrayList<Integer>  recuperelecodeEnInteger() {
		logger.info("rentre dans la méthode de récupération du code en integer class player");
		String nb = null;
		ArrayList<Integer> chiffre1 = new ArrayList<Integer>();
        ArrayList<Integer> chiffreClient = new ArrayList<Integer>(); 
		
        
        boolean isNan = true;// je déclare mon booléan en false il me servira à savoir si ma saisie est un chiffre ou non
        boolean isNotCorrect = true;// je déclare mon boolean en false il me servira à savoir si ma saisie est inférieure à mon chiffre de combinaison
        
       
        
        while(isNotCorrect == true) {// ici je fais une boucle tant que variable est true
        	 
        	 
        try {
        
        	
        while(isNan == true ) {  // ici je fais une boucle tant que ma saisie n'est pas un nombre
		        sc = new Scanner(System.in);
		        nb = sc.nextLine();
		        try {		 
						Integer.parseInt(nb);// ici je teste si ma saisie est un nombre
						isNan = false;// ici je déclare que si c'est un nombre isNan passe en false donc la boucle s'arrête
			        		
			        
		        }
		        
		    	catch (NumberFormatException e){// ici j'ai une exception quand la saisie n'est pas un nombre
					System.out.println("");
		    		System.out.println("Vous n'avez pas tapé " + config.chiffreCombi() + " chiffres");// ici je déclare à l'utilisateur qu'il n'a pas écris un nombre
					System.out.println("Veuillez réessayer en tapant " + config.chiffreCombi() + " chiffres");
					
				}
         }
         
        
        }
		catch(java.util.InputMismatchException e) {// ici je gère une exception
		
		logger.error("il y a une erreur au niveau de la saisie");
		
		
		}
       
		
		
        for(int i = 0; i < config.chiffreCombi(); i++) {// ici je fais une boucle pour éviter de me répéter
        	try {
        	
        			chiffre1.add((int) nb.charAt(i));// ici je récupère les caractères par rapport au chiffre de combinaison grâce a charAt  
            		chiffreClient.add(Character.getNumericValue(chiffre1.get(i)));	// je transforme les caractères en integer
        		
                
        	}catch(java.lang.StringIndexOutOfBoundsException e) {// ici je gère une exception.
        		logger.error("nombre de char inssufisant");
        	} 
        	catch(java.lang.IndexOutOfBoundsException e) {// ici je gère une exception.
        		
        	}
        	
        	
        }
       
        if(chiffre1.size() == config.chiffreCombi() && chiffreClient.size() == config.chiffreCombi()) {// si la taille de mon ArrayList est la même que mon chiffre de combinaison j'arrête la boucle 
        	
        	isNotCorrect = false;// je le mets en false vu que j'ai tapé le bon nombre de chiffre.
        }
		
        if(chiffre1.size() != config.chiffreCombi() && chiffreClient.size() != config.chiffreCombi()) {// si la taille de mon ArrayList est différent de mon chifre de combinaison je continue la boucle
        	System.out.println("");
        	System.out.println("Vous n'avez pas tapé " + config.chiffreCombi() + " chiffres");
			System.out.println("Veuillez réessayer en tapant " + config.chiffreCombi() + " chiffres");
		
			chiffre1.clear();// j'efface tous les éléments de l'ArrayList chiffre1 pour avoir de nouveaux éléments
			chiffreClient.clear();// j'éfface tous les éléments de l'arraylist chiffreClient pour avoir de nouveaux éléments
			isNan = true;// je redéclare isNan true pour activer la boucle et vérifier si c'est un chiffre entier
        }
       
        
        }
         
        
        logger.info("sort de la méthode de récupération du code en integer class player");
		
		return chiffreClient;// je retourne mon ArrayList chiffreClient
		
	}
	
	public ArrayList<String>  recuperelecodeEnString() {
		
		
		logger.info("rentre dans la méthode de récupération du code en String class player");
		String propoClient = null;
		
		ArrayList<Character> propositionClient = new ArrayList<Character>();
        ArrayList<String> mot = new ArrayList<String>();
		boolean isString = false;// je déclare mon booléan en false il me servira aàsavoir si ma saisie est un String ou non
	    boolean isNotCorrect = true;// je déclare mon boolean en false il me servira à savoir si ma saisie est inférieure à mon chiffre de combinaison
	    
	    
	    while(isNotCorrect == true) {// ici je fais une boucle tant que variable est true
	    	
	  
		try {
		

        
        while(isString == false ) {  // ici je fais une boucle tant que ma saisie n'est pas un String
        	sc = new Scanner(System.in);
	        propoClient = sc.nextLine();
	        try {		 
					Integer.parseInt(propoClient);// ici je teste si ma saisie est un nombre si elle ne l'est pas j'ai eu l'exception suivante NumberFormatException que je gère avec un try catch.
					System.out.println("");
					System.out.println("Vous n'avez pas tapé " + config.chiffreCombi() + " résultats sous forme de +, - ou =");// je lui déclare qu'il n'a pas tapé X résultats.
					System.out.println("Veuillez réessayer en tapant " + config.chiffreCombi() + " résultats sous forme de +, - ou =");
					
		        		
		        
	        }catch (NumberFormatException e){
	    		isString = true;// si j'ai l'exception c'est que j'ai autre chose qu'un entier ( une string ) je peux donc arrêter ma boucle
	    		
	    		
	    	}
        	
        }
        
		}catch(java.util.InputMismatchException e) {// je gère une exception
			
			logger.error("il y'a une erreur au niveau de la saisie");
			
			
		}
        
		
        for(int i = 0; i < config.chiffreCombi(); i++) {// ici je fais une boucle pour éviter de me répéter
		        try {
		        	propositionClient.add(propoClient.charAt(i));// ici je récupère les caractères par rapport au chiffre de combinaison grâce à charAt  
		        	mot.add(Character.toString((char) propositionClient.get(i)));// je transforme les caractères en String
		        }catch(java.lang.StringIndexOutOfBoundsException e) {
		    		logger.error("nombre de char insuffisants");
		    	} 
		    	catch(java.lang.IndexOutOfBoundsException e) {
		    		
		    	}
		        	
		}
       
        
        try {
        	
        	for(int i = 0; i < config.chiffreCombi(); i++) {// ici je fais une boucle pour éviter de me répéter
                
                if("+".equals(mot.get(i)) || "-".equals(mot.get(i))|| "=".equals(mot.get(i))) {// s'il ya un =,+ou- dans mon ArrayList tu ne fais rien sinon tu clear les ArrayLists
            		
            	}
                else {
            		propositionClient.clear();// ici j'efface tous les éléments de l'ArrayList propositionClient 
            		mot.clear();// ici j'efface tous les éléments de l'ArrayList mot
            }
        }  
        }catch(java.lang.StringIndexOutOfBoundsException e) {
    		logger.error("nombre de char insuffisant");
    	} 
    	catch(java.lang.IndexOutOfBoundsException e) {
    		
    	}
        
        
        
        if(propositionClient.size() == config.chiffreCombi() && mot.size() == config.chiffreCombi()) {// si la taille de mon arrayList est la même que mon chiffre de combinaison j'arrête la boucle 
        	
        	isNotCorrect = false;// je le mets en false vu que j'ai tapé le bon nombre de chiffres.
        }
		
        if(propositionClient.size() != config.chiffreCombi() && mot.size() != config.chiffreCombi()) {// si la taille de mon ArrayList est différent de mon chiffre de combinaison je continue la boucle
        	System.out.println("");
        	System.out.println("Vous n'avez pas tapé " + config.chiffreCombi() + " résultat");
			System.out.println("Veuillez réessayer en tapant " + config.chiffreCombi() + " résultat");
			
			propositionClient.clear();// j'efface tous les éléments de l'Arraylist propositionClient pour avoir de nouveaux éléments
			mot.clear();// j'efface tous les éléments de l'ArrayList mot pour avoir de nouveaux éléments
			isString = false;// je redéclare isNan true pour activer la boucle et vérifier si c'est un chiffre entier
        }
	    
	    
	    }
	    
	    
        logger.info("sort de la méthode de récupération du code en String class player");
		
		return mot;// je retourne mon ArrayList mot
		
	}

}
