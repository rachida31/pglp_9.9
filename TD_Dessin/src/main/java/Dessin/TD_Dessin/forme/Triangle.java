package Dessin.TD_Dessin.forme;

/**
 * implemantation de la classe Triangle pour definir un la forme
 * géométrique Triangle.
 * @author rachida ouchene.
 */
public class Triangle extends Formes_Graphiques {
	/**
	 * la possition d'un point de Triangle qu'est de type
	 * Coordonnee (int ,int).
	 * @see Triangle#Triangle().
	 * @see Triangle#getCoor1().
	 */
	private Coordonnee Coor1;
	/**
	 * la possition d'un point de Triangle qu'est de type
	 * Coordonnee (int ,int).
	 * @see Triangle#Triangle().
	 * @see Triangle#getCoor3().
	 */
	private Coordonnee Coor2;
	/**
	 * la possition d'un point de Triangle qu'est de type
	 * Coordonnee (int ,int).
	 * @see Triangle#Triangle().
	 * @see Triangle#getCoor3().
	 */
	private Coordonnee Coor3;

	/**.
	 * Constructor Triangle qu'inisialise @see Coor1 par ces
	 * coordonnée et @see
	 * Coor2 par ces coordonnée et @see Coor3 par ces coordonnée
	 * @param name1 : le nom de carre.
	 * @param Coor11 :   les coordonnée de Triangle.
	 * @param Coor21 :   les coordonnée de Triangle.
	 * @param Coor31 :   les coordonnée de Triangle.
	 */
	public Triangle(final String name1, final Coordonnee Coor11, final
			Coordonnee Coor21, final Coordonnee Coor31) {
		super(name1);
		this.Coor1 = new Coordonnee(Coor11.getX(), Coor11.getY());
		this.Coor2 = new Coordonnee(Coor21.getX(), Coor21.getY());
		this.Coor3 = new Coordonnee(Coor31.getX(), Coor31.getY());
	}

	/**
	 * Retourne La coordonnée de Triangle.
	 * @return Coor1 .
	 * @see Coor1
	 */
	public final Coordonnee getCoor1() {
		return this.Coor1;
	}

	/**
	 * Retourne La coordonnée de Triangle.
	 * @return Coor2 .
	 * @see Coor2
	 */
	public final Coordonnee getCoor2() {
		return this.Coor2;
	}

	/**
	 * Retourne La coordonnée de Triangle.
	 * @return Coor3 .
	 * @see Coor3
	 */
	public final Coordonnee getCoor3() {
		return this.Coor3;
	}

	/**
	 * Affiche les informations de Triangle.
	 */
	@Override
	public final void print() {
		String triangle = this.name + " : triangle ("
				+ "" + ("(x:" + Coor1.
				getX() + "," + "y:" + Coor1.getY())
				+ ("),(x:" + Coor2.getX() + ""
						+ "," + "y:" + Coor2.getY())
				+ ("),(x:" + Coor3.getX() + ""
						+ "," + "y:" + Coor3.getY()) + "))";
		System.out.println(triangle);
	}

	/**
	 * Deplace le Triangle en rajoutant le deplacement passer en
	 * parmetre pour les Coordonnée de ce
	 * Triangle grace a l'appelle de la fonction move de la classe
	 * Coordonnee.
	 */
	@Override
	public final void move(final int x, final int y) {
		this.Coor1.move(x, y);
		this.Coor2.move(x, y);
		this.Coor3.move(x, y);

	}

}
