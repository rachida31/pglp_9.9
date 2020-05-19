package Exeption;

/**
 * implemantation de la classe D'exception InExistArgumentException qui se
 * genera quand un element que on veut supperimer dans une liste n\'existe pas
 * ..
 * 
 * @author rachida ouchene.
 * 
 */
public class InExistArgumentException extends IllegalArgumentException {

	/**
	 * contrôleur de la version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * constructeur de la classe
	 */
	public InExistArgumentException() {
		super(" \n L\'element n\'existe pas !");
	}

}