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
					"INSERT INTO Carre (noma,ax,ay,cote)" +
					"VALUES ( ?, ? , ? , ? )");
			prepare.setString(1, carre.getName());
			prepare.setInt(2, carre.getCoor().getX());
			prepare.setInt(3, carre.getCoor().getY());
			prepare.setInt(4, carre.getCote());
			int result = prepare.executeUpdate();
			assert result == 1; 
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Carre carre) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = conn.prepareStatement("UPDATE Carre SET ax = ?,ay = ? WHERE noma = ?");
			prepare.setInt(1, carre.getCoor().getX());
			prepare.setInt(2, carre.getCoor().getY());		
			prepare.setString(3, carre.getName().toString());
			int result = prepare.executeUpdate();
			assert result == 1;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Carre carre) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = conn.prepareStatement(
					"DELETE FROM Carre "
					+ "WHERE noma = ?");
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
					"SELECT * FROM Carre WHERE noma = ?");
			prepare.setString(1, s);
			ResultSet result = prepare.executeQuery();
			if(result.next()) {
				Coor=new Coordonnee(result.getInt("ax"),result.getInt("ay"));
				carre =new Carre(result.getString("noma"),Coor,result.getInt("cote"));
				
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
		return carre;
	}

}
