package Dessin.TD_Dessin.Commande;

import Exeption.ElementExistException;

/**
 * Interface fonctionnelle Commande.
 * @exception ElementExistException .
 * @exception Exception.
 * @author ouchene rachida.
 */
@FunctionalInterface
public interface Commande {
/**
* La finction execute pour les commandes.
* @throws ElementExistException si un element n'existe pas
* dans la liste des forme.
* @throws Exception  en cas de problème.
* */
void execute() throws ElementExistException, Exception;
}
