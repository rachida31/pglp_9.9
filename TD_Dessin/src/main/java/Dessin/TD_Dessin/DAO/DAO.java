package Dessin.TD_Dessin.DAO;

import java.beans.Statement;

public interface DAO<T> {

	
	   public void create(T t)throws Exception;

	   public void update(T t)throws Exception;

	   public void delete(T t)throws Exception;
		
	   public T read(String s)throws Exception;
}
