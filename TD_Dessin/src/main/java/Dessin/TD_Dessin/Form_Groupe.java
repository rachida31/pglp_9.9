package Dessin.TD_Dessin;
import java.util.ArrayList;

import Exeption.ElementExistException;
import Exeption.InExistArgumentException;

public class Form_Groupe extends Formes_Graphiques {


		private final ArrayList<Formes_Graphiques> forme ;
			
			public Form_Groupe(String name)
			{
				super(name);
			this.forme=new ArrayList<Formes_Graphiques>();
			
			}
		
		
			public Form_Groupe(ArrayList<Formes_Graphiques> forme,String name)
			{
				super(name);
				this.forme=forme;
			
			}
	
			public  ArrayList<Formes_Graphiques>getForme()
			{
			return this.forme;	
			//return ( ArrayList<Formes_Graphiques>) Collections.unmodifiableList(this.forme);

			}
		
			public void print()
			{
				System.out.println("Le nom du groupe est : "+this.getName());

				  for (Formes_Graphiques formei :this.forme) {
				        formei.print();  
				    }
			}


		public void add(Formes_Graphiques forme) throws ElementExistException 
		{
			if(!this.forme.contains(forme))
			{
			this.forme.add(forme);
			}
			else 
			{
				throw new ElementExistException();
			}
		}
 
	public int size()
	{
		return this.forme.size();
	}
	public void remove(Formes_Graphiques formei) throws InExistArgumentException{
			if(this.forme.contains(formei)) {
				System.out.println(this.forme.contains(formei));
			this.forme.remove(formei);}
			else 
				{
				System.out.println(this.forme.contains(formei));

				throw new InExistArgumentException();
		}
		}

	@Override
	public void move(int x, int y) {

		for (Formes_Graphiques formei :this.forme) 
		{
	        formei.move(x, y);  
	    }
	}
	

}
