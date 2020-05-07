package Dessin.TD_Dessin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exeption.InExistTupleException;

public class RectangleDAO implements DAO<Rectangle>{
	private static String dburl = DerbyConnexion.dburl;

	@Override
	public void create(Rectangle rectangle) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = conn.prepareStatement(
					"INSERT INTO Carre (nom, prenom, date,fonction)" +
					"VALUES ( ?, ? , ? , ? )");
			prepare.setString(1, rectangle.getName());
			prepare.setInt(2, rectangle.getCoor().getX());
			prepare.setInt(3, rectangle.getCoor().getY());
			int result = prepare.executeUpdate();
			assert result == 1; 
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Rectangle t, Rectangle obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Rectangle rectangle) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = conn.prepareStatement(
					"DELETE FROM personnel "
					+ "WHERE nom = ?");
			prepare.setString(1, rectangle.getName());
			int result = prepare.executeUpdate();
			assert result == 1;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Rectangle read(String s) {
		// TODO Auto-generated method stub
		Coordonnee Coor;
		Rectangle rectangle = null;
		
		try (Connection conn = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = conn.prepareStatement(
					"SELECT * FROM Personnel WHERE nom = ?");
			prepare.setString(1, s);
			ResultSet result = prepare.executeQuery();
			if(result.next()) {
				Coor=new Coordonnee(result.getInt("rx"),result.getInt("ry"));
				rectangle =new Rectangle(result.getString("nom"),Coor,result.getInt("largeur"),result.getInt("longueur"));
				
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
