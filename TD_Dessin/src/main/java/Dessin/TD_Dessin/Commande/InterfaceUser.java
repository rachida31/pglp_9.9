package Dessin.TD_Dessin.Commande;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import Dessin.TD_Dessin.Cercle;
import Dessin.TD_Dessin.Coordonnee;
import Dessin.TD_Dessin.Formes_Graphiques;
import Dessin.TD_Dessin.DAO.DerbyConnexion;
import Exeption.TableExisteException;

public class InterfaceUser {
	
	
	
	
	public InterfaceUser()
	{
		
	}
	public ArrayList<String> liste(String str)
	{
		ArrayList<String> l= new ArrayList<String>();
		 System.out.println( "Hello World! "+str );
	        StringTokenizer multiTokenizer = new StringTokenizer(str, "=(), ");
	        System.out.println("length "+multiTokenizer.hasMoreTokens());
	        while (multiTokenizer.hasMoreTokens())
	        {
	        	String a= multiTokenizer.nextToken();
	        	l.add(a);
	        	System.out.println(a);
	        }
	        return l;
	}
	public void dessinForme()
	{
		Coordonnee c;
    	Formes_Graphiques f;
    	ArrayList<String> l= new ArrayList<String>();
    	Scanner S = new Scanner(System.in);
    	String str = S.nextLine();
       l=liste(str);
       System.out.println(str);
       System.out.println(l);
       boolean bool=true;
       while(bool==true) 
       {
    	   bool=false;
          	System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkk ddddddddddddd "+bool+" jjjjjjjjjjj "+l.get(1));

        while(!l.get(1).equalsIgnoreCase("cercle")&&!l.get(1).equalsIgnoreCase("carre")
        		&&!l.get(1).equalsIgnoreCase("triangle")&&!l.get(1).equalsIgnoreCase("rectangle"))
        {
        	System.out.println(" Merci de refaire votre dessin et choisir l\'une  des formes suivantes (cercle ,carre rectangle,triangle) pour le nom !");
            str = S.nextLine();
        	l=liste(str);

        }
        
        if(l.get(1).equalsIgnoreCase("cercle"))
        {
        	while(l.size()!=5 || !("c".regionMatches(true, 0, l.get(0), 0, 1)))
        	{
        		if(l.size()!=5)
        		{
        		System.out.println(" Merci de mettre le bon nombre d\'element pour dessiner votre cercle !");
        		}
        		else
        		{
            	System.out.println(" Merci de mettre le nom de votre cercle comme suit : \" c \" avec un chiffre !");	
        		}
        		str = S.nextLine();
            	l=liste(str);
                bool=true;

        	}
        	
       			
        }
        else if(l.get(1).equalsIgnoreCase("Carre"))
        {
        	while(l.size()!=5 || !("a".regionMatches(true, 0, l.get(0), 0, 1)))
        	{
        		if(l.size()!=5)
        		{
        		System.out.println(" Merci de mettre le bon nombre d\'element pour dessiner votre carre !");
        		}
        		else
        		{
            	System.out.println(" Merci de mettre le nom de votre carre comme suit : \" a \" avec un chiffre !");	
        		}
        		str = S.nextLine();
            	l=liste(str);
                bool=true;

        	}

        }
        else if(l.get(1).equalsIgnoreCase("Triangle"))
        {
        	while(l.size()!=8 || !("t".regionMatches(true, 0, l.get(0), 0, 1)))
        	{
        		if(l.size()!=8)
        		{
        		System.out.println(" Merci de mettre le bon nombre d\'element pour dessiner votre triangle !");
        		}
        		else
        		{
            	System.out.println(" Merci de mettre le nom de votre triangele comme suit : \" t \" avec un chiffre !");	
        		}
        		str = S.nextLine();
            	l=liste(str);
                bool=true;
        	}

        }
        else if(l.get(1).equalsIgnoreCase("Rectangle"))
        {
        	while(l.size()!=6 || !("r".regionMatches(true, 0, l.get(0), 0, 1)))
        	{
        		if(l.size()!=6)
        		{
        		System.out.println(" Merci de mettre le bon nombre d\'element pour dessiner votre rectangle !");
        		}
        		else
        		{
            	System.out.println(" Merci de mettre le nom de votre rectangle comme suit : \" r \" avec un chiffre !");	
        		}
        		str = S.nextLine();
            	l=liste(str);
                bool=true;
        	}
        }
        }
       
        System.out.println(" size " +l.size()+" classe "+l.get(2).getClass());

       /* c=new Coordonnee(Integer.parseInt((String) l.get(2)),Integer.parseInt((String) l.get(3)));
        System.out.println(" X "+c.getX()+ " Y "+c.getY());
        f=new Cercle((String)l.get(0),c,Integer.parseInt((String) l.get(4)));
        f.print();*/
    	CreationCommande commande= new CreationCommande(l);
     
    	commande.execute();
		
		
		
		
	}
	public void menu1() throws TableExisteException
	{
		 DerbyConnexion conn =new DerbyConnexion();
//			conn.createtable();
try (Scanner S = new Scanner(System.in)) {
	System.out.println("*************************** Bienvenue au logiciel de dessin ***************************");
	System.out.println(" Vous avis les choix suivantes :");
	System.out.println("1- Dessiner une Forme (Cercle,Carre,Rectangle,Triangle)");
	System.out.println("2- Dessiner un groupe de Forme");
	System.out.println("3- Deplacer une forme si elle existe ");
	System.out.println("4- Deplacer un groupe de forme si il existe");
	 
	int choix = S.nextInt();
	while(choix!=1 && choix!=2 && choix!=3 && choix!=4)
	{
		System.out.println("Votre choix ne correspond a aucune des choix proposer ,Merci de bien choisir !");
		choix = S.nextInt();
	}
	
	switch(choix) {

	case 1:
			{
				System.out.println("Vous pouvez entrer la forme que vous souhaitez de la façon suivante:");
				System.out.println(" \n              \"Nom de la forme = type de a forme (Coordonnée de la forme) \"");
				System.out.println("\n **************************Exemple :************************************");
				System.out.println("\n      pour un Cercle exp: \"c1 = Cercle ((0, 0), 50) \"");
				System.out.println("      pour un Carre exp:\"a1 = Carre((1, 2),5) \"");
				System.out.println("      pour un Rectangle exp:\"r1 = Rectangle((2, 8), 9,4) \"");
				System.out.println("      pour un  Triangle exp:\"t1 = Triangle((0, 0),(3,1),(4,6) \"");
		    	dessinForme();

			}


	}
}
    	
	}
	public void menu()
	{
		try (Scanner S = new Scanner(System.in)) {
			System.out.println("*************************** Bienvenue au logiciel de dessin ***************************");
			System.out.println(" Vous avis les choix suivantes :");
			System.out.println("1- Dessiner un Cercle exp:\"c1 = Cercle((0, 0), 50) \"");
			System.out.println("2- Dessiner un Carre exp:\"a1 = Carre((1, 2),5) \"");
			System.out.println("3- Dessiner un Rectangle exp:\"c1 = Rectangle((2, 8), 9,4) \"");
			System.out.println("4- Dessiner un Triangle exp:\"c1 = Triangle((0, 0),(3,1),(4,6) \"");
			int choix = S.nextInt();
			while(choix!=1 && choix!=2 && choix!=3 && choix!=4)
			{
				System.out.println("Votre choix ne correspond a aucune forme,Merci de bien choisir !");
				choix = S.nextInt();
			}
switch(choix) {

case 1:
			{
				System.out.println("Vous pouvez entrer les cooredonnées de votre cercle de la façon suivante:");
				System.out.println("               \"c1 = Cercle((0, 0), 50) \"");

			}


}
		}
	
	}

}
