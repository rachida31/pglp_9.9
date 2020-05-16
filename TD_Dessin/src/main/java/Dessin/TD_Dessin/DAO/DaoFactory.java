package Dessin.TD_Dessin.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Dessin.TD_Dessin.Carre;
import Dessin.TD_Dessin.Cercle;
import Dessin.TD_Dessin.Form_Groupe;
import Dessin.TD_Dessin.Rectangle;
import Dessin.TD_Dessin.Triangle;
import Dessin.TD_Dessin.DAO.Form_GroupeDAO;
import Dessin.TD_Dessin.DAO.TriangleDAO;
/**
 *implemantation de la classe DaoFactory 
 *pour factory les 5 objets CarreDAO et CercleDAO,RactangleDAO,TriangleDAO et Form_GroupeDAO .
 * @author rachida ouchene.
 * 
 */
public class DaoFactory {
	/**
	 * chaine de connexion.
	 */
	private static String dburl = DerbyConnexion.dburl;
	/**
	 * attribut Connection pour fiare la connection a la base de donnée.
	 * */
	private   Connection conn;
	/**
	 * constructeur de la classe DaoFactory qui crée la connection.
	 * */
	public DaoFactory() throws SQLException
	{
		this.conn = DriverManager.getConnection(dburl);
		    }
	
	/**
     * Retourne Un objet CarreDAO .
     * 
     * @return CarreDAO.
     * 
     * 
     */
	public  DAO<Carre> getCarreDAO(){ 
		
		return (DAO<Carre>) new CarreDAO(conn);
	}
	/**
     * Retourne Un objet CercleDAO .
     * 
     * @return CercleDAO.
     * 
     * 
     */
	 public  DAO<Cercle> getCercleDAO() {
	        return new CercleDAO(conn);
	        
	    }
	 /**
	     * Retourne Un objet RectangleDAO .
	     * 
	     * @return RectangleDAO.
	     * 
	     * 
	     */
	 public  DAO<Rectangle> getRectangleDAO() {
	        return new RectangleDAO(conn);
	        
	    }
	 /**
	     * Retourne Un objet TriangleDAO .
	     * 
	     * @return TriangleDAO.
	     * 
	     * 
	     */
	 public  DAO<Triangle> getTriangleDAO() {
	        return new TriangleDAO(conn);
	        
	    }
	 /**
	     * Retourne Un objet Form_GroupeDAO .
	     * 
	     * @return Form_GroupeDAO.
	     * 
	     * 
	     */
	 public  DAO<Form_Groupe> getForm_GroupeDAO() {
	        return new Form_GroupeDAO(conn);
	        
	    }
	
}
