package Dessin.TD_Dessin.Commande;

import Exeption.ElementExistException;

/**
 * Interface fonctionnelle Commande
 * @author ouchene rachida
 * 
 */
@FunctionalInterface
public interface Commande {

	public void execute() throws ElementExistException, Exception;
	
}
