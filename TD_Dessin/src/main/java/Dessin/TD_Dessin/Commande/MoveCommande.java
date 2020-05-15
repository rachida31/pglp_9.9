package Dessin.TD_Dessin.Commande;


import Dessin.TD_Dessin.Carre;
import Dessin.TD_Dessin.Cercle;
import Dessin.TD_Dessin.Coordonnee;
import Dessin.TD_Dessin.Form_Groupe;
import Dessin.TD_Dessin.Formes_Graphiques;
import Dessin.TD_Dessin.Rectangle;
import Dessin.TD_Dessin.Triangle;
import Dessin.TD_Dessin.DAO.CarreDAO;
import Dessin.TD_Dessin.DAO.CercleDAO;
import Dessin.TD_Dessin.DAO.DaoFactory;
import Dessin.TD_Dessin.DAO.Form_GroupeDAO;
import Dessin.TD_Dessin.DAO.RectangleDAO;
import Dessin.TD_Dessin.DAO.TriangleDAO;

public class MoveCommande implements Commande {
	private Formes_Graphiques forme ;
	private Coordonnee coor;

	public MoveCommande(Formes_Graphiques forme,Coordonnee coor)
	{
		this.forme=forme;
		this.coor=coor;
	 
		
	}
	@Override
	public void execute() {
    	System.out.println("move commande  ");

		// TODO Auto-generated method stub
		this.forme.move(coor.getX(),coor.getY());
		if(this.forme instanceof  Cercle)
		{
        	CercleDAO cdao=(CercleDAO) DaoFactory.getCercleDAO();
        	cdao.update((Cercle) forme);
		}
		else if(this.forme instanceof  Carre)
		{
			CarreDAO cdao=(CarreDAO) DaoFactory.getCarreDAO();
        	cdao.update((Carre) forme);

		}
		else if(this.forme instanceof  Rectangle)
		{
			RectangleDAO cdao=(RectangleDAO) DaoFactory.getRectangleDAO();
        	cdao.update((Rectangle) forme);

		}
		else if(this.forme instanceof  Triangle)
		{
			TriangleDAO cdao=(TriangleDAO) DaoFactory.getTriangleDAO();
        	cdao.update((Triangle) forme);

		}
		else if(this.forme instanceof  Form_Groupe)
		{
			Form_GroupeDAO cdao=(Form_GroupeDAO) DaoFactory.getForm_GroupeDAO();
        	try {
				cdao.update((Form_Groupe) forme);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}		
	}

}
