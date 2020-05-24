package Dessin.TD_Dessin.forme;

/**
 * implemantation de la classe Rectangle pour
 * definir un la forme géométrique
 * Rectangle.
 * @author rachida ouchene.
 */
public class Rectangle extends Formes_Graphiques {
	/**
	 * la possition de Rectangle de type
	 * Coordonnee (int ,int).
	 * @see Rectangle#Rectangle().
	 * @see Rectangle#getCoor().
	 */
	private Coordonnee Coor;
	/**
	 * la longeur de Rectangle qu'est de type int.
	 * @see Rectangle#Rectangle().
	 * @see Rectangle#getLongeur().
	 */
	private int longueur;
	/**
	 * la largeur de Rectangle qu'est de type int.
	 * @see Rectangle#Rectangle().
	 * @see Rectangle#getLargeur().
	 */
	private int largeur;

	/**
	 * Constructor Rectangle qu'inisialise @see Coor
	 * par ces coordonnée et @see
	 * longeur et @see lagreur de Rectangle ainsi passe
	 * le name a la super classe.
	 * @param name     : le nom de Rectangle.
	 * @param Coor1 :    les coordonnée de Rectangle.
	 * @param longueur1 : longeur de Rectangle.
	 * @param largeur1 : largeur de Rectangle.
	 */
	public Rectangle(final String name, final Coordonnee Coor1, final
			int longueur1, final int largeur1) {
		super(name);
		this.Coor = new Coordonnee(Coor1.getX(), Coor1.getY());
		this.longueur = longueur1;
		this.largeur = largeur1;
	}

	/**
	 * Retourne La coordonnée de Rectangle.
	 * @return Coor.
	 * @see Coor
	 */
	public final Coordonnee getCoor() {
		return this.Coor;
	}

	/**
	 * Retourne la longeur de Rectangle.
	 * @return longueur.
	 * @see longueur
	 */
	public final int getLongueur() {
		return this.longueur;
	}

	/**
	 * Retourne la largeur de Rectangle.
	 * @return largeur.
	 * @see largeur
	 */
	public final int getLargeur() {
		return this.largeur;
	}

	/**
	 * Affiche les informations de Rectangle.
	 */
	@Override
	public final void print() {
		String rectangle = this.name + " : Rectangle "
				+ "((longueur:" + longueur + ") " + ","
				+ "(largeur:" + largeur + ") "
				+ (",(x:" + Coor.getX() + "," + "y:"
				+ "" + Coor.getY()) + "))";
		System.out.println(rectangle);
	}

	/**
	 * Deplace le Rectangle en rajoutant le deplacement
	 * passer en parmetre pour les
	 * Coordonnée de ce Rectangle grace a l'appelle de la
	 * fonction move de la classe
	 * Coordonnee.
	 */
	@Override
	public final void move(final int x, final int y) {
		this.Coor.move(x, y);
	}

}
