package Dessin.TD_Dessin.DAO;

/**
 * implemantation de l'interface {@link DAO} pour implimenter les quatres \n
 * Operations CRUD.
 * @param <T> le type de la forme.
 * @author rachida ouchene.
 */
public interface DAO<T> {
	/**
	 * @param t : la forme a créer.
	 * @throws Exception : une exception s'il y a une erreur.
	 */
	public void create(T t) throws Exception;

	/**
	 * @param t : la forme a modiffier.
	 * @throws Exception : une exception s'il y a une erreur.
	 */
	public void update(T t) throws Exception;

	/**
	 * @param t : la forme a supprimer.
	 * @throws Exception : une exception s'il y a une erreur.
	 */
	public void delete(T t) throws Exception;

	/**
	 * @param nom :le nom de la forme rechercher.
	 * @throws Exception : une exception s'il y a une erreur.
	 * @return T
	 */
	public T read(String nom) throws Exception;
}
