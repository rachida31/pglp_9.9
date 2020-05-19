package Dessin.Dessin;

import Dessin.TD_Dessin.DAO.DerbyConnexion;
import Dessin.TD_Dessin.forme.DrawingApp;

/**
 * application.
 */
public final class App {
/**
* Constructeur de la classe principale.
* */
private App() {
}
/**
* la fonction main qui lance l'application.
* @param args .
* @exception Exception .
**/
public static void main(final String[] args) throws Exception {
DerbyConnexion conn = new DerbyConnexion();
conn.createtable();
DrawingApp user = new DrawingApp();
user.run();
}
}
