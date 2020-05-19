package Dessin.TD_Dessin.Commande;

import java.sql.SQLException;

import Dessin.TD_Dessin.forme.Carre;
import Dessin.TD_Dessin.forme.Cercle;
import Dessin.TD_Dessin.forme.Form_Groupe;
import Dessin.TD_Dessin.forme.Formes_Graphiques;
import Dessin.TD_Dessin.forme.Rectangle;
import Dessin.TD_Dessin.forme.Triangle;
import Dessin.TD_Dessin.DAO.CarreDAO;
import Dessin.TD_Dessin.DAO.CercleDAO;
import Dessin.TD_Dessin.DAO.DaoFactory;
import Dessin.TD_Dessin.DAO.Form_GroupeDAO;
import Dessin.TD_Dessin.DAO.RectangleDAO;
import Dessin.TD_Dessin.DAO.TriangleDAO;

/**
 * classe DeleteCommande pour la suppression soit d'un cercle ou carre
 * ,rectangle,triangle ou un groupe de forme dans la base de donnée.
 * @author rachida ouchene.
 */
public class DeleteCommande implements Commande {
	/**
	 * forme la forme que nous allons supprimer.
	 * @see DeleteCommande#DeleteCommande( Formes_Graphiques)
	 * @see DeleteCommande#execute()
	 */
	private Formes_Graphiques forme;
	/**
	 * DaoFactory de type DaoFactory.
	 * @see DeleteCommande#DeleteCommande( Formes_Graphiques)
	 * @see DeleteCommande#execute()
	 */
	private DaoFactory daof;

	/**
	 * constructeur DeleteCommande. qui initialise this.forme a forme et
	 * instancier l'objet daof de type DaoFactory.
	 * @param forme c'est un objet de type Formes_Graphiques
	 * que nous voulons supprimer.
	 * @see DeleteCommande#forme .
	 * @see DeleteCommande#daof .
	 * @throws SQLException une exception si y a
	 * un problemme avec l'execution de la sql.
	 */
	public DeleteCommande(final Formes_Graphiques forme)
			throws SQLException {
		this.forme = forme;
		this.daof = new DaoFactory();
	}

	/**
	 * Méthode execute qui fait appelle a la méthode delete selon le type de
	 * l'objet forme pour supperimer une forme dans la base.
	 * @throws Exception pour la suppression si il ya une erreur.
	 */
	@Override
	public final void execute() throws Exception {
// TODO Auto-generated method stub
		if (this.forme instanceof Cercle) {
			CercleDAO cdao = (CercleDAO) daof.getCercleDAO();
			cdao.delete((Cercle) forme);
		} else if (this.forme instanceof Carre) {
			CarreDAO cdao = (CarreDAO) daof.getCarreDAO();
			cdao.delete((Carre) forme);
		} else if (this.forme instanceof Rectangle) {
			RectangleDAO cdao = (RectangleDAO)
					daof.getRectangleDAO();
			cdao.delete((Rectangle) forme);
		} else if (this.forme instanceof Triangle) {
			TriangleDAO cdao = (TriangleDAO) daof.getTriangleDAO();
			cdao.delete((Triangle) forme);
		} else if (this.forme instanceof Form_Groupe) {
			Form_GroupeDAO cdao = (Form_GroupeDAO)
					daof.getForm_GroupeDAO();
			cdao.delete((Form_Groupe) forme);
		}
		System.out.println("     Supprission terminer! ");
	}
}
