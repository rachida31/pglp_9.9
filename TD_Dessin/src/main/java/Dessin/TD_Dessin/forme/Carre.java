package Dessin.TD_Dessin.forme;
/**
 * implemantation de la classe Carre pour definir un la forme
 * géométrique carre.
 * @author rachida ouchene.
 */
public class Carre extends Formes_Graphiques {
	/**
	 * la possition de carre de type Coordonnee (int ,int).
	 * @see Carre#Carre().
	 * @see Carre#getCoor().
	 */
	private Coordonnee Coor;
	/**
	 * la demansion de cote de carre qu'est de type int.
	 * @see Carre#Carre().
	 * @see Carre#getCote().
	 */
	private int cote;

	/**
	 * Constructor Carre qu'inisialise @see Coor par ces
	 * coordonnée et @see cote par
	 * la demansion de cote et passe le name a la super classe.
	 * @param name  : le nom de carre.
	 * @param Coor1 : les coordonnée de carre.
	 * @param cote1  le cote de carre.
	 */
	public Carre(final String name, final Coordonnee
			Coor1, final int cote1) {
		super(name);
		this.Coor = new Coordonnee(Coor1.getX(), Coor1.getY());
		this.cote = cote1;
	}

	/**
	 * Retourne La coordonnée de carre.
	 * @return Coor .
	 * @see Coor
	 */
	public final Coordonnee getCoor() {
		return this.Coor;
	}

	/**
	 * Retourne le cote de carre.
	 * @return cote.
	 * @see cote
	 */
	public final int getCote() {
		return this.cote;
	}

	/**
	 * Affiche les informations de carre.
	 */
	@Override
	public final void print() {
		String carre = this.name + " "
				+ ": carre ((coté:" + cote + ")"
				+ " " + ("(x:" + Coor.
				getX() + "," + "y:" + Coor.getY())
				+ "))";
		System.out.println(carre);
	}
	/**.
	 * Deplace le carre en rajoutant le deplacement passer en parmetre
	 * pour les
	 * Coordonnée se carre grace a l'appelle de la fonction move
	 * de la classe
	 * Coordonnee.
	 */
	@Override
	public final void move(final
			int x, final int y) {
		this.Coor.move(x, y);
	}
}
