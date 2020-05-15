package Dessin.TD_Dessin.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
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



public class Form_GroupeDAO implements DAO<Form_Groupe>{
	private static String dburl = DerbyConnexion.dburl;

	@Override
	public void create(Form_Groupe groupe) throws Exception {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = conn.prepareStatement(
					"INSERT INTO GroupeForme (Name)" +
					"VALUES (?)");
			prepare.setString(1, groupe.getName());
			int result = prepare.executeUpdate();
			assert result == 1; // Nombre de tuples affectés = 1
			ArrayList<Formes_Graphiques> listeForme = groupe.getForme();
			int i=0;
					while(i<listeForme.size())
					{
						System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@  "+listeForme.get(i));
						i++;
					}
			for (Formes_Graphiques forme : listeForme) {
				System.out.println("nnnnnnnnnnnnnnnnnnnn nnnnnnnnnnnn  "+groupe.getName()+ " nnn "+ forme.getName());
				prepare = conn.prepareStatement(
						"INSERT INTO Approprier (nomForme,NomGroupe)"
						+ "VALUES (?, ?)");
				prepare.setString(1, forme.getName());
				prepare.setString(2, groupe.getName());
				int result1 = prepare.executeUpdate();
			
					System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkk kkkkkkkkkkkkk "+ result1);
				
			}
		
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Form_Groupe groupe1) throws Exception {
		// TODO Auto-generated method stub
		//Form_Groupe groupe = null;
		try (Connection conn = DriverManager.getConnection(dburl)) {
			System.out.println("Recherche ");
			PreparedStatement prepare = conn.prepareStatement(
					"SELECT * FROM Approprier WHERE NomGroupe = ?");
			prepare.setString(1,groupe1.getName());
			ArrayList<Formes_Graphiques> listeForme =groupe1.getForme();

			ResultSet result = prepare.executeQuery();
			  System.out.println("voilaaaaaaaaaaa 000000000   "+result.getFetchSize());
			  CercleDAO cercle = new CercleDAO() ;
			  CarreDAO carre = new CarreDAO();
			  RectangleDAO rectangle = new RectangleDAO();
			  TriangleDAO triangle = new TriangleDAO();
			  Cercle cercle1 =null;
			  Carre carre1 = null;
			  Rectangle rectangle1 = null;
			  Triangle triangle1 =null;
			 // System.out.println("voilaaaaaaaaaaa 11111111  "+result.next());
int i=0;
			while (result.next()){
				  System.out.println("voilaaaaaaaaaaa 11111111  "+ result.getString("nomForme"));
				  System.out.println (triangle.read(result.getString("nomForme")) instanceof Triangle); //vrai  

				  if(cercle.read(result.getString("nomForme")) instanceof Cercle) 
				  {		  System.out.println("voilaaaaaaaaaaa ccccccccccccccccc ");
				  	  cercle1=(Cercle) listeForme.get(i);
					  cercle.update(cercle1);
					  i++;

				  }
				  else if(triangle.read(result.getString("nomForme")) instanceof Triangle) 
				  {						  System.out.println("voilaaaaaaaaaaa ttttttttttttttt");

				  triangle1=(Triangle) listeForme.get(i);
				  triangle.update(triangle1);
				  i++;

				  }
				  else if(carre.read(result.getString("nomForme")) instanceof Carre) 
				  {						  System.out.println("voilaaaaaaaaaaa aaaaaaaaaaaaaaa");

				  carre1=(Carre) listeForme.get(i);
				  carre.update(carre1);
				  i++;

				  }
				  else if(rectangle.read(result.getString("nomForme")) instanceof Rectangle) 
				  {						  System.out.println("voilaaaaaaaaaaa rrrrrrrrrrrrrr");

				  rectangle1=(Rectangle) listeForme.get(i);
				  rectangle.update(rectangle1);	
				  i++;

				  }
				  }

			
			
				
		}
		catch (SQLException e) {
			e.printStackTrace();
	}

	}

	@Override
	public void delete(Form_Groupe groupe) throws Exception {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = conn.prepareStatement(
					"DELETE FROM GroupeForme "
					+ "WHERE Name = ?");
			prepare.setString(1, groupe.getName());
			int result = prepare.executeUpdate();
			System.out.println("Suppressionvvvvvvvvvvvvvvvvvv " + result);

			assert result == 1;
			System.out.println("Suppression " + result);
			
			ArrayList<Formes_Graphiques> listeForme = groupe.getForme();
			
			for (Formes_Graphiques forme : listeForme) {
				System.out.println("zzzzzzzzzzzzzzzzzzzzzzz   "+groupe.getName()+" ggggggggggggggg  "+forme.getName());
				 prepare = conn.prepareStatement(
							"DELETE FROM Approprier "
							+ "WHERE NomGroupe = ? "
						 	+ "and nomForme = ? ");
				 prepare.setString(1, groupe.getName());
				 prepare.setString(2, forme.getName());
				 int result1 = prepare.executeUpdate();
					System.out.println("jjjjjjjjjjjjjjjjjjjjjj   "+result);
					assert result1 ==1 ;

	}

		

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Form_Groupe read(String s) throws Exception {
		// TODO Auto-generated method stub
		Form_Groupe groupe = null;
		try (Connection conn = DriverManager.getConnection(dburl)) {
			System.out.println("Recherche " + s);
			PreparedStatement prepare = conn.prepareStatement(
					"SELECT * FROM Approprier WHERE NomGroupe = ?");
			prepare.setString(1, s);

			ResultSet result = prepare.executeQuery();
			  System.out.println("voilaaaaaaaaaaa 000000000   "+result.getFetchSize());
			 // if(result.getFetchSize()!=0) {
				  System.out.println("silasssssssss");
				ArrayList<Formes_Graphiques> listeForme =new ArrayList<Formes_Graphiques>();
			  CercleDAO cercle = new CercleDAO() ;
			  CarreDAO carre = new CarreDAO();
			  RectangleDAO rectangle = new RectangleDAO();
			  TriangleDAO triangle = new TriangleDAO();
			 // System.out.println("voilaaaaaaaaaaa 11111111  "+result.next());
boolean bool=false;
			while (result.next()){
				bool=true;
				  System.out.println("voilaaaaaaaaaaa 11111111  "+ result.getString("nomForme"));
				  System.out.println (cercle.read(result.getString("nomForme")) instanceof Cercle); //vrai  

				  if(cercle.read(result.getString("nomForme")) instanceof Cercle) 
				  {		  System.out.println("voilaaaaaaaaaaa ccccccccccccccccc ");

					  listeForme.add(cercle.read(result.getString("nomForme")));

				  }
				  else if(triangle.read(result.getString("nomForme")) instanceof Triangle) 
				  {						  System.out.println("voilaaaaaaaaaaa ttttttttttttttt");

					  listeForme.add(triangle.read(result.getString("nomForme")));

				  }
				  else if(carre.read(result.getString("nomForme")) instanceof Carre) 
				  {						  System.out.println("voilaaaaaaaaaaa aaaaaaaaaaaaaaa");

					  listeForme.add(carre.read(result.getString("nomForme")));

				  }
				  else if(rectangle.read(result.getString("nomForme")) instanceof Rectangle) 
				  {						  System.out.println("voilaaaaaaaaaaa rrrrrrrrrrrrrr");

					  listeForme.add(rectangle.read(result.getString("nomForme")));

				  }
				  }
System.out.println(listeForme.isEmpty()+" nnnnn  "+listeForme.size());
			if(bool) {
				System.out.println("kkkkkkkkkkkkkkkkkkkkk lllllllllll kkkkkkkkkkk ");
		 groupe = new Form_Groupe(listeForme,s);
			}/*else
			{
				throw new InExistTupleException();

			}*/
			
				
		}
		catch (SQLException e) {
			e.printStackTrace();
	}
		return groupe;	
}
	
	}
