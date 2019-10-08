package fr.gameplaystudio.escapegame;




import org.apache.log4j.Logger;




public class Main {

	
	final static Logger logger = Logger.getLogger(Main.class);
	static Configuration config = new Configuration();
	static Home home = new Home();
	
	
	
	public static void main(String[] args) {
		
		logger.info("lancement de l'application");
		
		Configuration.loadProperties(args[0]);// chargement des propriétés je passe un argument qui contient le chemin de la configuration.properties 
		
		logger.debug("Avant // l'appel de la méthode home");
		home.home();// j'appelle la méthode home pour afficher l'accueil
		logger.debug("Après // la méthode home a été appelée");
		
	
		
		
		
		
		
		
		
		


	}

}
