package Dessin.TD_Dessin.forme;

/**
 * implemantation de la classe abstract Formes_Graphiques pour definir les
 * formes géométriques .
 * 
 * @author rachida ouchene.
 * 
 */
public abstract class Formes_Graphiques {

	/**
	 * le nom de la forme qu'est de type String.
	 * 
	 * @see Formes_Graphiques#Formes_Graphiques().
	 * @see Formes_Graphiques#getName().
	 */
	protected String name;

	/**
	 * Constructor Formes_Graphiques qu'inisialise @see name avec le nom de la forme
	 * 
	 * @param name : le nom de la forme.
	 */
	public Formes_Graphiques(String name) {
		this.name = name;
	}

	/**
	 * Retourne le nom de la forme.
	 * 
	 * @return name.
	 * @see name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Affiche les informations de la forme
	 */
	public abstract void print();

	/**
	 * Deplace la forme.
	 */
	public abstract void move(int x, int y);
}
