
package Dessin.TD_Dessin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Dessin.TD_Dessin.Coordonnee;
import Dessin.TD_Dessin.Triangle;
import Exeption.InExistTupleException;

/**
 *implemantation de la classe TriangleDAO 
 *pour pouvoir creer , modifier,lire et supprimer un Triangle de la base.
 * @author rachida ouchene.
 * 
 */
public class TriangleDAO implements DAO<Triangle> {
	/**
	 * attribut Connection pour fiare la connection a la base de donnée.
	 * */
	private Connection conn; 
	/**
	 * constructeur de la classe TriangleDAO initialise @see conn .
	 * @param conn .
	 * */
	public TriangleDAO(Connection conn )
	{
		this.conn=conn;
		}
	/**
	 * Rajoute un Triangle a la table Triangle de la base.
	 * @param triangle: l'objet Triangle a enregistrer.
	 *  @exception SQLException
	 * */
	@Override
	public void create(Triangle triangle) {
		// TODO Auto-generated method stub
		try  {
			PreparedStatement prepare = conn.prepareStatement(
					"INSERT INTO Triangle (nomt, tx1,ty1,tx2,ty2,tx3,ty3)" +
					"VALUES (? , ? , ? , ? , ? ,? , ?)");
			prepare.setString(1, triangle.getName());
			prepare.setInt(2, triangle.getCoor1().getX());
			prepare.setInt(3, triangle.getCoor1().getY());
			prepare.setInt(4, triangle.getCoor2().getX());
			prepare.setInt(5, triangle.getCoor2().getY());
			prepare.setInt(6, triangle.getCoor3().getX());
			prepare.setInt(7, triangle.getCoor3().getY());
			int result = prepare.executeUpdate();
			assert result == 1; 
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 /**
	   *Modifier les valeurs tx1 et t1,tx2 et ty2 , tx3 et ty3 dans la base de triangle passe en parametre apres le move. 
	   *@param triangle: le pour le quel on modiffie les coordonnees.  
	   * @exception SQLException
	   */
	@Override
	public void update(Triangle triangle) {
		// TODO Auto-generated method stub
		try{
			PreparedStatement prepare = conn.prepareStatement("UPDATE Triangle SET tx1 = ?,ty1 = ? ,tx2 = ?,ty2 = ? , tx3 = ?,ty3 = ? WHERE nomt = ?");
			prepare.setInt(1, triangle.getCoor1().getX());
			prepare.setInt(2, triangle.getCoor1().getY());
			prepare.setInt(3, triangle.getCoor2().getX());
			prepare.setInt(4, triangle.getCoor2().getY());
			prepare.setInt(5, triangle.getCoor3().getX());
			prepare.setInt(6, triangle.getCoor3().getY());
			prepare.setString(7, triangle.getName().toString());
			int result = prepare.executeUpdate();
			assert result == 1;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Suppression de triangle de la table Triangle de la base.
	 * @param triangle : le triangle a supprimer.
	 *  @exception SQLException
	 * */
	@Override
	public void delete(Triangle triangle) {
		// TODO Auto-generated method stub
		try  {
			PreparedStatement prepare = conn.prepareStatement(
					"DELETE FROM Triangle "
					+ "WHERE nomt = ?");
			prepare.setString(1, triangle.getName());
			int result = prepare.executeUpdate();
			assert result == 1;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * ReCherche un Triangle dans la table Triangle de la base appartir de son nom.
	 * @param nom : le nom de Triangle rechercher.
	 * @return triangle : le Triangle recherecher.
	 * @exception InExistTupleException 
	 *  @exception SQLException
	 * */
	@Override
	public Triangle read(String s) {
		// TODO Auto-generated method stub
		Coordonnee Coor1;
		 Coordonnee Coor2;
		 Coordonnee Coor3;
		Triangle triangle = null;
		
		try  {
			PreparedStatement prepare = conn.prepareStatement(
					"SELECT * FROM Triangle WHERE nomt = ?");
			prepare.setString(1, s);
			ResultSet result = prepare.executeQuery();
			if(result.next()) {
				Coor1=new Coordonnee(result.getInt("tx1"),result.getInt("ty1"));
				Coor2=new Coordonnee(result.getInt("tx2"),result.getInt("ty2"));
				Coor3=new Coordonnee(result.getInt("tx3"),result.getInt("ty3"));
				triangle =new Triangle(result.getString("nomt"),Coor1,Coor2,Coor3);
				
				result.close();
				
			}
			
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return triangle;
	}

}
