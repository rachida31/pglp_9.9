package Dessin.TD_Dessin;

import static org.junit.Assert.*;
import org.junit.*;

import Dessin.TD_Dessin.forme.Carre;
import Dessin.TD_Dessin.forme.Coordonnee;

public class CarreTest {
	private Carre carre;
	private Coordonnee Coor;

	@Before()
	public void setUp() {
		Coor = new Coordonnee(5, 6);
		carre = new Carre("C1", Coor, 4);

	}

	@Test
	public void testPrint() {
		carre.print();
	}

	@Test
	public void testMove() {
		assertTrue(carre.getCoor().getX() == 5);
		assertTrue(carre.getCoor().getY() == 6);
		carre.move(10, 2);
		assertEquals(carre.getCoor().getX(), 15);
		assertEquals(carre.getCoor().getY(), 8);
		Coor.move(4, 2);
		assertFalse(carre.getCoor().getX() != 15);
		assertFalse(carre.getCoor().getY() != 8);
		carre.move(8, 5);
		assertFalse(carre.getCoor().getX() == 15);
		assertFalse(carre.getCoor().getY() == 8);

	}
}
