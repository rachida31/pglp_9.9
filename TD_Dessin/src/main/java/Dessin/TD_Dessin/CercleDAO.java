package Dessin.TD_Dessin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exeption.InExistTupleException;

public class CercleDAO implements DAO<Cercle>{
	private static String dburl = DerbyConnexion.dburl;

	@Override
	public void create(Cercle cercle) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = conn.prepareStatement(
					"INSERT INTO cercle (nom, prenom, date,fonction)" +
					"VALUES ( ?, ? , ? , ? )");
			prepare.setString(1, cercle.getName());
			prepare.setInt(2, cercle.getCentre().getX());
			prepare.setInt(3, cercle.getCentre().getY());
			int result = prepare.executeUpdate();
			assert result == 1; 
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Cercle t, Cercle obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cercle cercle) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = conn.prepareStatement(
					"DELETE FROM personnel "
					+ "WHERE nom = ?");
			prepare.setString(1, cercle.getName());
			int result = prepare.executeUpdate();
			assert result == 1;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Cercle read(String s) {
		// TODO Auto-generated method stub
		Coordonnee Coor;
		Cercle cercle = null;
		
		try (Connection conn = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = conn.prepareStatement(
					"SELECT * FROM Personnel WHERE nom = ?");
			prepare.setString(1, s);
			ResultSet result = prepare.executeQuery();
			if(result.next()) {
				Coor=new Coordonnee(result.getInt("rx"),result.getInt("ry"));
				cercle =new Cercle(result.getString("nom"),Coor,result.getInt("rayen"));
				
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
