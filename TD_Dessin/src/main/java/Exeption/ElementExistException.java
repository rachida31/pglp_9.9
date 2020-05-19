package Exeption;

/**
 * implemantation de la classe D'exception ElementExistException qui se genera
 * quand nous voulons inserer un element déjà existant
 * 
 * @author rachida ouchene.
 * 
 */
public class ElementExistException extends Exception {

	/**
	 * contrôleur de la version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * constructeur de la classe
	 */
	public ElementExistException() {
		super(" \n L\'element existe déjà !");
	}

}
