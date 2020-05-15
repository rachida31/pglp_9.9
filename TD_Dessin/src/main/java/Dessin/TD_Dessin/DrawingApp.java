package Dessin.TD_Dessin;

import java.util.Scanner;

import Dessin.TD_Dessin.Commande.Commande;
import Dessin.TD_Dessin.Commande.DrawingTUI;
import Dessin.TD_Dessin.DAO.DerbyConnexion;
import Exeption.TableExisteException;

public class DrawingApp {
	  Commande commande;
	 
	  private DrawingTUI drt;
	public DrawingApp()
	{
	        this.drt = new DrawingTUI();
	}
	public void menu1() throws TableExisteException
	{
		 DerbyConnexion conn =new DerbyConnexion();
//			conn.createtable();

	System.out.println("*************************** Bienvenue au logiciel de dessin ***************************");
	System.out.println(" Vous avis les choix  des commandes suivantes :");
	System.out.println("1- Dessiner une Forme (Cercle,Carre,Rectangle,Triangle)");
	System.out.println("\n **************************Exemple :************************************");
	System.out.println("\n      pour un Cercle exp: \"c1 = Cercle ((0, 0), 50) \"");
	System.out.println("      pour un Carre exp:\"a1 = Carre((1, 2),5) \"");
	System.out.println("      pour un Rectangle exp:\"r1 = Rectangle((2, 8), 9,4) \"");
	System.out.println("      pour un  Triangle exp:\"t1 = Triangle((0, 0),(3,1),(4,6) \"");
	System.out.println("\n\n*****************************************************************************");

	System.out.println("2- Dessiner un groupe de Forme si les formes existes");
	System.out.println("\n **************************Exemple :************************************");
	System.out.println("\n      pour un Groupe exp: \"g1 = Groupe (c1,a1,r1,t1) \"");
	System.out.println("\n\n*****************************************************************************");

	System.out.println("3- Deplacer une forme ou un groupe si ils existent ");
	System.out.println("\n **************************Exemple :************************************");
	System.out.println("     pour un Cercle exp: \"move=c1(4, 1) \"");
	System.out.println("      pour un Carre exp:\"move=a1(9, 3)\"");
	System.out.println("      pour un Rectangle exp:\"move = r1(0, 10) \"");
	System.out.println("      pour un  Triangle exp:\"move = t1(5,6) \"");
	System.out.println("      pour un Groupe exp: \"move = g1(7,3) \"");

	System.out.println("\n\n*****************************************************************************");

	System.out.println("4- Supprimer une forme ou un groupe si ils existent ");
	System.out.println("\n **************************Exemple :************************************");
	System.out.println("     pour un Cercle exp: \"delete=c1 \"");
	System.out.println("      pour un Carre exp:\"delete=a1\"");
	System.out.println("      pour un Rectangle exp:\"delete = r1 \"");
	System.out.println("      pour un  Triangle exp:\"delete = t1 \"");
	System.out.println("      pour un Groupe exp: \"delete = g1 \"");
	
	System.out.println("\n\n*****************************************************************************");

	System.out.println("5- Afficher les dessins realiser");
	System.out.println("\n\n*****************************************************************************");

	System.out.println("*************Si vous voulez afficher les formes que vous avez realiser  merci d'entrer \"print\"****************");

	System.out.println("6- quiter");

	 
	}
	public void afficheChoix()
	{
	
		System.out.println("\n\n*****************************************************************************");
				System.out.println("*************Vous pouvez entrer la forme que vous souhaitez de la façon suivante:*****************");
				System.out.println(" \n              \"Nom de la forme = type de a forme (Coordonnée de la forme) \"");
				System.out.println("\n **************************Exemple :************************************");
				System.out.println("\n      pour un Cercle exp: \"c1 = Cercle ((0, 0), 50) \"");
				System.out.println("      pour un Carre exp:\"a1 = Carre((1, 2),5) \"");
				System.out.println("      pour un Rectangle exp:\"r1 = Rectangle((2, 8), 9,4) \"");
				System.out.println("      pour un  Triangle exp:\"t1 = Triangle((0, 0),(3,1),(4,6) \"");
				System.out.println("\n\n*****************************************************************************");
	
		System.out.println("*********Vous pouvez entrer le groupe que vous souhaitez realiser de la façon suivante:************");
		System.out.println(" \n              \"Nom de groupe = groupe (le nom des formes qui sont dans le groupe) \"");
		System.out.println("\n **************************Exemple :************************************");
		System.out.println("\n      pour un Groupe exp: \"g1 = Groupe (c1,a1,r1,t1) \"");
		System.out.println("\n\n*****************************************************************************");

	
		System.out.println("**********Vous pouvez deplacer soit une forme soit un groupe  de la façon suivante:**************");
		System.out.println(" \n              \"move = Nom de la forme ou groupe (les coordonnee de deplacement) \"");
		System.out.println("\n **************************Exemple :************************************");
		System.out.println("     pour un Cercle exp: \"move=c1(4, 1) \"");
		System.out.println("      pour un Carre exp:\"move=a1(9, 3)\"");
		System.out.println("      pour un Rectangle exp:\"move = r1(0, 10) \"");
		System.out.println("      pour un  Triangle exp:\"move = t1(5,6) \"");
		System.out.println("      pour un Groupe exp: \"move = g1(7,3) \"");

		System.out.println("\n\n*****************************************************************************");

		System.out.println("***********Vous pouvez supprimer soit une forme soit un groupe  de la façon suivante:******************");
		System.out.println(" \n              \"delete = Nom de la forme ou groupe à supprimer \"");
		System.out.println("\n **************************Exemple :************************************");
		System.out.println("     pour un Cercle exp: \"delete=c1 \"");
		System.out.println("      pour un Carre exp:\"delete=a1\"");
		System.out.println("      pour un Rectangle exp:\"delete = r1 \"");
		System.out.println("      pour un  Triangle exp:\"delete = t1 \"");
		System.out.println("      pour un Groupe exp: \"delete = g1 \"");
		
		System.out.println("\n\n*****************************************************************************");

		System.out.println("*************Si vous voulez afficher les formes que vous avez realiser  merci d'entrer \"print\"****************");

		System.out.println("\n\n*****************************************************************************");

		System.out.println("************Si vous voulez vraiment quiter merci d'entrer \"exit\"*************");

	
	 	
	}
	public void run() throws Exception
	{	           menu1();
	Scanner S = new Scanner(System.in);
	
	//afficheChoix();
	  String str = S.nextLine();
	
		System.out.println("5555555555555555555555555555  "+str);
	        Commande commande;
	        while (!str.equalsIgnoreCase("exit")) {
	        	commande = drt.nextCommand(str);
	            if (commande !=  null ) {
	            	commande.execute();
	               
	            }
		    	System.out.println("vous pouvez entrer une nouvelle commande  ");
		    	str = S.nextLine();
		    	System.out.println("111111111111111111111  "+str);
	        }

	    }	
	

}
