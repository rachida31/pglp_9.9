package Dessin.TD_Dessin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Dessin.TD_Dessin.Carre;
import Dessin.TD_Dessin.Coordonnee;
import Exeption.InExistTupleException;

/**
 *implemantation de la classe CarreDAO 
 *pour pouvoir creer , modifier,lire et supprimer un Carre de la base.
 * @author rachida ouchene.
 * 
 */
public class CarreDAO implements DAO<Carre> {
	/**
	 * attribut Connection pour fiare la connection a la base de donnée.
	 * */
	private Connection conn; 
	/**
	 * constructeur de la classe CarreDAO initialise @see conn .
	 * @param conn .
	 * */
	public CarreDAO(Connection conn)
	{
		this.conn=conn;
		}
	/**
	 * Rajoute un Carre a la table carre de la base.
	 * @param carre: l'objet Carre a enregistrer.
	 *  @exception SQLException
	 * */
	@Override
	public void create(Carre carre) {
		// TODO Auto-generated method stub
		try  {
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
  /**
   *Modifier les valeurs ax et ay dans la base de carre passe en parametre apres le move. 
   *@param carre: le pour le quel on modiffie les coordonnees.  
   * @exception SQLException
   */
	@Override
	public void update(Carre carre) {
		// TODO Auto-generated method stub
		try  {
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
/**
 * Suppression de carre de la table Carre de la base.
 * @param carre : le carre a supprimer.
 *  @exception SQLException
 * */
	@Override
	public void delete(Carre carre) {
		// TODO Auto-generated method stub
		try {
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
/**
 * Recherche un carre dans la table Carre de la base appartir de son nom.
 * @param nom : le nom de carre rechercher.
 * @return carre : le carre recherecher.
 * @exception InExistTupleException 
 *  @exception SQLException
 * */
	@Override
	public Carre read(String nom) {
		// TODO Auto-generated method stub
		Coordonnee Coor;
		Carre carre = null;
		
		try  {
			PreparedStatement prepare = conn.prepareStatement(
					"SELECT * FROM Carre WHERE noma = ?");
			prepare.setString(1, nom);
			ResultSet result = prepare.executeQuery();
			if(result.next()) {
				Coor=new Coordonnee(result.getInt("ax"),result.getInt("ay"));
				carre =new Carre(result.getString("noma"),Coor,result.getInt("cote"));
				
				result.close();
				
			}
			
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return carre;
	}

}
