package Dessin.TD_Dessin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Dessin.TD_Dessin.forme.Coordonnee;
import Dessin.TD_Dessin.forme.Rectangle;
/**
 * implemantation de la classe RectangleDAO pour pouvoir creer , modifier,lire
 * et supprimer un rectangle de la base.
 * @author rachida ouchene.
 */
public class RectangleDAO implements DAO<Rectangle> {
	/**
	 * attribut Connection pour fiare la connection a la base de donnée.
	 */
	private Connection conn;
	/**
	 *int .
	 **/
	private final int a = 1,b = 2, c = 3, d = 4, e = 5;

	/**
	 * constructeur de la classe RectangleDAO initialise @see conn .
	 * @param conn1 .
	 */
	public RectangleDAO(final Connection conn1) {
		this.conn = conn1;
	}

	/**
	 * Rajoute un Rectangle a la table Rectangle de la base.
	 * @param rectangle : l'objet Rectangle a enregistrer.
	 * @exception SQLException
	 */
	@Override
	public final void create(final Rectangle rectangle) {
// TODO Auto-generated method stub
		try {
			PreparedStatement prepare = conn.prepareStatement(
					"INSERT INTO Rectangle"
					+ " (nomr,rx,"
					+ "ry,largeur,longueur)"
					+ "VALUES ( ?, ? , ? "
					+ ", ? , ? )");
			prepare.setString(a, rectangle.getName());
			prepare.setInt(b, rectangle.getCoor().getX());
			prepare.setInt(c, rectangle.getCoor().getY());
			prepare.setInt(d, rectangle.getLargeur());
			prepare.setInt(e, rectangle.getLongueur());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Modifier les valeurs rx et ry dans la base de rectangle passe en
	 * parametre apres le move.
	 * @param rectangle : le pour le quel on modiffie les coordonnees.
	 * @exception SQLException
	 */
	@Override
	public final void update(final Rectangle rectangle) {
// TODO Auto-generated method stub
		try {
			PreparedStatement prepare = conn.
					prepareStatement("UPDATE Rectangle"
					+ " SET rx = ?,ry = ? WHERE nomr = ?");
			prepare.setInt(a, rectangle.getCoor().getX());
			prepare.setInt(b, rectangle.getCoor().getY());
			prepare.setString(c, rectangle.getName().toString());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Suppression de rectangle de la table Rectangle de la base.
	 * @param rectangle : le rectangle a supprimer.
	 * @exception SQLException .
	 */
	@Override
	public final void delete(final Rectangle rectangle) {
// TODO Auto-generated method stub
		try {
			PreparedStatement prepare = conn.
					prepareStatement("DELETE FROM "
					+ "Rectangle WHERE "
					+ "nomr = ?");
			prepare.setString(a, rectangle.getName());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Recherche un Rectangle dans la
	 * table Rectangle de la base appartir
	 * de son nom.
	 * @param nom : le nom de rectangle rechercher.
	 * @return rectangle : le rectangle recherecher.
	 * @exception SQLException :une exception si y a
	 * un problemme avec l'execution de la sql.
	 */
	@Override
	public final Rectangle read(final String nom) {
// TODO Auto-generated method stub
		Coordonnee coor;
		Rectangle rectangle = null;
		try {
			PreparedStatement prepare = conn.
				prepareStatement("SELECT * FROM "
				+ "Rectangle WHERE nomr = ?");
			prepare.setString(a, nom);
			ResultSet result = prepare.executeQuery();
			if (result.next()) {
				coor = new Coordonnee(result.
				getInt("rx"), result.getInt("ry"));
				rectangle = new Rectangle(result.
				getString("nomr"), coor, result.
				getInt("largeur"),
				result.getInt("longueur"));
				result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rectangle;
	}
}
