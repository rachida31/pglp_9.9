package Dessin.TD_Dessin.Commande;

import java.sql.SQLException;
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
/**
*classe FindCommande pour la lire soit 'un cercle ou carre 
*,rectangle,triangle ou un groupe de forme dans la base de donnée..
* @author rachida ouchene.
*/
public class FindCommande implements Commande {
	/**  forme la forme que nous allons lire.
	    * @see FindCommande#FindCommande( Formes_Graphiques)
	    * @see FindCommande#execute()
	    */
	private Formes_Graphiques forme ;
	/**  DaoFactory de type DaoFactory.
	    *@see ReadCommande#ReadCommande( Formes_Graphiques)
	    * @see ReadCommande#execute()
	    */
	private DaoFactory daof;
	
	/**
	 * constructeur ReadCommande.
	 * qui initialise this.forme a forme et instancier l'objet daof de type DaoFactory.
	 * @param forme c'est un objet de type Formes_Graphiques que nous voulons lire.
	 * @see ReadCommande#forme .
	 * @see ReadCommande#daof .
	 * @exception SQLException
	 * */
	public FindCommande( Formes_Graphiques forme) throws SQLException
	{
		this.forme=forme;
		this.daof=new DaoFactory(); 

	}
	/**
	 * Méthode execute qui fait appelle a la méthode print selon le type de l'objet forme  pour 
	 * afficher la forme recharcher par l'utilisateur.
	 * 
	 * */
	@Override
	public void execute() {
    	Formes_Graphiques f=null;
		// TODO Auto-generated method stub
    	System.out.println("  Voila la forme que vous recherchez");
		if(this.forme instanceof  Cercle)
		{
        	CercleDAO cdao=(CercleDAO) daof.getCercleDAO();
        	f=cdao.read(forme.getName());
		}
		else if(this.forme instanceof  Carre)
		{
			CarreDAO cdao=(CarreDAO) daof.getCarreDAO();
        	f=cdao.read(forme.getName());

		}
		else if(this.forme instanceof  Rectangle)
		{
			RectangleDAO cdao=(RectangleDAO) daof.getRectangleDAO();
        	f=cdao.read(forme.getName());

		}
		else if(this.forme instanceof  Triangle)
		{
			TriangleDAO cdao=(TriangleDAO) daof.getTriangleDAO();
        	f=cdao.read(forme.getName());

		}
		else if(this.forme instanceof  Form_Groupe)
		{
			Form_GroupeDAO cdao=(Form_GroupeDAO) daof.getForm_GroupeDAO();
        	try {
				f=cdao.read(forme.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		f.print();
	}
	

}
