# pglp_9.9
## Logiciel de dessin

Ce logiciel que nous devons réaliser nous permettra de dessin une forme graphique soit un cercle soit un carré ,triangle ou bien un rectangle. Tel que nous nous limiterons ici à un affichage textuel, i.e. seule une description des figures sera affichée. Par exemple,affichons cette chaine "cercle(centre=(2,1),rayon=7)" qui correspond a un cercle de centre (2, 1) et de rayon 7.



 L'interaction  avec ce logiciel se fera par l'intermédiaire de la ligne de commandes. Avec chaque commande commencera par une action à effectuer qui se suivra par des arguments. Par exemple, pour créer un carré, l'utilisateur pourra taper "a1 = Carre((4, 1),7)" c'est un carré à la position (4,1) de cote 7, puis pour le déplacer "move(a1, (9, 2))" la nous ajouterons ce déplacement à la position de carre "a1"

 Les fonctionnalités offertes par ce logiciel:



*Chaque forme sera identifiée par un nom ("c1", "unCercle", ...).

*L'application permettra de manipuler des cercles, des rectangles, des carrés et des triangles.

*Chaque forme devra pouvoir être affichée et déplacée.

*Les formes devront pouvoir être regroupées et pourront subir des traitements globaux comme par exemple déplacer ensemble un cercle et un triangle.

*Un dessin (ensemble de formes) pourra être sauvegardé/chargé dans un SGBD embarqué comme HyperSQL, H2 ou Derby.



Pour réaliser ce logiciel nous appliquerons au mieux les principes de conception ainsi que les fonctionnalités du langage Java (exceptions, collections, ...) .

Ce que nous devrons faire:.
1)-Proposer et implémenter une hiérarchie de classe représentant les formes graphiques.

2)-Représenter la notion de groupe de formes en appliquant le pattern Composite.

3)-Rendre les formes et les groupes persistants en utilisant le pattern DAO et JDBC.

4)-Réaliser la classe DrawingTUI qui se chargera des interactions avec l’utilisateur. Cette classe fournira une méthode nextCommand qui analysera le texte saisi par l’utilisateur et retournera un objet implémentant l’interface Commande (cf. question suivante). Elle proposera également une méthode permettant d'afficher un dessin.

5)-Les commandes seront implémentées à l’aide du modèle de conception Commande.

6)-créer l’interface Command comportant la méthode execute,

7)-créer une classe implémentant cette interface pour chaque action.

8)-Réaliser la classe principale DrawingApp. La méthode run de cette classe interagira avec DrawingTUI pour récupérer la prochaine commande, l’exécutera puis affichera le résultat.
