package Dessin.TD_Dessin.forme;

/**
 * implemantation de la classe Triangle pour definir un la forme géométrique
 * Triangle.
 * 
 * @author rachida ouchene.
 * 
 */
public class Triangle extends Formes_Graphiques {
	/**
	 * la possition d'un point de Triangle qu'est de type Coordonnee (int ,int).
	 * 
	 * @see Triangle#Triangle().
	 * @see Triangle#getCoor1().
	 */
	private Coordonnee Coor1;
	/**
	 * la possition d'un point de Triangle qu'est de type Coordonnee (int ,int).
	 * 
	 * @see Triangle#Triangle().
	 * @see Triangle#getCoor3().
	 */
	private Coordonnee Coor2;
	/**
	 * la possition d'un point de Triangle qu'est de type Coordonnee (int ,int).
	 * 
	 * @see Triangle#Triangle().
	 * @see Triangle#getCoor3().
	 */
	private Coordonnee Coor3;

	/**
	 * Constructor Triangle qu'inisialise @see Coor1 par ces coordonnée et @see
	 * Coor2 par ces coordonnée et @see Coor3 par ces coordonnée
	 * 
	 * @param Triangle : le nom de carre.
	 * @param Coor1:   les coordonnée de Triangle.
	 * @param Coor2:   les coordonnée de Triangle.
	 * @param Coor3:   les coordonnée de Triangle.
	 */
	public Triangle(String name, Coordonnee Coor1, Coordonnee Coor2, Coordonnee Coor3) {
		super(name);
		this.Coor1 = new Coordonnee(Coor1.getX(), Coor1.getY());
		this.Coor2 = new Coordonnee(Coor2.getX(), Coor2.getY());
		this.Coor3 = new Coordonnee(Coor3.getX(), Coor3.getY());
	}

	/**
	 * Retourne La coordonnée de Triangle.
	 * 
	 * @return Coor1.
	 * @see Coor1
	 */
	public Coordonnee getCoor1() {
		return this.Coor1;
	}

	/**
	 * Retourne La coordonnée de Triangle.
	 * 
	 * @return Coor2.
	 * @see Coor2
	 */
	public Coordonnee getCoor2() {
		return this.Coor2;
	}

	/**
	 * Retourne La coordonnée de Triangle.
	 * 
	 * @return Coor3.
	 * @see Coor3
	 */
	public Coordonnee getCoor3() {
		return this.Coor3;
	}

	/**
	 * Affiche les informations de Triangle.
	 */
	@Override
	public void print() {
		String triangle = this.name + " : triangle (" + ("(x:" + Coor1.getX() + "," + "y:" + Coor1.getY())
				+ ("),(x:" + Coor2.getX() + "," + "y:" + Coor2.getY())
				+ ("),(x:" + Coor3.getX() + "," + "y:" + Coor3.getY()) + "))";
		System.out.println(triangle);
	}

	/**
	 * Deplace le Triangle en rajoutant le deplacement passer en parmetre pour les
	 * Coordonnée de ce Triangle grace a l'appelle de la fonction move de la classe
	 * Coordonnee.
	 */
	@Override
	public void move(int x, int y) {

		this.Coor1.move(x, y);
		this.Coor2.move(x, y);
		this.Coor3.move(x, y);

	}

}
