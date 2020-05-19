package Dessin.TD_Dessin.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Dessin.TD_Dessin.forme.Carre;
import Dessin.TD_Dessin.forme.Cercle;
import Dessin.TD_Dessin.forme.Form_Groupe;
import Dessin.TD_Dessin.forme.Rectangle;
import Dessin.TD_Dessin.forme.Triangle;
/**
 * implemantation de la classe DaoFactory pour factory les 5 objets CarreDAO et
 * CercleDAO,RactangleDAO,TriangleDAO et Form_GroupeDAO .
 * @author rachida ouchene.
 */
public class DaoFactory {
	/**
	 * chaine de connexion.
	 */
	private static String dburl = DerbyConnexion.dburl;
	/**
	 * attribut Connection pour fiare la connection a la base de donnée.
	 */
	private Connection conn;

	/**
	 * constructeur de la classe DaoFactory qui crée la connection.
	 * @throws SQLException une exception si y a
	 * un problemme avec l'execution de la sql.
	 */
	public DaoFactory() throws SQLException {
		this.conn = DriverManager.getConnection(dburl);
	}

	/**
	 * Retourne Un objet CarreDAO .
	 * @return CarreDAO.
	 */
	public final DAO<Carre> getCarreDAO() {
		return (DAO<Carre>) new CarreDAO(conn);
	}

	/**
	 * Retourne Un objet CercleDAO .
	 * @return CercleDAO.
	 */
	public final DAO<Cercle> getCercleDAO() {
		return new CercleDAO(conn);
	}

	/**
	 * Retourne Un objet RectangleDAO .
	 * @return RectangleDAO.
	 */
	public final DAO<Rectangle> getRectangleDAO() {
		return new RectangleDAO(conn);
	}

	/**
	 * Retourne Un objet TriangleDAO .
	 * @return TriangleDAO.
	 */
	public final DAO<Triangle> getTriangleDAO() {
		return new TriangleDAO(conn);
	}

	/**
	 * Retourne Un objet Form_GroupeDAO .
	 * @return Form_GroupeDAO.
	 */
	public final DAO<Form_Groupe> getForm_GroupeDAO() {
		return new Form_GroupeDAO(conn);
	}
}
