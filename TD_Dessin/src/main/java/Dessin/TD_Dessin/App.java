package Dessin.TD_Dessin;

import Dessin.TD_Dessin.DAO.DerbyConnexion;

//import Dessin.TD_Dessin.DAO.DerbyConnexion;



/**
 * Hello world!
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	DerbyConnexion conn =new DerbyConnexion();
		conn.createtable();
    	DrawingApp user= new DrawingApp();
    	user.run();
    	
    	
    }
    
}
