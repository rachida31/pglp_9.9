package Dessin.TD_Dessin;


public class DaoFactory {
	public static DAO<Carre> getCarreDAO(){ 
		return new CarreDAO();
	}
	
	 public static DAO<Cercle> getCercleDAO() {
	        return new CercleDAO();
	        
	    }
	 public static DAO<Rectangle> getRectangleDAO() {
	        return new RectangleDAO();
	        
	    }
	 public static DAO<Triangle> getTriangleDAO() {
	        return new TriangleDAO();
	        
	    }
	
}
