package fr.gameplaystudio.escapegame;

import java.util.ArrayList;
import java.util.Random;

import org.apache.log4j.Logger;

public class ModeCalcul {

	Computer c = new Computer();// j'appel la class computer pour avoir toute les informations du computer
	Player p = new Player();// j'appel la class player pour avoir toute les informations du player
	Configuration config = new Configuration();// j'appel la class config la ou y'a tous mes fichiers de configuration

	//private Logger log = Logger.getLogger(ModeAttack.class);
	ArrayList<Integer> chiffreOrdinateur = c.randomNumberComputer();// ici je met les chiffres aléatoires du computer dans une arraylist.
	ArrayList<Integer> tabplus = c.tableauPlusComputer();
	ArrayList<Integer> tabmoins = c.tableauMoinsComputer();
	ArrayList<Integer> chiffreOrdinateurModeDefense = c.randomNumberComputer(); 
	ArrayList<String> resultat = new ArrayList<String>();
	final static Logger logger = Logger.getLogger(ModeCalcul.class);
	
	public ArrayList<String> calculModeAttack() {
		logger.info("rentre dans la méthode de calcul du mode attaque");
			resultat.clear();// je clear mon tableau de résultat comme ça quand la boucle repasse elle a de nouveaux résultats ( ça m'évite de me retrouver avec 40 résultats.)
			 
			// ici je crée une arraylist resultat pour enregistrer mes resultats sous forme de chaine de caractère(-+=+)
			
			ArrayList<Integer> chiffreClient = p.recuperelecodeEnInteger();// ici j'enregistre ce que l'utilisateur a tapé dans une arraylist
		
		
		
		for(int i=0; i < chiffreOrdinateur.size(); i++) {// ici je fais une boucle par rapport la taille de l'arraylist chiffreOrdinateur ça m'évite de faire plusieur condition.
			
			
			if(chiffreClient.get(i) < chiffreOrdinateur.get(i)) {// premier condition si le chiffre de l'utilisateur est inférieur au chiffre de l'ordinateur.
				
				resultat.add("+");// je push "+" dans l'arraylist résultat.
			
			}
			if(chiffreClient.get(i) > chiffreOrdinateur.get(i)) {// deuxième condition si le chiffre de l'utilisateur est supérieur au chiffre de l'ordinateur.
				
				resultat.add("-");// je push "-" dans l'arraylist résultat.
		
			}	
			if (chiffreClient.get(i) == chiffreOrdinateur.get(i)) {// la dernière condition si le chiffre de l'utilisateur est égal au chiffre de l'ordinateur.
				
				resultat.add("=");// je push "=" dans l'arraylist resultat.
				
			}
			
		}
		
		ArrayList<String> chiffreClientAndResult = new ArrayList<String>();

		
		StringBuilder resultatString = new StringBuilder();// j'utiliste stringbuilder pour afficher mes integer
		StringBuilder chiffreClientString = new StringBuilder();// j'utiliste stringbuilder pour afficher mes integer
		for(int i = 0; i< config.chiffreCombi();i++)// je fais une boucle pour éviter de me répéter
		{

		resultatString.append(resultat.get(i));// j'ajoute le résultat a mon stringbuilder
		chiffreClientString.append(chiffreClient.get(i));// j'ajoute le résultat a mon stringbuilder
		}
	
		
		chiffreClientAndResult.add(chiffreClientString.toString());// j'ajoute le chiffreclient a mon stringbuilder

		chiffreClientAndResult.add(resultatString.toString());// j'ajoute le résultat a mon stringbuilder

		
		logger.info("fin du calcul du mode défense");
		
		return chiffreClientAndResult;// je retourne mon arrayList qui contient la saisi de l'utilisateur en string, et le résultat (de l'ordianteur sous forme de =, +, - ) en string
			
			
		}

		public ArrayList<String> calculModeDefense() {
			logger.info("rentre dans la méthode de calcul du mode défense");
			ArrayList<String> propoClient = p.recuperelecodeEnString();// je récupère sous forme de String ce que l'utilisateur a tapé dans un arraylist
			
			
			
			// je me sert de ces string pour faire une condition
			String moin = "-";
			String plus = "+";
			
			
			
			
			
			
				for(int i = 0; i < chiffreOrdinateurModeDefense.size(); i++) {// je fais une boucle par rapport a la taille du tableau du chiffre de l'ordinateur et ça pour éviter de refaire des conditions.
					Random rand = new Random();
					//rand.nextInt(max - min + 1) + min;
					if(moin.equals(propoClient.get(i))){// ici je compare mes strings plus haut par rapport au string de l'utilisateur.
						
						if(tabplus.get(i) == tabmoins.get(i)) {// ici je fais une condition pour éviter un illegalargument
							
							tabplus.set(i, 9);
							tabmoins.set(i, 0);
							
						}
						
						tabplus.set(i, chiffreOrdinateurModeDefense.get(i) - 1);// ici je change dans mon tableau de plus le dernier chiffre que j'ai reçu de chiffreOrdinateur
						
						if(tabplus.get(i) < tabmoins.get(i)) {// ici je fais une condition pour éviter un illegalargument
							
							tabplus.set(i, 9);
							tabmoins.set(i, 0);
							
						}
						// ici je met une condition pour qu'il évite de descendre en dessous de 0.
						
						if(chiffreOrdinateurModeDefense.get(i) != 0) {
							
							chiffreOrdinateurModeDefense.set(i, rand.nextInt(tabplus.get(i) - tabmoins.get(i) + 1) + tabmoins.get(i));// ici je fais mon calcul si c'est - le chiffre descend de -1.
							if(chiffreOrdinateurModeDefense.get(i) == -1) {
								chiffreOrdinateurModeDefense.set(i, 0);
							}
						}
						
						
							
					}
					else if(plus.equals(propoClient.get(i))){
						if(tabplus.get(i) == tabmoins.get(i)) {// ici je fais une condition pour éviter un illegalargument
							
							tabplus.set(i, 9);
							tabmoins.set(i, 0);
							
						}
						
						tabmoins.set(i, chiffreOrdinateurModeDefense.get(i) + 1);// ici je change dans mon tableau de moins le dernier chiffre que j'ai reçu de chiffreOrdinateur
						
						if(tabplus.get(i) < tabmoins.get(i)) {// ici je fais une condition pour éviter un illegalargument
							
							tabplus.set(i, 9);
							tabmoins.set(i, 0);
							
						}
						// ici je met une condition pour qu'il évite de monter au dessus de 9.
						
						if(chiffreOrdinateurModeDefense.get(i) != 9) {
							
							
							chiffreOrdinateurModeDefense.set(i, rand.nextInt(tabplus.get(i) - tabmoins.get(i) + 1) + tabmoins.get(i));// ici je fais mon calcul si c'est + le chiffre descend de +1.
							if(chiffreOrdinateurModeDefense.get(i) == 10) {
								chiffreOrdinateurModeDefense.set(i, 9);
							}
						}
						
					
					}
					else{

						chiffreOrdinateurModeDefense.set(i, chiffreOrdinateurModeDefense.get(i));// ici si il est égal le chiffre ne change pas.
					}
					
					
				}
				
				StringBuilder egal = new StringBuilder();// j'utiliste stringbuilder pour comparer 2 résultats pour la condition juste en dessous
				StringBuilder propoClientString = new StringBuilder();// j'utiliste stringbuilder pour comparer 2 résultats pour la condition juste en dessous
				StringBuilder chiffreOrdinateurString = new StringBuilder();

				for(int i = 0; i< config.chiffreCombi();i++)// je fais une boucle pour éviter de me répéter
				{
				   
					
					propoClientString.append(propoClient.get(i));// j'ajoute propositionclient a mon stringbuilder 
					chiffreOrdinateurString.append(chiffreOrdinateurModeDefense.get(i));// j'ajoute le chiffre random de mon ordinateur a mon stringbuilder
					egal.append("=");
				}
				
				
				ArrayList<String> propoClientAndChiffreOrdinateur = new ArrayList<String>();

				
				propoClientAndChiffreOrdinateur.add(propoClientString.toString());// j'ajoute le chiffre random de mon ordinateur ArrayList
				propoClientAndChiffreOrdinateur.add(chiffreOrdinateurString.toString());// j'ajoute le chiffre random de mon ordinateur ArrayList
				propoClientAndChiffreOrdinateur.add(egal.toString());// j'ajoute les résultat (win) a mon ArrayList
				logger.info("fin du calcul du mode défense");
			
			
			return propoClientAndChiffreOrdinateur;// je retourne mon arrayList qui contient la saisi de l'utilisateur en string le chiffre ordinateur (random number ) en string, et mes égal(pour faire une condition) en string aussi.

				
			
			
		}

		
		
		public String affichelecodeComputerModeAttack(){
			
			logger.info("rentre dans la méthode de l'affichage du code secret du mode attaque");
			 StringBuilder chiffreOrdinateurEnstring = new StringBuilder();// j'utiliste stringbuilder pour afficher mes integer
			

			for(int i = 0; i< config.chiffreCombi();i++)// je fais une boucle pour éviter de me répéter
			{
			   
				chiffreOrdinateurEnstring.append(chiffreOrdinateur.get(i));// j'ajoute le chiffre de l'ordinateur a mon stringbuilder
	
		
			
			}
			return chiffreOrdinateurEnstring.toString();// je retourne mon chiffre random (mode attaque) en string
			

	
		
		}
		public String affichelecodeComputerModeDefense(){
			
			logger.info("rentre dans la méthode de l'affichage du code du mode défense (random ordinateur)");
			
			 StringBuilder chiffreOrdinateurEnstring = new StringBuilder();// j'utiliste stringbuilder pour afficher mes integer
			

			for(int i = 0; i< config.chiffreCombi();i++)// je fais une boucle pour éviter de me répéter
			{
			   
				chiffreOrdinateurEnstring.append(chiffreOrdinateurModeDefense.get(i));// j'ajoute le chiffre de l'ordinateur a mon stringbuilder
	
		
			
			}
			return chiffreOrdinateurEnstring.toString();// je retourne mon chiffre random (mode défense) en string
			

	
		
		}



}
