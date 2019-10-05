package fr.gameplaystudio.escapegame;




import org.apache.log4j.Logger;




public class Main {

	
	final static Logger logger = Logger.getLogger(Main.class);
	static Configuration config = new Configuration();
	private static Accueil home = new Accueil();
	
	public static void main(String[] args) {
		
		logger.info("chargement des ma propriété");
		Configuration.loadProperties(args[0]);// ici je charge mes propriétées qui sont dans la classe Configuration je leur transmet l'argument qui contient le chemin du fichier configuration.properties
		
		home.accueil();// ici je charge ma page d'accueil
		
		
		
	
		
		
		


	}
	


}
