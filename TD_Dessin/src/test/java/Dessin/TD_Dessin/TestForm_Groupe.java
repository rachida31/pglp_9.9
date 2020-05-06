package Dessin.TD_Dessin;
import static org.junit.Assert.*;
import org.junit.*;
import Exeption.ElementExistException;
import Exeption.InExistArgumentException;
public class TestForm_Groupe {
	private Triangle triangle;
	private Coordonnee Coor1;
	private Coordonnee Coor2;
	private Coordonnee Coor3;
	private Cercle cercle;
	private Coordonnee Coorc;
	private Cercle cercle1;
	private Coordonnee Coorc1;
	private Rectangle rectangle;
	private Coordonnee Coorr;
	private Carre carre;
	private Coordonnee Coora;
	private Form_Groupe FG;
	@Before()
		public void setUp() {
		Coorc=new Coordonnee(2,2);
		cercle=new Cercle("C1",Coorc,5);
		Coorc1=new Coordonnee(6,4);
		cercle1=new Cercle("C1",Coorc1,4);
		Coorr=new Coordonnee(8,2);
		rectangle=new Rectangle("R1",Coorr,5,7);
		Coora=new Coordonnee(5,6);
		carre=new Carre("C1",Coora,4);
		Coor1=new Coordonnee(1,2);
		Coor2=new Coordonnee(3,4);
		Coor3=new Coordonnee(5,2);
		triangle=new Triangle("T1",Coor1,Coor2,Coor3);
		FG=new Form_Groupe("G1");
		try {
			FG.add(cercle);
			FG.add(carre);
			FG.add(rectangle);
			FG.add(triangle);		
			}
		catch (ElementExistException e) {
			e.printStackTrace();
		}
		
		}
	@Test
	public void testAddEx()  
	{
		try {
			FG.add(triangle);
			
		} catch (ElementExistException e) {
			e.printStackTrace();
		}
		finally 
		{

			assertTrue(FG.size()== 4);
			assertFalse(FG.size()==3);	
		}
		

}
	@Test()
	public void testAdd() 
	{
		try {
			FG.add(cercle1);
			FG.add(cercle1);
			FG.print();
		} catch (ElementExistException e) {
			e.printStackTrace();
		}
		finally
		{
			assertTrue(FG.size()== 5);	
		}

		
}
	@Test(expected=InExistArgumentException.class)
	public void TestRemove () 
	{
		System.out.println(FG.size());

		FG.remove(cercle);
		FG.remove(cercle);

		assertTrue(FG.size()==4);
	}

	@Test
	public void testMove()
	{
		FG.move(1, 2);
		FG.print();
		assertTrue(cercle.getCentre().getX()==3);
		assertTrue(cercle.getCentre().getY()==4);
		assertTrue(carre.getCoor().getX()==6);
		assertTrue(carre.getCoor().getY()==8);
		assertTrue(rectangle.getCoor().getX()==9);
		assertTrue(rectangle.getCoor().getY()==4);
		assertTrue(triangle.getCoor1().getX()==2);
		assertTrue(triangle.getCoor1().getY()==4);
		assertTrue(triangle.getCoor2().getX()==4);
		assertTrue(triangle.getCoor2().getY()==6);
		assertTrue(triangle.getCoor3().getX()==6);
		assertTrue(triangle.getCoor3().getY()==4);
	}
}
