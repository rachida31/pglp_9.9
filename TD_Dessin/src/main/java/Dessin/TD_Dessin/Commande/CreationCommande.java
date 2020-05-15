package Dessin.TD_Dessin.Commande;

import java.util.ArrayList;

import Dessin.TD_Dessin.Carre;
import Dessin.TD_Dessin.Cercle;
import Dessin.TD_Dessin.Coordonnee;
import Dessin.TD_Dessin.Rectangle;
import Dessin.TD_Dessin.Triangle;
import Dessin.TD_Dessin.DAO.CarreDAO;
import Dessin.TD_Dessin.DAO.CercleDAO;
import Dessin.TD_Dessin.DAO.DaoFactory;
import Dessin.TD_Dessin.DAO.RectangleDAO;
import Dessin.TD_Dessin.DAO.TriangleDAO;

public class CreationCommande implements Commande{

	ArrayList<String> l ;
	DaoFactory daof;
	public CreationCommande(ArrayList<String> l) {
		// TODO Auto-generated constructor stub
		this.l=l;
		this.daof=new DaoFactory(); 
		System.out.println("zzzzzzzzzzzzzzzzzzzzzz "+this.l.size());
		
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
    	System.out.println("creation commande  ");

        if(l.get(1).equalsIgnoreCase("cercle"))
        {
            	System.out.println("hhhhhhhhhhhh cercle ");
            	Coordonnee c=new Coordonnee(Integer.parseInt((String) l.get(2)),Integer.parseInt((String) l.get(3)));
                System.out.println(" X "+c.getX()+ " Y "+c.getY());
            	CercleDAO cdao=(CercleDAO) DaoFactory.getCercleDAO();
            	   Cercle cercle=new Cercle((String)l.get(0),c,Integer.parseInt((String) l.get(4)));
            	cdao.create(cercle);
        		System.out.println("Creation reussite!");


        	
        	
       			
        }
        else if(l.get(1).equalsIgnoreCase("Carre"))
        {
        	System.out.println(" Carre ");
          	CarreDAO cdao=(CarreDAO) DaoFactory.getCarreDAO();
        	Coordonnee c=new Coordonnee(Integer.parseInt((String) l.get(2)),Integer.parseInt((String) l.get(3)));
        	  Carre carre=new Carre((String)l.get(0),c,Integer.parseInt((String) l.get(4)));
          	cdao.create(carre);
    		System.out.println("Creation reussite!");


        	

        }
        else if(l.get(1).equalsIgnoreCase("Triangle"))
        {
        	System.out.println(" Triangle ");
        	TriangleDAO cdao=(TriangleDAO) DaoFactory.getTriangleDAO();
        	Coordonnee c1=new Coordonnee(Integer.parseInt((String) l.get(2)),Integer.parseInt((String) l.get(3)));
        	Coordonnee c2=new Coordonnee(Integer.parseInt((String) l.get(4)),Integer.parseInt((String) l.get(5)));
        	Coordonnee c3=new Coordonnee(Integer.parseInt((String) l.get(6)),Integer.parseInt((String) l.get(7)));
        	System.out.println(" X "+c1.getX()+ " Y "+c1.getY());
        	Triangle triangle=new Triangle((String)l.get(0),c1,c2,c3);
        	cdao.create(triangle);
    		System.out.println("Creation reussite!");


        }
        else if(l.get(1).equalsIgnoreCase("Rectangle"))
        {
        	System.out.println(" Carre ");
        	RectangleDAO cdao=(RectangleDAO) DaoFactory.getRectangleDAO();
        	Coordonnee c=new Coordonnee(Integer.parseInt((String) l.get(2)),Integer.parseInt((String) l.get(3)));
        	System.out.println(" X "+c.getX()+ " Y "+c.getY());
        	Rectangle rectangle=new Rectangle((String)l.get(0),c,Integer.parseInt((String) l.get(4)),Integer.parseInt((String) l.get(4)));
        	cdao.create(rectangle);
    		System.out.println("Creation reussite!");


        }

		
	}

}
