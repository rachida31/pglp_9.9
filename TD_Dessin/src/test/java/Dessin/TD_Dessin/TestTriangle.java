package Dessin.TD_Dessin;

import static org.junit.Assert.*;
import org.junit.*;

import Dessin.TD_Dessin.forme.Coordonnee;
import Dessin.TD_Dessin.forme.Triangle;

public class TestTriangle {

	private Triangle triangle;
	private Coordonnee Coor1;
	private Coordonnee Coor2;
	private Coordonnee Coor3;

	@Before()
	public void setUp() {
		Coor1 = new Coordonnee(1, 2);
		Coor2 = new Coordonnee(3, 4);
		Coor3 = new Coordonnee(5, 2);

		triangle = new Triangle("T1", Coor1, Coor2, Coor3);

	}

	@Test
	public void testPrint() {
		triangle.print();
	}

	@Test
	public void testMove() {
		assertTrue(triangle.getCoor1().getX() == 1);
		assertTrue(triangle.getCoor1().getY() == 2);
		assertTrue(triangle.getCoor2().getX() == 3);
		assertTrue(triangle.getCoor2().getY() == 4);
		assertTrue(triangle.getCoor3().getX() == 5);
		assertTrue(triangle.getCoor3().getY() == 2);
		triangle.move(10, 2);
		assertEquals(triangle.getCoor1().getX(), 11);
		assertEquals(triangle.getCoor1().getY(), 4);
		assertEquals(triangle.getCoor2().getX(), 13);
		assertEquals(triangle.getCoor2().getY(), 6);
		assertEquals(triangle.getCoor3().getX(), 15);
		assertEquals(triangle.getCoor3().getY(), 4);
		Coor1.move(4, 2);
		assertFalse(triangle.getCoor1().getX() == 15);
		assertFalse(triangle.getCoor1().getY() == 6);
		triangle.move(8, 5);
		assertFalse(triangle.getCoor1().getX() == 9);
		assertFalse(triangle.getCoor1().getY() == 7);
		assertFalse(triangle.getCoor2().getX() == 11);
		assertFalse(triangle.getCoor2().getY() == 9);
		assertFalse(triangle.getCoor3().getX() == 13);
		assertFalse(triangle.getCoor3().getY() == 7);

	}
}
