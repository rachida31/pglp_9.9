package Dessin.TD_Dessin.forme;

/**
 * implemantation de la classe Cercle pour definir un la forme géométrique
 * Cercle.
 * 
 * @author rachida ouchene.
 * 
 */
public class Cercle extends Formes_Graphiques {
	/**
	 * la possition de centre de Cercle de type Coordonnee (int ,int).
	 * 
	 * @see Cercle#Cercle().
	 * @see Cercle#getCentre().
	 */
	private Coordonnee centre;
	/**
	 * la demansion de rayon de Cercle qu'est de type int.
	 * 
	 * @see Cercle#Cercle().
	 * @see Cercle#getRayon().
	 */
	private int rayon;

	/**
	 * Constructor Cercle qu'inisialise @see Coor par ces coordonnée et @see rayon
	 * par la demansion de rayon et passe le name a la super classe.
	 * 
	 * @param name   : le nom de Cercle.
	 * @param Coor:  les coordonnée de Cercle.
	 * @param rayon: le rayon de Cercle.
	 */
	public Cercle(String name, Coordonnee centre, int rayon) {
		super(name);
		this.centre = new Coordonnee(centre.getX(), centre.getY());
		this.rayon = rayon;
	}

	/**
	 * Retourne La coordonnée de Cercle.
	 * 
	 * @return Coor.
	 * @see Coor
	 */
	public Coordonnee getCentre() {
		return this.centre;
	}

	/**
	 * Retourne le rayon de Cercle.
	 * 
	 * @return rayon.
	 * @see rayon
	 */
	public int getRayon() {
		return this.rayon;
	}

	/**
	 * Affiche les informations de Cercle.
	 */
	@Override
	public void print() {
		String cercle = this.name + " : Cercle ((Rayon:" + rayon + ") "
				+ ("(x:" + centre.getX() + "," + "y:" + centre.getY()) + "))";
		System.out.println(cercle);
	}

	/**
	 * Deplace le Cercle en rajoutant le deplacement passer en parmetre pour les
	 * Coordonnée de ce Cercle grace a l'appelle de la fonction move de la classe
	 * Coordonnee.
	 */
	@Override
	public void move(int x, int y) {
		this.centre.move(x, y);

	}

}
