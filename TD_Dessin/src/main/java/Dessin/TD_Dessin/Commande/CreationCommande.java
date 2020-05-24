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
 * classe CreationCommande pour la creation soit 'un cercle ou carre
 * ,rectangle,triangle ou un groupe de forme dans la base de donnée .
 * @author rachida ouchene.
 */
public class CreationCommande implements Commande {
/**
* forme la forme que nous allons créer.
* @see CreationCommande#CreationCommande( Formes_Graphiques)
* @see CreationCommande#execute()
*/
private Formes_Graphiques forme;
/**
* DaoFactory de type DaoFactory.
* @see CreationCommande#CreationCommande( Formes_Graphiques)
* @see CreationCommande#execute()
*/
private DaoFactory daof;
/**
* constructeur CreationCommande. qui initialise this.forme a forme et
* instancier \n l'objet daof de type DaoFactory.
* @param forme1 c'est un objet de type Formes_Graphiques on a crée.
* @see CreationCommande#forme .
* @see CreationCommande#daof .
* @throws SQLException si y a un problemme dans la base.
**/
public CreationCommande(final Formes_Graphiques forme1) throws
SQLException {
this.forme = forme1;
this.daof = new DaoFactory();
}
/**
* Méthode execute qui fait appelle a la méthode create selon le type de
* l'objet forme pour enregistrer une forme dans la base.
* @throws Exception si y a un problemme avec les formes l'heure de la
* creation.
**/
@Override
public final void execute() throws Exception {
// TODO Auto-generated method stub
if (this.forme instanceof Cercle) {
CercleDAO cdao = (CercleDAO) daof.getCercleDAO();
cdao.create((Cercle) forme);
} else if (this.forme instanceof Carre) {
CarreDAO cdao = (CarreDAO) daof.getCarreDAO();
cdao.create((Carre) forme);
} else if (this.forme instanceof Triangle) {
TriangleDAO cdao = (TriangleDAO) daof.getTriangleDAO();
cdao.create((Triangle) forme);
} else if (this.forme instanceof Rectangle) {
RectangleDAO cdao = (RectangleDAO) daof.getRectangleDAO();
cdao.create((Rectangle) forme);
} else if (this.forme instanceof Form_Groupe) {
Form_GroupeDAO cdao = (Form_GroupeDAO) daof.getForm_GroupeDAO();
cdao.create((Form_Groupe) forme);
}
System.out.println("Creation terminer!");
}
}
