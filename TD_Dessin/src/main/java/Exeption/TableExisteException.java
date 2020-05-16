package Exeption;
/**
 *implemantation de la classe D'exception TableExisteException 
 *qui se genera quand nous voulons créer une table déjà existante
 * @author rachida ouchene.
 * 
 */
public class TableExisteException extends  Exception {
	/**
	 * contrôleur de la version
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *constructeur de la classe  
	 * */
	public TableExisteException()
	{
		super("La table exite déjà !");
	
	}


}
