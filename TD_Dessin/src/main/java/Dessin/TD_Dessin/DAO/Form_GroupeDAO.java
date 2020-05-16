package Dessin.TD_Dessin.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Dessin.TD_Dessin.Carre;
import Dessin.TD_Dessin.Cercle;
import Dessin.TD_Dessin.Form_Groupe;
import Dessin.TD_Dessin.Formes_Graphiques;
import Dessin.TD_Dessin.Rectangle;
import Dessin.TD_Dessin.Triangle;
import Exeption.InExistTupleException;

/**
 *implemantation de la classe Form_GroupeDAO 
 *pour pouvoir creer , modifier,lire et supprimer un groupr de forme  de la base.
 * @author rachida ouchene.
 * 
 */

public class Form_GroupeDAO implements DAO<Form_Groupe>{
	/**
	 * attribut Connection pour fiare la connection a la base de donnée.
	 * */
	private Connection conn; 
	/**
	 * constructeur de la classe Form_GroupeDAO initialise @see conn .
	 * @param conn .
	 * */
	public Form_GroupeDAO(Connection conn)
	{
		this.conn=conn;
		}
	/**
	 * Rajoute un groupe a la table GroupeForme de la base.
	 * @param groupe: l'objet Form_Groupe a enregistrer.
	 *  @exception SQLException
	 * */
	@Override
	public void create(Form_Groupe groupe) throws Exception {
		// TODO Auto-generated method stub
		try  {
			PreparedStatement prepare = conn.prepareStatement(
					"INSERT INTO GroupeForme (Name)" +
					"VALUES (?)");
			prepare.setString(1, groupe.getName());
			int result = prepare.executeUpdate();
			assert result == 1;
			ArrayList<Formes_Graphiques> listeForme = groupe.getForme();
			int i=0;
					while(i<listeForme.size())
					{
						i++;
					}
			for (Formes_Graphiques forme : listeForme) {
				prepare = conn.prepareStatement(
						"INSERT INTO Approprier (nomForme,NomGroupe)"
						+ "VALUES (?, ?)");
				prepare.setString(1, forme.getName());
				prepare.setString(2, groupe.getName());
				//int result1 =
						prepare.executeUpdate();
			}
		
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	 /**
	   *Modifier les coordonnees de les formes que son Approprier a le groupe passer en parametre
	   * dans la base apres le move. 
	   *@param groupe: le groupe pour le quel on modiffie les coordonnees.  
	   * @exception SQLException
	   */
	@Override
	public void update(Form_Groupe groupe1) throws Exception {
		// TODO Auto-generated method stub
		try {
			System.out.println("Recherche ");
			PreparedStatement prepare = conn.prepareStatement(
					"SELECT * FROM Approprier WHERE NomGroupe = ?");
			prepare.setString(1,groupe1.getName());
			ArrayList<Formes_Graphiques> listeForme =groupe1.getForme();

			ResultSet result = prepare.executeQuery();
			  CercleDAO cercle = new CercleDAO(conn) ;
			  CarreDAO carre = new CarreDAO(conn);
			  RectangleDAO rectangle = new RectangleDAO(conn);
			  TriangleDAO triangle =new TriangleDAO(conn);
			  Cercle cercle1 =null;
			  Carre carre1 = null;
			  Rectangle rectangle1 = null;
			  Triangle triangle1 =null;
			  int i=0;
			while (result.next()){
				  if(cercle.read(result.getString("nomForme")) instanceof Cercle) 
				  {	  cercle1=(Cercle) listeForme.get(i);
					  cercle.update(cercle1);
					  i++;

				  }
				  else if(triangle.read(result.getString("nomForme")) instanceof Triangle) 
				  { triangle1=(Triangle) listeForme.get(i);
				  triangle.update(triangle1);
				  i++;

				  }
				  else if(carre.read(result.getString("nomForme")) instanceof Carre) 
				  {	carre1=(Carre) listeForme.get(i);
				  carre.update(carre1);
				  i++;

				  }
				  else if(rectangle.read(result.getString("nomForme")) instanceof Rectangle) 
				  { rectangle1=(Rectangle) listeForme.get(i);
				  rectangle.update(rectangle1);	
				  i++;

				  }
				  }
			}
		catch (SQLException e) {
			e.printStackTrace();
	}

	}
	/**
	 * Suppression de groupe de la table Groupe et les le nom de groupe
	 *  avec le nom de ces formes dans la table Approprier
	 *  de la base.
	 * @param groupe : le groupe a supprimer.
	 *  @exception SQLException
	 * */
	@Override
	public void delete(Form_Groupe groupe) throws Exception {
		// TODO Auto-generated method stub
		try  {
			PreparedStatement prepare = conn.prepareStatement(
					"DELETE FROM GroupeForme "
					+ "WHERE Name = ?");
			prepare.setString(1, groupe.getName());
			int result = prepare.executeUpdate();
			assert result == 1;			
			ArrayList<Formes_Graphiques> listeForme = groupe.getForme();
			
			for (Formes_Graphiques forme : listeForme) {
				 prepare = conn.prepareStatement(
							"DELETE FROM Approprier "
							+ "WHERE NomGroupe = ? "
						 	+ "and nomForme = ? ");
				 prepare.setString(1, groupe.getName());
				 prepare.setString(2, forme.getName());
				 int result1 = prepare.executeUpdate();
					assert result1 ==1 ;

	}

		

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Recherche un groupe de forme dans la table GroupeForme de la base appartir de son nom.
	 * @param nom : le nom de groupe rechercher.
	 * @return groupe : le groupe recherecher.
	 * @exception InExistTupleException 
	 *  @exception SQLException
	 * */
	@Override
	public Form_Groupe read(String nom) throws Exception {
		// TODO Auto-generated method stub
		Form_Groupe groupe = null;
		try  {
			PreparedStatement prepare = conn.prepareStatement(
					"SELECT * FROM Approprier WHERE NomGroupe = ?");
			prepare.setString(1, nom);

			ResultSet result = prepare.executeQuery();
				ArrayList<Formes_Graphiques> listeForme =new ArrayList<Formes_Graphiques>();
			  CercleDAO cercle = new CercleDAO(conn) ;
			  CarreDAO carre = new CarreDAO(conn);
			  RectangleDAO rectangle = new RectangleDAO(conn);
			  TriangleDAO triangle =new TriangleDAO(conn);
			  boolean bool=false;
			while (result.next()){

				bool=true;
				  if(cercle.read(result.getString("nomForme")) instanceof Cercle) 
				  { 
					  listeForme.add(cercle.read(result.getString("nomForme")));
				  }
				  else if(triangle.read(result.getString("nomForme")) instanceof Triangle) 
				  {						 
					  listeForme.add(triangle.read(result.getString("nomForme")));
				  }
				  else if(carre.read(result.getString("nomForme")) instanceof Carre) 
				  {		
					  listeForme.add(carre.read(result.getString("nomForme")));
				  }
				  else if(rectangle.read(result.getString("nomForme")) instanceof Rectangle) 
				  {					
					  listeForme.add(rectangle.read(result.getString("nomForme")));
				  }
				  }
			if(bool) {
		 groupe = new Form_Groupe(listeForme,nom);
			}
			
				
		}
		catch (SQLException  e) {
			e.printStackTrace();
	}
		return groupe;	
}
	
	}
