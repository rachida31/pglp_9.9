package Dessin.TD_Dessin.DAO;
/**
 *implemantation de l'interface  {@link DAO} pour implimenter les quatres 
 *Operations CRUD
 * @author rachida ouchene.
 * 
 */
public interface DAO<T> {

	
	   public void create(T t)throws Exception;

	   public void update(T t)throws Exception;

	   public void delete(T t)throws Exception;
		
	   public T read(String s)throws Exception;
}
