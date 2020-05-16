package Dessin.TD_Dessin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dessin.TD_Dessin.Cercle;
import Dessin.TD_Dessin.Coordonnee;
import Exeption.InExistTupleException;
/**
 *implemantation de la classe CercleDAO 
 *pour pouvoir creer , modifier,lire et supprimer un Cercle de la base.
 * @author rachida ouchene.
 * 
 */
public class CercleDAO implements DAO<Cercle>{
	/**
	 * attribut Connection pour fiare la connection a la base de donnée.
	 * */
	private Connection conn; 
	/**
	 * constructeur de la classe CercleDAO initialise @see conn .
	 * @param conn .
	 * */
	public CercleDAO(Connection conn)
	{
		this.conn=conn;
		}
	/**
	 * Rajoute un Cercle a la table Cercle de la base.
	 * @param ercle: l'objet Cercle a enregistrer.
	 *  @exception SQLException
	 * */
	@Override
	public void create(Cercle cercle) {
		// TODO Auto-generated method stub
		try  {
			PreparedStatement prepare = conn.prepareStatement(
					"INSERT INTO Cercle (nomc,cx,cy,rayon)" +
					"VALUES ( ?, ? , ? , ? )");
			prepare.setString(1, cercle.getName());
			prepare.setInt(2, cercle.getCentre().getX());
			prepare.setInt(3, cercle.getCentre().getY());
			prepare.setInt(4, cercle.getRayon());
			int result = prepare.executeUpdate();
			assert result == 1; 
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 /**
	   *Modifier les valeurs cx et cy dans la base de cercle passe en parametre apres le move. 
	   *@param cercle: le pour le quel on modiffie les coordonnees.  
	   * @exception SQLException
	   */
	@Override
	public void update(Cercle cercle) {
		// TODO Auto-generated method stub
		try  {
			PreparedStatement prepare = conn.prepareStatement("UPDATE Cercle SET cx = ?,cy = ? WHERE nomc = ?");
			prepare.setInt(1, cercle.getCentre().getX());
			prepare.setInt(2, cercle.getCentre().getY());		
			prepare.setString(3, cercle.getName().toString());
			int result = prepare.executeUpdate();
			assert result == 1;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Suppression de cercle de la table Cercle de la base.
	 * @param cercle : le cercle a supprimer.
	 *  @exception SQLException
	 * */
	@Override
	public void delete(Cercle cercle) {
		// TODO Auto-generated method stub
		try  {
			PreparedStatement prepare = conn.prepareStatement(
					"DELETE FROM Cercle "
					+ "WHERE nomc = ?");
			prepare.setString(1, cercle.getName());
			int result = prepare.executeUpdate();
			assert result == 1;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Recherche un cercle dans la table Cercle de la base appartir de son nom.
	 * @param nom : le nom de Cercle rechercher.
	 * @return cercle : le cercle cherecher.
	 * @exception InExistTupleException 
	 *  @exception SQLException
	 * */
	@Override
	public Cercle read(String nom) {
		// TODO Auto-generated method stub
		Coordonnee Coor;
		Cercle cercle = null;
		
		try  {
			PreparedStatement prepare = conn.prepareStatement(
					"SELECT * FROM Cercle WHERE nomc = ?");
			prepare.setString(1, nom);
			ResultSet result = prepare.executeQuery();
			if(result.next()) {
				Coor=new Coordonnee(result.getInt("cx"),result.getInt("cy"));
				cercle =new Cercle(result.getString("nomc"),Coor,result.getInt("rayon"));
				
				result.close();

			}
			}
		catch (SQLException  e) {
			e.printStackTrace();
		}
		return cercle;
	}

}
