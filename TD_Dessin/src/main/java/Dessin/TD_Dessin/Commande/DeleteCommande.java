package Dessin.TD_Dessin.Commande;

import Dessin.TD_Dessin.Carre;
import Dessin.TD_Dessin.Cercle;
import Dessin.TD_Dessin.Formes_Graphiques;
import Dessin.TD_Dessin.Rectangle;
import Dessin.TD_Dessin.Triangle;
import Dessin.TD_Dessin.DAO.CarreDAO;
import Dessin.TD_Dessin.DAO.CercleDAO;
import Dessin.TD_Dessin.DAO.DaoFactory;
import Dessin.TD_Dessin.DAO.RectangleDAO;
import Dessin.TD_Dessin.DAO.TriangleDAO;

public class DeleteCommande implements Commande {
	private Formes_Graphiques forme ;
	public DeleteCommande(Formes_Graphiques forme)
	{
		this.forme=forme;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
    	System.out.println("delete commande  ");

		if(this.forme instanceof  Cercle)
		{
        	CercleDAO cdao=(CercleDAO) DaoFactory.getCercleDAO();
        	cdao.delete((Cercle) forme);
		}
		else if(this.forme instanceof  Carre)
		{
			CarreDAO cdao=(CarreDAO) DaoFactory.getCarreDAO();
        	cdao.delete((Carre) forme);

		}
		else if(this.forme instanceof  Rectangle)
		{
			RectangleDAO cdao=(RectangleDAO) DaoFactory.getRectangleDAO();
        	cdao.delete((Rectangle) forme);

		}
		else if(this.forme instanceof  Triangle)
		{
			TriangleDAO cdao=(TriangleDAO) DaoFactory.getTriangleDAO();
        	cdao.delete((Triangle) forme);

		}
	}

}
