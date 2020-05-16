package Dessin.TD_Dessin;
import java.util.ArrayList;

import Exeption.ElementExistException;
import Exeption.InExistArgumentException;
/**
 *implemantation de la classe Form_Groupe 
 *pour definir  la un goupe de forme géométrique.
 * @author rachida ouchene.
 * 
 */
public class Form_Groupe extends Formes_Graphiques {

		/** 
		 *la liste des défferentes formes graphiques. 
		 */
		private final ArrayList<Formes_Graphiques> forme ;
		/**
		* Constructor Form_Groupe qu'inisialise le nom de groupe en passent le name a la super classe.
		 * @param name :
		 * le nom de carre.
		 * 
		 * */
			public Form_Groupe(String name)
			{
				super(name);
			this.forme=new ArrayList<Formes_Graphiques>();
			
			}
		
			/**
			* Constructor Form_Groupe qu'inisialise la liste des forme @param forme par une liste passer en parametre 
			* le nom de groupe en passent le name a la super classe.
			 * @param name :
			 * le nom de carre.
			 * @param forme : la liste des formes graphiques.
			 * */
			public Form_Groupe(ArrayList<Formes_Graphiques> forme,String name)
			{
				super(name);
				this.forme=forme;
			
			}
			/**
		     * Retourne la liste des formes graphiques.
		     * @return forme.
		     * @see forme
		     */
			public  ArrayList<Formes_Graphiques>getForme()
			{
			return this.forme;	
			//return ( ArrayList<Formes_Graphiques>) Collections.unmodifiableList(this.forme);

			}
			/**
		     * Affiche les informations de groupe de forme.
		     */
			public void print()
			{
				System.out.println("Le nom du groupe est : "+this.getName());

				  for (Formes_Graphiques formei :this.forme) {
				        formei.print();  
				    }
			}

			/**
			 * Ajoute une forme a la liste des formes @see forme et elle leve 
			 * une exception si la forme elle existe déjà dans la liste.
			 * @throws ElementExistException
			 * */
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
 /**
  * Retourn la taille de la liste es formes @see forme .
  * */
	public int size()
	{
		return this.forme.size();
	}
	/**
	 * elle permet de supprimer une forme de la liste.
	 * @throws InExistArgumentException
	 * */
	public void remove(Formes_Graphiques formei) throws InExistArgumentException{
			if(this.forme.contains(formei)) {
			this.forme.remove(formei);}
			else 
				{

				throw new InExistArgumentException();
		}
		}
	/**
     * Deplace le Groupe de forme en rajoutant le deplacement passer en 
     * parmetre pour les Coordonnée de chaque forme de ce groupe 
     * grace a l'appelle de la fonction move de la classe Coordonnee.
     */
	@Override
	public void move(int x, int y) {

		for (Formes_Graphiques formei :this.forme) 
		{
	        formei.move(x, y);  
	    }
	}
	

}
