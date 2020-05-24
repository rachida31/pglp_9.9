package Dessin.TD_Dessin.forme;

/**
 * implemantation de la classe Coordonnee pour definir la
 * possition d'une forme.
 * @author rachida ouchene.
 */
public class Coordonnee {
	/**
	 * la possition de point par rapport a l'axe x .
	 * @see Coordonnee#Coordonnee().
	 * @see Coordonnee#getX().
	 */
	private int X;
	/**.
	 * la possition de point par rapport a l'axe y
	 * @see Coordonnee#Coordonnee().
	 * @see Coordonnee#getY().
	 */
	private int Y;

	/**
	 * Constructor Coordonnee qu'inisialise @see X par la
	 * possition sur l'axe des X
	 * . et @see X par la possition sur l'axe des Y .
	 * @param x : la possition de point par rapport a l'axe x.
	 * @param y : la possition de point par rapport a l'axe y.
	 */
	public Coordonnee(final int x, final int y) {
		this.X = x;
		this.Y = y;
	}
	/**.
	 * Retourn la possition de point par rapport a l'axe x
	 * @return X .
	 * @see X
	 */
	public final int getX() {
		return this.X;
	}

	/**.
	 * Retourn la possition de point par rapport a l'axe Y
	 * @return Y .
	 * @see Y
	 */
	public final int getY() {
		return this.Y;
	}

	/**
	 * Deplasse de x et y en rajoutant le deplacement passer en parmetre.
	 * @param x .
	 * @param y .
	 */
	public final void move(final int x, final int y) {
		this.X += x;
		this.Y += y;
	}
}
