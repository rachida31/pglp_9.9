package Dessin.TD_Dessin.Commande;

import Dessin.TD_Dessin.Carre;
import Dessin.TD_Dessin.Cercle;
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

public class ReadCommande implements Commande {
	private Formes_Graphiques forme ;
	public ReadCommande(Formes_Graphiques forme)
	{
		this.forme=forme;
		
	}
	@Override
	public void execute() {
    	System.out.println("read commande  ");
    	Formes_Graphiques f=null;
		// TODO Auto-generated method stub
		if(this.forme instanceof  Cercle)
		{
        	CercleDAO cdao=(CercleDAO) DaoFactory.getCercleDAO();
        	f=cdao.read(forme.getName());
		}
		else if(this.forme instanceof  Carre)
		{
			CarreDAO cdao=(CarreDAO) DaoFactory.getCarreDAO();
        	f=cdao.read(forme.getName());

		}
		else if(this.forme instanceof  Rectangle)
		{
			RectangleDAO cdao=(RectangleDAO) DaoFactory.getRectangleDAO();
        	f=cdao.read(forme.getName());

		}
		else if(this.forme instanceof  Triangle)
		{
			TriangleDAO cdao=(TriangleDAO) DaoFactory.getTriangleDAO();
        	f=cdao.read(forme.getName());

		}
		else if(this.forme instanceof  Form_Groupe)
		{
			Form_GroupeDAO cdao=(Form_GroupeDAO) DaoFactory.getForm_GroupeDAO();
        	try {
				f=cdao.read(forme.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	f.print();
	}

}
