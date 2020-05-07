package Dessin.TD_Dessin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exeption.InExistTupleException;


public class CarreDAO implements DAO<Carre> {
	private static String dburl = DerbyConnexion.dburl;

	@Override
	public void create(Carre carre) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = conn.prepareStatement(
					"INSERT INTO Carre (nom, prenom, date,fonction)" +
					"VALUES ( ?, ? , ? , ? )");
			prepare.setString(1, carre.getName());
			prepare.setInt(2, carre.getCoor().getX());
			prepare.setInt(3, carre.getCoor().getY());
			int result = prepare.executeUpdate();
			assert result == 1; 
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Carre t, Carre obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Carre carre) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = conn.prepareStatement(
					"DELETE FROM personnel "
					+ "WHERE nom = ?");
			prepare.setString(1, carre.getName());
			int result = prepare.executeUpdate();
			assert result == 1;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Carre read(String s) {
		// TODO Auto-generated method stub
		Coordonnee Coor;
		Carre carre = null;
		
		try (Connection conn = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = conn.prepareStatement(
					"SELECT * FROM Personnel WHERE nom = ?");
			prepare.setString(1, s);
			ResultSet result = prepare.executeQuery();
			if(result.next()) {
				Coor=new Coordonnee(result.getInt("rx"),result.getInt("ry"));
				carre =new Carre(result.getString("nom"),Coor,result.getInt("cote"));
				
				result.close();
				
			}
			else
			{
				throw new InExistTupleException();
			}
			}
		catch (SQLException | Exeption.InExistTupleException e) {
			e.printStackTrace();
		}
		return null;
	}

}
