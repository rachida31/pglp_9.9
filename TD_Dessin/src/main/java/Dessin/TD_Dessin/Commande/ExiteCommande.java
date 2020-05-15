package Dessin.TD_Dessin.Commande;

public class ExiteCommande implements Commande {

	public ExiteCommande()
	{
		
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
    	System.out.println("exit commande  ");

		System.exit(0);
	}

}
