
package Dessin.TD_Dessin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Dessin.TD_Dessin.forme.Coordonnee;
import Dessin.TD_Dessin.forme.Triangle;

/**
 * implemantation de la classe TriangleDAO pour pouvoir creer , modifier,lire et
 * supprimer un Triangle de la base.
 * @author rachida ouchene.
 */
public class TriangleDAO implements DAO<Triangle> {
	/**
	 * attribut Connection pour fiare la connection a la base de donnée.
	 */
	private Connection conn;
	/**
	 * int .
	 * */
	private final int a = 1,b = 2, c = 3, d = 4, e = 5, f = 6, g = 7;
	/**
	 * constructeur de la classe TriangleDAO initialise @see conn .
	 * @param conn1 .
	 */
	public TriangleDAO(final Connection conn1) {
		this.conn = conn1;
	}

	/**
	 * Rajoute un Triangle a la table Triangle de la base.
	 * @param triangle : l'objet Triangle a enregistrer.
	 * @exception SQLException
	 */
	@Override
	public final void create(final Triangle triangle) {
// TODO Auto-generated method stub
		try {
			PreparedStatement prepare = conn.
					prepareStatement(
					"INSERT INTO Triangle "
					+ "(nomt, tx1,ty1,tx2,"
					+ "ty2,tx3,ty3)"
					+ "VALUES (? , ? , "
					+ "? , ? , ? ,? , ?)");
			prepare.setString(a, triangle.getName());
			prepare.setInt(b, triangle.getCoor1().getX());
			prepare.setInt(c, triangle.getCoor1().getY());
			prepare.setInt(d, triangle.getCoor2().getX());
			prepare.setInt(e, triangle.getCoor2().getY());
			prepare.setInt(f, triangle.getCoor3().getX());
			prepare.setInt(g, triangle.getCoor3().getY());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Modifier les valeurs tx1 et t1,tx2
	 * et ty2 , tx3 et ty3 dans la base de
	 * triangle passe en parametre apres le move.
	 * @param triangle : le pour le quel on modiffie les coordonnees.
	 * @exception SQLException
	 */
	@Override
	public final void update(final Triangle triangle) {
// TODO Auto-generated method stub
		try {
			PreparedStatement prepare = conn.
					prepareStatement(
					"UPDATE Triangle SET "
					+ "tx1 = ?,ty1 = ? ,"
					+ "tx2 = ?,ty2 = ? , "
					+ "tx3 = ?,ty3 = ?"
					+ " WHERE nomt = ?");
			prepare.setInt(a, triangle.getCoor1().getX());
			prepare.setInt(b, triangle.getCoor1().getY());
			prepare.setInt(c, triangle.getCoor2().getX());
			prepare.setInt(d, triangle.getCoor2().getY());
			prepare.setInt(e, triangle.getCoor3().getX());
			prepare.setInt(f, triangle.getCoor3().getY());
			prepare.setString(g, triangle.getName().toString());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Suppression de triangle de la table Triangle de la base.
	 * @param triangle : le triangle a supprimer.
	 * @exception SQLException
	 */
	@Override
	public final void delete(final Triangle triangle) {
// TODO Auto-generated method stub
		try {
			PreparedStatement prepare = conn.
					prepareStatement("DELETE FROM "
					+ "Triangle " + "WHERE nomt = ?");
			prepare.setString(a, triangle.getName());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ReCherche un Triangle dans la table
	 * Triangle de la base appartir de son nom.
	 * @param nom : le nom de Triangle rechercher.
	 * @return triangle : le Triangle recherecher.
	 * @exception SQLException :une exception si y a
	 * un problemme avec l'execution de la sql.
	 */
	@Override
	public final Triangle read(final String nom) {
// TODO Auto-generated method stub
		Coordonnee coor1;
		Coordonnee coor2;
		Coordonnee coor3;
		Triangle triangle = null;
		try {
			PreparedStatement prepare = conn.
					prepareStatement("SELECT * FROM"
					+ " Triangle WHERE nomt = ?");
			prepare.setString(1, nom);
			ResultSet result = prepare.executeQuery();
			if (result.next()) {
				coor1 = new Coordonnee(result.
						getInt("tx1"),
						result.getInt("ty1"));
				coor2 = new Coordonnee(result.
						getInt("tx2"),
						result.getInt("ty2"));
				coor3 = new Coordonnee(result.
						getInt("tx3"),
						result.getInt("ty3"));
				triangle = new Triangle(result.
						getString("nomt"), coor1,
						coor2, coor3);
				result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return triangle;
	}
}
