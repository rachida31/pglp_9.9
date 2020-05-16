package Exeption;
/**
 *implemantation de la classe D'exception InExistTupleException 
 *qui se genera quand nous voulons inseret un tuple déjà existant
 * @author rachida ouchene.
 * 
 */
public class InExistTupleException extends  Exception  {
	/**
	 * contrôleur de la version
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *constructeur de la classe  
	 * */
	public InExistTupleException()
	{
			super("le tupe n\\'exite pas !");

	}

}
