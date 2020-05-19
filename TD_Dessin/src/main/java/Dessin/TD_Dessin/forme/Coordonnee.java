package Dessin.TD_Dessin.forme;

/**
 * implemantation de la classe Coordonnee pour definir la possition d'une forme.
 * 
 * @author rachida ouchene.
 * 
 */
public class Coordonnee {
	/**
	 * la possition de point par rapport a l'axe x .
	 * @see Coordonnee#Coordonnee().
	 * @see Coordonnee#getX().
	 */
	private int X;
	/**
	 * la possition de point par rapport a l'axe y
	 * 
	 * @see Coordonnee#Coordonnee().
	 * @see Coordonnee#getY().
	 */
	private int Y;

	/**
	 * Constructor Coordonnee qu'inisialise @see X par la possition sur l'axe des X
	 * . et @see X par la possition sur l'axe des Y .
	 * 
	 * @param X: la possition de point par rapport a l'axe x.
	 * @param Y: la possition de point par rapport a l'axe y.
	 */
	public Coordonnee(int X, int Y) {
		this.X = X;
		this.Y = Y;
	}

	/**
	 * Retourn la possition de point par rapport a l'axe x
	 * 
	 * @return X.
	 * @see X
	 */
	public int getX() {
		return this.X;
	}

	/**
	 * Retourn la possition de point par rapport a l'axe Y
	 * 
	 * @return Y.
	 * @see Y
	 */
	public int getY() {
		return this.Y;
	}

	/**
	 * Deplasse de x et y en rajoutant le deplacement passer en parmetre.
	 */
	public void move(int X, int Y) {
		this.X += X;
		this.Y += Y;
	}
}
