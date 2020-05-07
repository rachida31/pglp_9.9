package Dessin.TD_Dessin;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import Exeption.TableExisteException;

import java.sql.*;

	/**
	 *implemantation de la classe DerbyConnexion 
	 *pour creation de la base de donnee et les tables.
	 * @author rachida ouchene.
	 * 
	 */
	public class DerbyConnexion {
		/**
		 * chaine de connexion.
		 */
		public static String dburl="jdbc:derby:DBForme;create=true" ;

	    /**
		 * nom d'utilisateur pour ce connecter a la base de donnee DBDerby.
		 */
		private static final String user = "Rachida";
		/**
		 * Le mot de passe pour ce connecter a la base de donnee DBDerby.
		 */
		private static final String pwd = "Ouchene";
		  
		public static int test;
		/**
		* Constructor DerbyConnexion qu'inisialise @see nomGroupe a une chaine vide
		* et @see personnel cree une new ArrayList.
		 *
		 * */
		
		
		public DerbyConnexion()
		{
			   Properties connectionProps = new Properties();
		        connectionProps.put("user", user);
		        connectionProps.put("password", pwd);
		       
			
		}	
		
		public void  createtable() throws TableExisteException  
		{
				try {
					
					System.out.println("salut");
						Connection conn =DriverManager.getConnection(dburl);
					      //creationde l'objet Statement pour envoyer des instructions .
						Statement state = conn.createStatement();
						 DatabaseMetaData databaseMetadata = conn.getMetaData();
						    ResultSet resultSet = databaseMetadata.getTables(null, null, "CERCLE", null);
							  //drop de la table
						    if (resultSet.next()) {
								System.out.println("salut cercle");
								//state.addBatch("DROP TABLE Cercle");
						    	throw new TableExisteException();

						    }else
						    {
						    	state.addBatch(
										"CREATE TABLE Cercle ("
									         + "nomc VARCHAR(255) NOT NULL , "
									         + "cx int NOT NULL , "
									         + "cy int NOT NULL, "
											 + "rayon int NOT NULL, "
									        + "PRIMARY KEY (nomc))");
						    }
						     resultSet = databaseMetadata.getTables(null, null, "CARRE", null);

						    if (resultSet.next()) {
								System.out.println("salut carre");
								//state.addBatch("DROP TABLE Carre");
						    	throw new TableExisteException();

						    	}else
						    	{
						    		 state.addBatch(
												"CREATE TABLE Carre ("
											         + "noma VARCHAR(255) NOT NULL , "
											         + "ax int NOT NULL , "
											         + "ay int NOT NULL, "
													 + "cote int NOT NULL, "
											        + "PRIMARY KEY (noma))");
						    	}
						     resultSet = databaseMetadata.getTables(null, null, "TRIANGLE", null);

						    if (resultSet.next()) {
								System.out.println("salut triangle");
								//state.addBatch("DROP TABLE Triangle");
						    	throw new TableExisteException();							  
						    }else
						    {
						    	state.addBatch(
										"CREATE TABLE Triangle ("
									         + "nomt VARCHAR(255) NOT NULL , "
									         + "tx1 int NOT NULL , "
									         + "ty1 int NOT NULL, "
									         + "tx2 int NOT NULL , "
									         + "ty2 int NOT NULL, "
									         + "tx3 int NOT NULL , "
									         + "ty3 int NOT NULL, "
									        + "PRIMARY KEY (nomt))");
						    }
						    resultSet = databaseMetadata.getTables(null, null, "RECTANGLE", null);

						    if (resultSet.next()) {
								//state.addBatch("DROP TABLE Rectangle");
								System.out.println("salut rectangle ");
								throw new TableExisteException();
						    }else
						    {
						    	state.addBatch(
										"CREATE TABLE Rectangle ("
									         + "nomr VARCHAR(255) NOT NULL , "
									         + "rx int NOT NULL , "
									         + "ry int NOT NULL, "
											 + "largeur int NOT NULL, "
											 + "longueur int NOT NULL, "
									        + "PRIMARY KEY (nomr))");
						    }
						    resultSet = databaseMetadata.getTables(null, null, "GROUPEFORME", null);

						    if (resultSet.next()) {
								System.out.println("salut GroupeForme ");
								//state.addBatch("DROP TABLE GroupeForme");
						    	throw new TableExisteException();

						    }else
						    {
						    	state.addBatch( "CREATE TABLE GroupeForme( "
								         + "Name VARCHAR(255) NOT NULL , "
								         + "PRIMARY KEY (Name))");
						    }
						    resultSet = databaseMetadata.getTables(null, null, "APPROPRIER", null);

						    if (resultSet.next()) {
								//state.addBatch("DROP TABLE Approprier");
								System.out.println("salut Approprier");
						    	throw new TableExisteException();

						    }else
						    {
								System.out.println("salut 1 ");

								
								state.addBatch( "CREATE TABLE  Approprier( "
								         + "nomForme VARCHAR(255) NOT NULL, "
								         + "NomGroupe varchar(255) NOT NULL , "
								         + "PRIMARY KEY (nomForme,NomGroupe)) "
								         );
						    }
						    /*resultSet = databaseMetadata.getTables(null, null, "APPROPRIER2", null);

						    if (resultSet.next()) {
								System.out.println("salut Approprier2");

								state.addBatch("DROP TABLE Approprier2");
						    	
						    }else
						    {
								System.out.println("salut 2 ");
						    	state.addBatch( "CREATE TABLE  Approprier2( "
								         + "nomForme VARCHAR(255) NOT NULL , "
								         + "NomGoupe varchar(255) NOT NULL , "
								         + "PRIMARY KEY (nomPerso,NomGoupe)) "+ 
								         "\t FOREIGN KEY (nomForme)\n" + 
									     "\t REFERENCES Carre(noma))"+ 
							     "\t FOREIGN KEY (NomGoupe)\n" + 
							     "\t REFERENCES GroupeForme(Name))"
								         );
						    }
						    resultSet = databaseMetadata.getTables(null, null, "APPROPRIER3", null);

						    if (resultSet.next()) {
								System.out.println("salut Approprier3 ");
								state.addBatch("DROP TABLE Approprier3");
						    	
						    }else
						    {
								System.out.println("salut 3 ");

						    	state.addBatch( "CREATE TABLE  Approprier3( "
								         + "nomForme VARCHAR(255) NOT NULL , "
								         + "NomGoupe varchar(255) NOT NULL , "
								         + "PRIMARY KEY (nomPerso,NomGoupe)) "+ 
								         "\t FOREIGN KEY (nomForme)\n" + 
									     "\t REFERENCES Rectangle(nomr))"+ 
							     "\t  FOREIGN KEY (NomGoupe)\n" + 
							     "\t REFERENCES GroupeForme(Name))"
								         );
						    }
						    resultSet = databaseMetadata.getTables(null, null, "APPROPRIER4", null);

						    if (resultSet.next()) {
								System.out.println("salut Approprier4 ");

								state.addBatch("DROP TABLE Approprier4");
						    	
						    }else
						    {
								System.out.println("salut 4 ");

								state.addBatch( "CREATE TABLE  Approprier4( "
								         + "nomForme VARCHAR(255) NOT NULL , "
								         + "NomGoupe varchar(255) NOT NULL , "
								         + "PRIMARY KEY (nomPerso,NomGoupe)) "+ 
								         "\t FOREIGN KEY (nomForme)\n" + 
									     "\t REFERENCES Triangle(nomt))"+ 
							     "\t FOREIGN KEY (NomGoupe)\n" + 
							     "\t REFERENCES GroupeForme(Name))"
								         );
						    }*/			
						    state.executeBatch();

			
			
			} catch (BatchUpdateException  e) {
				
				 int[] updateCount = e.getUpdateCounts();
	             
		            int count = 1;
		            for (int i : updateCount) {
		                if  (i == Statement.EXECUTE_FAILED) {
		                    System.out.println("Error on request " + count +": Execute failed");
		                } else {
		                    System.out.println("Request " + count +": OK");
		                }
		                count++;
		                 
		            }	        }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}

}
