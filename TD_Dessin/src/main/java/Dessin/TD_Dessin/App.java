package Dessin.TD_Dessin;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import Exeption.ElementExistException;
import Exeption.TableExisteException;


/**
 * Hello world!
 *c1 = Cercle((0, 0), 50)
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	Coordonnee c;
    	Formes_Graphiques f;
    	Scanner S = new Scanner(System.in);
    	String str = S.nextLine();
    	ArrayList l= new ArrayList<String>();
    	
        System.out.println( "Hello World! "+str );
    }
    
}
