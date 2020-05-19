package Dessin.TD_Dessin.Commande;

import java.sql.SQLException;
import Dessin.TD_Dessin.forme.Carre;
import Dessin.TD_Dessin.forme.Cercle;
import Dessin.TD_Dessin.forme.Coordonnee;
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
 * classe MoveCommande pour la modiffier soit  les coordonnees d'un cercle ou
 * carre ,rectangle,triangle ou un groupe de forme dans la base de donnée.
 * @author rachida ouchene.
 */
public class MoveCommande implements Commande {
	/**
	 * forme la forme que nous allons modiffier.
	 * @see MoveCommande#MoveCommande( Formes_Graphiques,Coordonnee)
	 * @see MoveCommande#execute()
	 */
	private Formes_Graphiques forme;
	/**
	 * Le deplacement de la forme.
	 * @see MoveCommande#MoveCommande( Formes_Graphiques,Coordonnee)
	 * @see MoveCommande#execute()
	 */
	private Coordonnee coor;
	/**
	 * DaoFactory de type DaoFactory.
	 * @see MoveCommande#MoveCommande( Formes_Graphiques,Coordonnee)
	 * @see MoveCommande#execute()
	 */
	private DaoFactory daof;

	/**
	 * constructeur MoveCommande. qui initialise this.forme a
	 * forme et this.coor a coor et  instancier l'objet daof de type
	 * DaoFactory.
	 * @param forme c'est un objet de type Formes_Graphiques
	 * que nous voulons modiffier.
	 * @param coor  est un objet de type Coordonnee.
	 * @see MoveCommande#forme .
	 * @see MoveCommande#coor .
	 * @see MoveCommande#daof .
	 * @throws SQLException une exception si y a
	 * un problemme avec l'execution de la sql.
	 */
	public MoveCommande(final Formes_Graphiques forme, final Coordonnee coor)
			throws SQLException {
		this.forme = forme;
		this.coor = coor;
		this.daof = new DaoFactory();
	}

	/**
	 * Méthode execute qui fait appelle a la méthode
	 * update selon le type de
	 * l'objet forme pour modiffier les coordonnee de la forme dans la base.
	 */
	@Override
	public final void execute() {
// TODO Auto-generated method stub
		this.forme.move(coor.getX(), coor.getY());
		if (this.forme instanceof Cercle) {
			CercleDAO cdao = (CercleDAO) daof.getCercleDAO();
			cdao.update((Cercle) forme);
		} else if (this.forme instanceof Carre) {
			CarreDAO cdao = (CarreDAO) daof.getCarreDAO();
			cdao.update((Carre) forme);
		} else if (this.forme instanceof Rectangle) {
			RectangleDAO cdao = (RectangleDAO)
					daof.getRectangleDAO();
			cdao.update((Rectangle) forme);
		} else if (this.forme instanceof Triangle) {
			TriangleDAO cdao = (TriangleDAO) daof.getTriangleDAO();
			cdao.update((Triangle) forme);
		} else if (this.forme instanceof Form_Groupe) {
			Form_GroupeDAO cdao = (Form_GroupeDAO)
					daof.getForm_GroupeDAO();
			try {
				cdao.update((Form_Groupe) forme);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("    Deplacement effictuer!  ");
	}
}
