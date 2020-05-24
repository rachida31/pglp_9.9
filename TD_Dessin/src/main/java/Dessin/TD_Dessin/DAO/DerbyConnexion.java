package Dessin.TD_Dessin.DAO;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.*;

/**
 * implemantation de la classe DerbyConnexion pour creation de
 * la base de donnee.
 * et les tables.
 * @author rachida ouchene.
 */
public class DerbyConnexion {
	/**
	 * chaine de connexion.
	 */
	public static String dburl = "jdbc:derby:DBForme;create=true";
	/**
	 * nom d'utilisateur pour ce connecter a la base de donnee DBDerby.
	 */
	private static final String user = "Rachida";
	/**
	 * Le mot de passe pour ce connecter a la base de donnee DBDerby.
	 */
	private static final String pwd = "Ouchene";

	/**.
	 * Constructor DerbyConnexion qui définir la propriété de connexion.
	 */
	public DerbyConnexion() {
		Properties connectionProps = new Properties();
		connectionProps.put("use r", user);
		connectionProps.put("password", pwd);
	}

	/**
	 * ceation de la base et les table cercle ,carre ,rectangle,
	 * triangle,groupeForme et Approprier
	 * si elles n'existent pas sinon une
	 * exception est levé.
	 * @throws SQLException
	 */
	public final void createtable() {
		try {

			Connection conn = DriverManager.getConnection(dburl);
			// creationde l'objet Statement
			//pour envoyer des instructions .
			Statement state = conn.createStatement();
			DatabaseMetaData databaseMetadata = conn.
					getMetaData();
			ResultSet resultSet = databaseMetadata.
					getTables(null, null, ""
					+ "CERCLE", null);
			if (resultSet.next()) {
				state.addBatch("DROP TABLE Cercle");
			}
			state.addBatch("CREATE TABLE Cercle ("
					+ "nomc VARCHAR(255) NOT NULL , "
					+ "cx int NOT NULL , "
					+ "cy int NOT NULL, "
					+ "rayon int NOT NULL, "
					+ "PRIMARY KEY (nomc))");
			resultSet = databaseMetadata.
					getTables(null, null, ""
					+ "CARRE", null);
			if (resultSet.next()) {
				state.addBatch("DROP TABLE Carre");
			}
			state.addBatch("CREATE TABLE Carre ("
					+ "noma VARCHAR(255) NOT NULL , "
					+ "ax int NOT NULL , "
					+ "ay int NOT NULL, "
					+ "cote int NOT NULL, "
					+ "PRIMARY KEY (noma))");
			resultSet = databaseMetadata.getTables(null, null,
					"TRIANGLE", null);
			if (resultSet.next()) {
				state.addBatch("DROP TABLE Triangle");
			}
			state.addBatch("CREATE TABLE Triangle ("
					+ "nomt VARCHAR(255) NOT NULL , "
					+ "tx1 int NOT NULL , "
					+ "ty1 int NOT NULL, "
					+ "tx2 int NOT NULL , "
					+ "ty2 int NOT NULL, "
					+ "tx3 int NOT NULL , "
					+ "ty3 int NOT NULL, "
					+ "PRIMARY KEY (nomt))");
			resultSet = databaseMetadata.
					getTables(null, null, ""
					+ "RECTANGLE", null);
			if (resultSet.next()) {
				state.addBatch("DROP TABLE Rectangle");
			}
			state.addBatch("CREATE TABLE Rectangle ("
					+ "nomr VARCHAR(255) NOT NULL , "
					+ "rx int NOT NULL , "
					+ "ry int NOT NULL, "
					+ "largeur int NOT NULL, "
					+ "longueur int NOT NULL, "
					+ "PRIMARY KEY (nomr))");
			resultSet = databaseMetadata.getTables(null, null, "GROUPEFORME",
						null);
			if (resultSet.next()) {
				state.addBatch("DROP TABLE GroupeForme");
			}
			state.addBatch("CREATE TABLE "
					+ "GroupeForme( "
					+ "Name VARCHAR(255)"
					+ " NOT NULL , "
					+ "PRIMARY KEY (Name))");
			resultSet = databaseMetadata.
					getTables(null, null, ""
					+ "APPROPRIER", null);
			if (resultSet.next()) {
				state.addBatch("DROP TABLE Approprier");
			}
			state.addBatch("CREATE TABLE  Approprier( "
					+ "nomForme VARCHAR(255) NOT NULL, "
					+ "NomGroupe varchar(255) NOT NULL , "
					+ "PRIMARY KEY (nomForme,NomGroupe)) ");
			state.executeBatch();
		} catch (BatchUpdateException e) {
			int[] updateCount = e.getUpdateCounts();
			int count = 1;
			for (int i : updateCount) {
				if (i == Statement.EXECUTE_FAILED) {
					System.out.println("Error on request "
							+ "" + count + ":"
							+ " Execute failed");
				} else {
					System.out.println("Request "
							+ "" + count + ": OK");
				}
				count++;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
