package Dessin.TD_Dessin.DAO;
import Dessin.TD_Dessin.Carre;
import Dessin.TD_Dessin.Cercle;
import Dessin.TD_Dessin.Coordonnee;
import Dessin.TD_Dessin.Form_Groupe;
import Dessin.TD_Dessin.Rectangle;
import Dessin.TD_Dessin.Triangle;
import Dessin.TD_Dessin.DAO.Form_GroupeDAO;
import Dessin.TD_Dessin.DAO.TriangleDAO;

public class DaoFactory {
	public static DAO<Carre> getCarreDAO(){ 
		return (DAO<Carre>) new CarreDAO();
	}
	
	 public static DAO<Cercle> getCercleDAO() {
	        return new CercleDAO();
	        
	    }
	 public static DAO<Rectangle> getRectangleDAO() {
	        return new RectangleDAO();
	        
	    }
	 public static DAO<Triangle> getTriangleDAO() {
	        return new TriangleDAO();
	        
	    }
	 public static DAO<Form_Groupe> getForm_GroupeDAO() {
	        return new Form_GroupeDAO();
	        
	    }
	
}
