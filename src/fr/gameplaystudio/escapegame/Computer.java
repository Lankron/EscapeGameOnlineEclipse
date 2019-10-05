package fr.gameplaystudio.escapegame;

import java.util.ArrayList;
import java.util.Random;

import org.apache.log4j.Logger;

public class Computer {

	Configuration config = new Configuration();// j'appel la class config la ou y'a tous mes fichiers de configuration
	Random chiffrerandom = new Random();// ici c'est la classe utilisé pour faire un chiffre aléatoire
	final static Logger logger = Logger.getLogger(Computer.class);
	
	public ArrayList<Integer> randomNumberComputer() {
		
		
		ArrayList<Integer> chiffreOrdinateur = new ArrayList<Integer>();
		for(int i=0; i < config.chiffreCombi(); i++) {
			chiffreOrdinateur.add(chiffrerandom.nextInt(10));
		}
		

		return chiffreOrdinateur;
		
		
	}
	
	public ArrayList<Integer> tableauPlusComputer() {
		
		ArrayList<Integer> tabplus = new ArrayList<Integer>();
		for(int i=0; i < config.chiffreCombi(); i++) {
			tabplus.add(9);
		}
		

		return tabplus;
		
		
	}
	
	public ArrayList<Integer> tableauMoinsComputer() {
	
	ArrayList<Integer> tabmoins = new ArrayList<Integer>();
	for(int i=0; i < config.chiffreCombi(); i++) {
		tabmoins.add(0);
	}
	

	return tabmoins;
	
	
	}

	
}
