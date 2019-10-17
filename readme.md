#################################################################################################################################
#																#
#																#
#							 Compilation								#
#																#
#							( 2 méthodes )								#
#																#
#																#
#################################################################################################################################


						************* Methode 1 (CMD) **************


1)Lancer Cmd en mode Administrateur (si windows)

2)Se mettre sur le chemin  où on a notre package "fr" (grace à la commande "cd"). Exemple : "cd C:\workspaceJava\EscapeGameOnline\bin\"

3)Taper la commande jar -cfm chemin du dossier compilation nomdufichiercompilé.jar  fichier du répertoire du manifest  fichier du répertoire de classe puis rajouter *.class (pour prendre toutes les classes) 
|| Exemple : " jar -cfm c:/fichiercompile/EscapeGameOnline.jar META-INF/MANIFEST.MF fr\gameplaystudio\escapegame/*.class

4)Enfin vous devez mettre vos librairies log4j qui se trouvent dans le dossier lib sur github (log4j-1.2-api-2.12.1.jar log4j-api-2.12.1.jar log4j-core-2.12.1.jar) a la racine où se trouve le .jar compilé

Exemple : c:/fichiercompile/


						************* Methode 2 (Ide Eclipse) ***************


1)Ouvrir votre projet sur Eclipse

2)Clic droit sur votre Projet cliquer sur "Export", cliquer sur Java ensuite "Runnable Jar File" Choisissez votre "Main", cliquer sur "Next" puis "finish".






#################################################################################################################################
#																#
#																#
#						      Exécuter le fichier							#
#																#
#							( 2 méthodes )								#
#																#
#																#
#################################################################################################################################

Avant de commencer il faut savoir que vous avez besoin des fichiers config.properties et log4j2.xml au même endroit que votre fichier compilé !!!!
ces fichiers se trouvent dans le projet.

					************* Methode 1 (CMD) **************


1)Ouvrir CMD en mode Administrateur (si windows)

2)Se mettre sur le chemin où on a compilé notre jar

3)Taper la ligne de commande suivante java -jar nomdufichiercompile.jar || exemple java -jar test.jar

4) dans notre cas on a 2 paramètres les paramètes vm se placent avant le "-jar" les paramètres "program" se placent après le nomdufichiercompile.jar

Exemple : java -Dlog4j.configurationFile=file:C:/fichiercompile/log4j2.xml -jar test.jar c:/fichiercompile/config.properties


					************* Methode 2 (fichier Bat)**************



Le fichier .bat est déjà créé il se trouve dans le dossier script, il faut le placer dans le dossier où vous avez compilé votre fichier au côté du.jar.


Voici comment j'ai procédé pour faire ce .bat :

1)Créer un fichier .txt à la racine du projet compilé là où se trouve le .jar || Exemple : C:/fichiercompile/

2)Taper la même ligne de commande que la méthode 1 (cmd) : java -jar nomdufichiercompile.jar

3)Dans notre cas on a des paramètres cela marche comme la méthode 1 (cmd)

Exemple : java -Dlog4j.configurationFile=file:C:/fichiercompile/log4j2.xml -jar test.jar c:/fichiercompile/config.properties

PS : on peut aussi mettre %~dp0 la place de c:/fichiercompile cela va choisir automatiquement le chemin de dossier.
Exemple : java -Dlog4j.configurationFile=file:/%~dp0/log4j2.xml -jar EscapeGameOnline.jar %~dp0/config.properties

4)Puis changer l'extension en .bat