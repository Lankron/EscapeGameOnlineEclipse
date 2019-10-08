package fr.gameplaystudio.escapegame;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;



public class Configuration {

	
	

	final static Logger logger = Logger.getLogger(Configuration.class);
	final static Properties prop = new Properties();

	
	


	public static void loadProperties(String chemin){// avec cette méthode je charge les propriétés et je fais une vérification
	
		
	
		//System.out.println(Main.chemin);
		
		try {// ici je fais un test
			InputStream input = new FileInputStream(chemin);// ici je reçois la variable de la classe Main à l'intérieur il a un argument.
			prop.load(input);
		
			
		} catch (FileNotFoundException e) {// si le fichier n'est pas trouvé il y a une erreur.
			e.printStackTrace();
			logger.error("fichier non trouvé.");
		} catch (IOException e) {// si le fichier n'est pas chargé il y a une erreur.
			e.printStackTrace();
			logger.error("fichier non chargé.");
		}

		// load a properties file
		
		
	}
	
	

	public int essais(){	// ici la méthode sert à retourner le nombre d'essais du Mode Attaque et du Mode Défense.
		
		
		String nombreDessaisString = null;
		try {
			nombreDessaisString = prop.getProperty("nombreDessais");// ici je récupère dans le fichier la propriété nombre d'essais en string.
		
		}catch(java.lang.NumberFormatException e) {
			logger.error("la propriété nombreDessais n'est pas chargée");
		} 
		
		int nombreDessais = Integer.parseInt(nombreDessaisString);// je la transforme en int
		return nombreDessais;	// je la retourne pour les modes de jeu.
		
	}
	
	public int chiffreCombi(){// ici la méthode sert à retourner les chiffres de combinaisons du Mode Attaque, du Mode Défense, et du Mode Duel.
		
		String nombreChiffreCombiString = null;
		try {
		nombreChiffreCombiString = prop.getProperty("nombreChiffreCombi");// ici je récupère dans le fichier la propriété qui contient les chiffres de combinaison en string.

		}catch(java.lang.NumberFormatException e) {
		logger.error("la propriété nombreChiffreCombi n'est pas chargé");
		} 
		int nombreChiffreCombi = Integer.parseInt(nombreChiffreCombiString);// je la transforme en int
		if(nombreChiffreCombi < 4) {// je fais une petite condition si le nombre de la combinaison est inférieure à 4 elle sera égale à 4.
			nombreChiffreCombi = 4;
		}
		return nombreChiffreCombi;// je la retourne pour les modes de jeu.
	}
	
	public boolean modeDeveloppeur(){// ici la méthode sert à activer ou à désactiver le mode Développeur (afficher le code secret)
		

		String modeDeveloppeurString = null;
		try {
			modeDeveloppeurString = prop.getProperty("modeDeveloppeur");// ici je récupère dans le fichier la propriété mode développeur en string.

		}catch(java.lang.NumberFormatException e) {
		logger.error("la propriété modeDeveloppeur n'est pas chargée");
		}
		boolean modeDeveloppeur = Boolean.parseBoolean(modeDeveloppeurString);// je la transforme en boolean
		return modeDeveloppeur;// je retourne true ou false
	}
	

	
}
