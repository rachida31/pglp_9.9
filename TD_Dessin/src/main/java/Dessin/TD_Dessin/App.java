package Dessin.TD_Dessin;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import Dessin.TD_Dessin.Commande.InterfaceUser;
import Dessin.TD_Dessin.DAO.CarreDAO;
import Dessin.TD_Dessin.DAO.CercleDAO;
import Dessin.TD_Dessin.DAO.Form_GroupeDAO;
import Dessin.TD_Dessin.DAO.RectangleDAO;
import Dessin.TD_Dessin.DAO.TriangleDAO;
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
    	/*Coordonnee c;
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
      //  DerbyConnexion conn =new DerbyConnexion();
    	//conn.createtable();
    	Coordonnee c1 =new Coordonnee (5,5);
    	Coordonnee c2 =new Coordonnee (6,6);
    	Coordonnee c3 =new Coordonnee (10,10);
    	Triangle triangle = new Triangle("t1",c1,c2,c3);
    	Rectangle r = new Rectangle("r1",c1,4,6);
Cercle cercle =new Cercle("c3",c2,5);
CercleDAO cd= new CercleDAO();
    	TriangleDAO cdao=new TriangleDAO();
    	RectangleDAO r4=new RectangleDAO();
//cd.create(cercle);
//cdao.create(triangle);
Carre carre=new Carre ("ca1",c3,4);
CarreDAO cad =new CarreDAO();
//cad.create(carre);
triangle.move(1, 1);
cdao.update(triangle);
Triangle tr1=cdao.read("t11");
System.out.println(tr1.getCoor1().getX());
System.out.println(tr1.getCoor1().getY());
System.out.println(tr1.getCoor2().getX());
System.out.println(tr1.getCoor2().getY());
System.out.println(tr1.getCoor3().getX());
System.out.println(tr1.getCoor3().getY());
carre.move(2, 2);
cad.update(carre);
Carre cv=cad.read("ca1");
System.out.println(cv.getCoor().getX());
System.out.println(cv.getCoor().getY());
cercle.move(3, 3);
cd.update(cercle);
Cercle crv=cd.read("c3");
System.out.println(crv.getCentre().getX());
System.out.println(crv.getCentre().getY());
    	// cdao.create(triangle);
    	//Triangle cr=cdao.read("r1");
    	//r4.create(r);
    	Rectangle r12= r4.read("r1");
    	System.out.println(r12.getName());
    	System.out.println(r12.getCoor().getX());
    	System.out.println(r12.getCoor().getY());
		r.move(c3.getX(),c3.getY());

    	r4.update(r);
    	Rectangle r13= r4.read("r1");
    	System.out.println(r13.getName());
    	System.out.println(r13.getCoor().getX());
    	System.out.println(r13.getCoor().getY());
    	//System.out.println(cr.getName());
    	Form_Groupe g = new Form_Groupe("g16");
    	g.add(triangle);
    	g.add(cercle);
    	Form_GroupeDAO d = new Form_GroupeDAO();
    	//d.create(g);
    	//d.stlect("r1");
    	Form_Groupe g1=d.read("g16");
    	System.out.println(g1.getName());
    	System.out.println(g1.getForme().size());
    	g1.print();
    	g1.move(1, 1);
    	d.update(g1);
    	Form_Groupe g2=d.read("g16");

    	g2.print();
d.delete(g1);
Form_Groupe g2=d.read("g16");
System.out.println(g2.getName());
System.out.println(g2.getForme().size());
g.print();*/
    	DrawingApp user= new DrawingApp();
    	user.run();
    	//Form_GroupeDAO d = new Form_GroupeDAO();
    	//Form_Groupe g2=d.read("g16");

    	//g1 = Groupe (c3,t31)g2.print();
    	
    }
    
}
