package Dessin.TD_Dessin;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;

import Dessin.TD_Dessin.forme.Coordonnee;
import Dessin.TD_Dessin.forme.Rectangle;

public class TestRectangle {
	private Rectangle rectangle;
	private Coordonnee Coor;

	@Before()
	public void setUp() {
		Coor = new Coordonnee(8, 2);
		rectangle = new Rectangle("R1", Coor, 5, 7);

	}

	@Test
	public void testPrint() {
		rectangle.print();

	}

	@Test
	public void testMove() {
		assertTrue(rectangle.getCoor().getX() == 8);
		assertTrue(rectangle.getCoor().getY() == 2);
		rectangle.move(10, 2);
		assertEquals(rectangle.getCoor().getX(), 18);
		assertEquals(rectangle.getCoor().getY(), 4);
		Coor.move(4, 2);
		assertFalse(rectangle.getCoor().getX() != 18);
		assertFalse(rectangle.getCoor().getY() != 4);
		rectangle.move(8, 5);
		assertFalse(rectangle.getCoor().getX() == 18);
		assertFalse(rectangle.getCoor().getY() == 4);

	}
}
