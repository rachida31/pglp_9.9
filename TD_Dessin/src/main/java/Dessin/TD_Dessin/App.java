package Dessin.TD_Dessin;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import Exeption.TableExisteException;


/**
 * Hello world!
 *c1 = Cercle((0, 0), 50)
 */
public class App 
{
    public static void main( String[] args ) throws TableExisteException
    {
    	Coordonnee c;
    	Formes_Graphiques f;
    	Scanner S = new Scanner(System.in);
    	String str = S.nextLine();
    	ArrayList l= new ArrayList<String>();
    	
        System.out.println( "Hello World! "+str );
        StringTokenizer multiTokenizer = new StringTokenizer(str, "=(), ");
        System.out.println("length "+multiTokenizer.hasMoreTokens());
        while (multiTokenizer.hasMoreTokens())
        {
        	String a= multiTokenizer.nextToken();
        	l.add(a);
        	System.out.println(a);
        }
        System.out.println(" size " +l.size()+" classe "+l.get(2).getClass());
        c=new Coordonnee(Integer.parseInt((String) l.get(2)),Integer.parseInt((String) l.get(3)));
        System.out.println(" X "+c.getX()+ " Y "+c.getY());
        f=new Cercle((String)l.get(0),c,Integer.parseInt((String) l.get(4)));
        f.print();
        DerbyConnexion conn =new DerbyConnexion();
    	conn.createtable();
    }
    
}
