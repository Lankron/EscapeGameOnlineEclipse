package fr.gameplaystudio.escapegame;

import java.util.ArrayList;
import java.util.Random;

import org.apache.log4j.Logger;

public class Computer {

	Configuration config = new Configuration();// j'appelle la classe config où il y a tous mes fichiers de configuration
	Random chiffrerandom = new Random();// ici c'est la classe utilisée pour faire un chiffre aléatoire
	final static Logger logger = Logger.getLogger(Computer.class);
	
	public ArrayList<Integer> randomNumberComputer() {
		
		// ici je fais une ArrayList qui contient mes chiffre random
		ArrayList<Integer> chiffreOrdinateur = new ArrayList<Integer>();
		for(int i=0; i < config.chiffreCombi(); i++) {// je fais une petite boucle pour éviter de me répéter
			chiffreOrdinateur.add(chiffrerandom.nextInt(10));// j'ajoute les chiffres random je mets 10 parce que si je mets 9 le maximal sera 8 !! avec 10 le maximal est 9.
		}
		

		return chiffreOrdinateur;// je retourne mon ArrayList
		
		
	}
	
	public ArrayList<Integer> tableauPlusComputer() {
		
		ArrayList<Integer> tabplus = new ArrayList<Integer>();// je fais un ArrayList de plus qui me servira pour l'intelligence artificielle du mode Défense
		for(int i=0; i < config.chiffreCombi(); i++) {// je fais une petite boucle pour éviter de me répéter
			tabplus.add(9);// j'y ajoute 9 pour chaque chiffre de combinaison s'il y a 4 chiffres il y'aura  quatre 9.
		}
		

		return tabplus;
		
		
	}
	
	public ArrayList<Integer> tableauMoinsComputer() {
	
	ArrayList<Integer> tabmoins = new ArrayList<Integer>();// je fais un ArrayList de moins qui me servira pour l'intelligence artificielle du mode Défense
	for(int i=0; i < config.chiffreCombi(); i++) {// je fais une petite boucle pour éviter de me répéter
		tabmoins.add(0);// j'y ajoute 0 pour chaque chiffre de combinaison s'il y a 4 chiffres il y aura  quatre 0.
	}
	

	return tabmoins;// je retourne mon ArrayList
	
	
	}

	
}
