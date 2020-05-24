package Dessin.TD_Dessin.forme;

/**
 * implemantation de la classe abstract Formes_Graphiques
 * pour definir les
 * formes géométriques .
 * @author rachida ouchene.
 */
public abstract class Formes_Graphiques {

	/**
	 * le nom de la forme qu'est de type String.
	 * @see Formes_Graphiques#Formes_Graphiques().
	 * @see Formes_Graphiques#getName().
	 */
	protected String name;

	/**.
	 * Constructor Formes_Graphiques qu'inisialise
	 * @see name avec le nom de la forme
	 * @param name1 : le nom de la forme.
	 */
	public Formes_Graphiques(final String name1) {
		this.name = name1;
	}

	/**
	 * Retourne le nom de la forme.
	 * @return name .
	 * @see name
	 */
	public final String getName() {
		return this.name;
	}

	/**
	 * Affiche les informations de la forme.
	 */
	public abstract void print();

	/**
	 * Deplace la forme.
	 * @param x .
	 * @param y .
	 */
	public abstract void move(final int x, final int y);
}
