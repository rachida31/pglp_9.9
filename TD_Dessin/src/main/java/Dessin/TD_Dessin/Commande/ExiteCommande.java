package Dessin.TD_Dessin.Commande;
/**
*classe CreationCommande pour la creation soit 'un cercle ou carre 
*,rectangle,triangle ou un groupe de forme dans la base de donnée..
* @author rachida ouchene.
*/
public class ExiteCommande implements Commande {
	/**
	 * constrecteur de la classe 
	 * */
	public ExiteCommande()
	{
		
	}
	/**
	 * Méthode execute qui va finir l'execution de programme.
	 * 
	 * */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
    	System.out.println(" vous avez quiter au revoir!");
    	System.exit(0);
	}

}
