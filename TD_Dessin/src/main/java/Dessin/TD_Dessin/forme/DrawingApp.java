package Dessin.TD_Dessin.forme;
import java.sql.SQLException;
import Dessin.TD_Dessin.Commande.Commande;
import Dessin.TD_Dessin.Commande.DrawingTUI;
import java.util.Scanner;
/**
 * implemantation de la classe DrawingApp qui fait interger avec l'utilisteur.
 * @author rachida ouchene.
 */
public class DrawingApp {
	/**
	 * un attribut de type DrawingTUI pour annalyser l'entree de l'utilisateur.
	 */
	private DrawingTUI drt;
	/**
	 * Constructor DrawingApp qui va instancier l'objet drt qu'est de type
	 * DrawingTUI.
	 * @throws SQLException une exception si y a
	 * un problemme avec l'execution de la sql.
	 */
	public DrawingApp() throws SQLException {
		this.drt = new DrawingTUI();
	}

	/**
	 * le menu qui affiche a l'utilisateur les actions possible.
	 */
	public void menu1() {
		System.out.println("*************************** Bienvenue au logiciel "
				+ "de dessin ***************************");
		System.out.println(" Vous avis les choix  des commandes suivantes :");
		System.out.println("1- Dessiner une Forme (Cercle,Carre,"
				+ "Rectangle,Triangle)");
		System.out.println("\n **************************Exemple "
				+ ":************************************");
		System.out.println("\n      pour un Cercle exp: \"c1 = Cercle "
				+ "((0, 0), 50) \"");
		System.out.println("      pour un Carre exp:\"a1 = Carre((1, 2),5) \"");
		System.out.println("2- Dessiner un groupe de Forme si les formes "
				+ "existes exp: \\\"g1 = Groupe (c1,a1,r1,t1) ");
		System.out.println("3- Deplacer une forme ou un groupe si ils "
				+ "existent ");
		System.out.println("     pour un Cercle exp: \"move(c1(4, 1)) \"");
		System.out.println("      pour un Carre exp:\"move(a1(9, 3))\"");
		System.out.println("      pour un Groupe exp: \"move(g1(7,3))\"");
		System.out.println("5- Rechercher un  dessin que vous avez realiser "
				+ "entree find exp:\" find(c1)\"");
		System.out.println("6- pout quiter entree exit ");

	}

	/**
	 * methode permetant d'executer les differnents commandes envoyées par
	 * l'interface de l'utilisateur
	 * 
	 * @throws Exception
	 */
	public void run() throws Exception {
		menu1();
		try (Scanner S = new Scanner(System.in)) {
			System.out.println("        Vous pouvez entrer une nouvelle "
					+ "commande  ");
			String str = S.nextLine();
			Commande commande;
			while (true) {
				commande = drt.nextCommand(str);
				if (commande != null) {
					commande.execute();
					drt.afficheForme();
				}
				System.out.println("         Vous pouvez entrer une "
						+ "nouvelle commande  ");
				str = S.nextLine();
			}
		}

	}

}
