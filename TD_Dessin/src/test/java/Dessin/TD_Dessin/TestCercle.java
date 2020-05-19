package Dessin.TD_Dessin;

import static org.junit.Assert.*;
import org.junit.*;

import Dessin.TD_Dessin.forme.Cercle;
import Dessin.TD_Dessin.forme.Coordonnee;

public class TestCercle {
	private Cercle cercle;
	private Coordonnee Coor;

	@Before()
	public void setUp() {
		Coor = new Coordonnee(2, 2);
		cercle = new Cercle("C1", Coor, 5);

	}

	@Test
	public void testPrint() {
		cercle.print();
	}

	@Test
	public void testMove() {
		assertTrue(cercle.getCentre().getX() == 2);
		assertTrue(cercle.getCentre().getY() == 2);
		cercle.move(10, 2);
		assertEquals(cercle.getCentre().getX(), 12);
		assertEquals(cercle.getCentre().getY(), 4);
		Coor.move(4, 2);
		assertFalse(cercle.getCentre().getX() != 12);
		assertFalse(cercle.getCentre().getY() != 4);
		cercle.move(8, 5);
		assertFalse(cercle.getCentre().getX() == 12);
		assertFalse(cercle.getCentre().getY() == 4);

	}
}
