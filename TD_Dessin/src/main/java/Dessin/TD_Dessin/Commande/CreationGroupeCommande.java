package Dessin.TD_Dessin.Commande;

import java.util.ArrayList;

import Dessin.TD_Dessin.Form_Groupe;
import Dessin.TD_Dessin.DAO.DaoFactory;
import Dessin.TD_Dessin.DAO.Form_GroupeDAO;
import Exeption.ElementExistException;

public class CreationGroupeCommande implements Commande {
	ArrayList<String> l ;
	DaoFactory daof;
	public CreationGroupeCommande(ArrayList<String> l)
	{
		this.l=l;
		this.daof=new DaoFactory(); 
	}

	@Override
	public void execute() throws ElementExistException, Exception {
    	System.out.println("creation commande groupe ");
;
             Form_GroupeDAO cdao=(Form_GroupeDAO) DaoFactory.getForm_GroupeDAO();
            Form_Groupe groupe=new Form_Groupe((String)l.get(0));
            //groupe.print();
            		
            	
            		int i=2;
            		while(i<l.size())
            		{

  		    		  if(("a".regionMatches(true, 0, l.get(i), 0, 1)))
  		  	        {
  		    			groupe.add(DaoFactory.getCarreDAO().read(l.get(i)));
  		  	        }
  		  	          else if(("c".regionMatches(true, 0, l.get(i), 0, 1)))
  		  		        {
  		  	        	  System.out.println("cccccccccccccccccccccccccc cercle ccccccc");
  		  	        	groupe.add(DaoFactory.getCercleDAO().read(l.get(i)));

  		  		        }   else if(("t".regionMatches(true, 0, l.get(i), 0, 1)))
  		  		        {
  		  		        groupe.add(DaoFactory.getTriangleDAO().read(l.get(i)));

  		  		        }   else if(("r".regionMatches(true, 0, l.get(i), 0, 1)))
  		  		        {
  		  		        groupe.add(DaoFactory.getRectangleDAO().read(l.get(i)));
  		  		        }
            			i++;
           		}
					cdao.create(groupe);
            		groupe.print();
        		System.out.println("Cireation reussite!");


        	
        	
       			
        }
		
	

}
