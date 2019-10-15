#################################################################################################################################
#																#
#																#
#							 Compilation								#
#																#
#							( 2 m�thodes )								#
#																#
#																#
#################################################################################################################################



						************* Methode 1 (CMD) **************


1)Lancer Cmd en mode Administrateur (si windows)

2)Se mettre sur le chemin  o� on veut d�poser notre fichier compil� (grace � la commande "cd"). Exemple : "cd C:\fichiercompile"

3)Taper la commande jar -cf nomdufichiercompil�.jar fichier du r�pertoire de classe puis rajouter *.class (pour prendre toutes les classes) 
|| Exemple : " jar -cf test.jar C:\workspaceJava\EscapeGameOnline\bin\fr\gameplaystudio\escapegame/*.class



						************* Methode 2 (Ide Eclipse) ***************


1)Ouvrir votre projet sur Eclipse

2)Clic droit sur votre Projet cliquer sur "Export", cliquer sur Java ensuite "Runnable Jar File" Choisissez votre "Main", cliquer sur "Next" puis "finish".






#################################################################################################################################
#																#
#																#
#						      Ex�cuter le fichier								#
#																#
#							( 2 m�thodes )								#
#																#
#																#
#################################################################################################################################

Avant de commencer il faut savoir que vous avez besoin des fichiers config.properties et log4j2.xml au m�me endroit que votre fichier compil� !!!!
ces fichiers se trouvent dans le projet.

					************* Methode 1 (CMD) **************


1)Ouvrir CMD en mode Administrateur (si windows)

2)Se mettre sur le chemin o� on a compil� notre jar

3)Taper la ligne de commande suivante java -jar nomdufichiercompile.jar || exemple java -jar test.jar

4) dans notre cas on a 2 param�tres les param�tes vm se placent avant le "-jar" les param�tres "program" se placent apr�s le nomdufichiercompile.jar

Exemple : java -Dlog4j.configurationFile=file:C:/fichiercompile/log4j2.xml -jar test.jar c:/fichiercompile/config.properties


					************* Methode 2 (fichier Bat)**************


1)Cr�er un fichier .txt � la racine du projet compil� l� o� se trouve le .jar || Exemple : C:/fichiercompile/

2)Taper la m�me ligne de commande que la m�thode 1 (cmd) : java -jar nomdufichiercompile.jar

3)Dans notre cas on a des param�tres cela marche comme la m�thode 1 (cmd)

Exemple : java -Dlog4j.configurationFile=file:C:/fichiercompile/log4j2.xml -jar test.jar c:/fichiercompile/config.properties

PS : on peut aussi mettre %~dp0 la place de c:/fichiercompile cela va choisir automatiquement le chemin de dossier.
Exemple : java -Dlog4j.configurationFile=file:/%~dp0/log4j2.xml -jar EscapeGameOnline.jar %~dp0/config.properties

4)Puis changer l'extension en .bat