package Dessin.TD_Dessin.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dessin.TD_Dessin.Coordonnee;
import Dessin.TD_Dessin.Rectangle;
import Exeption.InExistTupleException;

public class RectangleDAO implements DAO<Rectangle>{
	private static String dburl = DerbyConnexion.dburl;

	@Override
	public void create(Rectangle rectangle) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = conn.prepareStatement(
					"INSERT INTO Rectangle (nomr,rx,ry,largeur,longueur)" +
					"VALUES ( ?, ? , ? , ? , ? )");
			prepare.setString(1, rectangle.getName());
			prepare.setInt(2, rectangle.getCoor().getX());
			prepare.setInt(3, rectangle.getCoor().getY());
			prepare.setInt(4, rectangle.getLargeur());
			prepare.setInt(5, rectangle.getLongueur());
			int result = prepare.executeUpdate();
			assert result == 1; 
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Rectangle rectangle) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(dburl)) {
			System.out.println("ffffffffffffffffffffff");
			PreparedStatement prepare = conn.prepareStatement("UPDATE Rectangle SET rx = ?,ry = ? WHERE nomr = ?");
			prepare.setInt(1, rectangle.getCoor().getX());
			prepare.setInt(2, rectangle.getCoor().getY());		
			prepare.setString(3, rectangle.getName().toString());
			int result = prepare.executeUpdate();
			System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrr  "+result);

			assert result == 1;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Rectangle rectangle) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = conn.prepareStatement(
					"DELETE FROM Rectangle "
					+ "WHERE nomr = ?");
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
					"SELECT * FROM Rectangle WHERE nomr = ?");
			prepare.setString(1, s);
			ResultSet result = prepare.executeQuery();
			if(result.next()) {
				Coor=new Coordonnee(result.getInt("rx"),result.getInt("ry"));
				rectangle =new Rectangle(result.getString("nomr"),Coor,result.getInt("largeur"),result.getInt("longueur"));
				
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
		return rectangle;
	}

}
