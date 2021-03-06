package Dessin.TD_Dessin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Dessin.TD_Dessin.forme.Cercle;
import Dessin.TD_Dessin.forme.Coordonnee;
/**
 * implemantation de la classe CercleDAO pour pouvoir creer , modifier,lire et
 * supprimer un Cercle de la base.
 * @author rachida ouchene.
 */
public class CercleDAO implements DAO<Cercle> {
	/**
	 * attribut Connection pour fiare la connection a la base de donnée.
	 */
	private Connection conn;
	/**
	 *int . 
	 **/
	private final int a = 1,b = 2, c = 3, d = 4;

	/**
	 * constructeur de la classe CercleDAO initialise @see conn .
	 * @param conn1 .
	 */
	public CercleDAO(final Connection conn1) {
		this.conn = conn1;
	}

	/**
	 * Rajoute un Cercle a la table Cercle de la base.
	 * @param cercle : l'objet Cercle a enregistrer.
	 * @exception SQLException une exception si y a
	 * un problemme avec l'execution de la sql.
	 */
	@Override
	public final void create(final Cercle cercle) {
// TODO Auto-generated method stub
		try {
			PreparedStatement prepare = conn
					.prepareStatement(
							"INSERT INTO "
							+ "Cercle "
							+ "(nomc,cx,cy,rayon)"
							+ "VALUES ( ?, ? ,"
							+ " ? , ? )");
			prepare.setString(a, cercle.getName());
			prepare.setInt(b, cercle.getCentre().getX());
			prepare.setInt(c, cercle.getCentre().getY());
			prepare.setInt(d, cercle.getRayon());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Modifier les valeurs cx et cy dans la base de cercle passe
	 * en parametre apres le move.
	 * @param cercle : le pour le quel on modiffie les coordonnees.
	 * @exception SQLException une exception si y a
	 * un problemme avec l'execution de la sql.
	 */
	@Override
	public final void update(final Cercle cercle) {
// TODO Auto-generated method stub
		try {
			PreparedStatement prepare = conn.prepareStatement(
					"UPDATE Cercle "
					+ "SET " + "cx = ?,"
					+ "cy = ? WHERE nomc = ?");
			prepare.setInt(a, cercle.getCentre().getX());
			prepare.setInt(b, cercle.getCentre().getY());
			prepare.setString(c, cercle.getName().toString());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Suppression de cercle de la table Cercle de la base.
	 * @param cercle : le cercle a supprimer.
	 * @exception SQLException
	 */
	@Override
	public final void delete(final Cercle cercle) {
// TODO Auto-generated method stub
		try {
			PreparedStatement prepare = conn.prepareStatement(
					"DELETE FROM "
					+ "Cercle " + "WHERE nomc = ?");
			prepare.setString(a, cercle.getName());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Recherche un cercle dans la table Cercle de la
	 * base appartir de son nom.
	 * @param nom : le nom de Cercle rechercher.
	 * @return cercle : le cercle cherecher.
	 * @exception SQLException :une exception si y a
	 * un problemme avec l'execution de la sql.
	 */
	@Override
	public final Cercle read(final String nom) {
// TODO Auto-generated method stub
		Coordonnee coor;
		Cercle cercle = null;
		try {System.out.println("hhhhhhhhhhhhhhh");
			PreparedStatement prepare = conn.prepareStatement(
					"SELECT * "
					+ "FROM Cercle WHERE"
					+ " nomc = ?");
			prepare.setString(a, nom);
			ResultSet result = prepare.executeQuery();
			if (result.next()) {
				coor = new Coordonnee(result.getInt("cx"),
						result.getInt("cy"));
				cercle = new Cercle(result.getString("nomc"),
							coor,
							result.getInt("rayon"));
				result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cercle;
	}
}
