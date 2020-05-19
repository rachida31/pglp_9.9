package Dessin.TD_Dessin.forme;

import java.util.ArrayList;

import Exeption.ElementExistException;
import Exeption.InExistArgumentException;

/**
 * implemantation de la classe Form_Groupe pour definir la un goupe de forme
 * géométrique. * @author rachida ouchene.
 */
public class Form_Groupe extends Formes_Graphiques {
	/**
	 * la liste des défferentes formes graphiques.
	 */
	private final ArrayList<Formes_Graphiques> forme;

	/**
	 * Constructor Form_Groupe qu'inisialise le nom de groupe en passent \n le name
	 * a la super classe.
	 * 
	 * @param name : le nom de carre.
	 **/
	public Form_Groupe(final String name) {
		super(name);
		this.forme = new ArrayList<Formes_Graphiques>();
	}

	/**
	 * Constructor Form_Groupe qu'inisialise la liste des forme \n
	 * 
	 * @param forme par une liste passer en parametre \n le nom de groupe en passent
	 *              le name a la super classe.
	 * @param name  : le nom de carre.
	 * @param forme : la liste des formes graphiques.
	 */
	public Form_Groupe(final ArrayList<Formes_Graphiques> forme, String name) {
		super(name);
		this.forme = forme;
	}

	/**
	 * Retourne la liste des formes graphiques.
	 * 
	 * @return forme.
	 * @see forme
	 */
	public ArrayList<Formes_Graphiques> getForme() {
		return this.forme;
	}

	/**
	 * Affiche les informations de groupe de forme.
	 */
	public void print() {
		System.out.println("Le nom du groupe est : " + this.getName());
		for (Formes_Graphiques formei : this.forme) {
			formei.print();
		}
	}

	/**
	 * Ajoute une forme a la liste des formes @see forme et elle leve \n une
	 * exception si la forme elle existe déjà dans la liste.
	 * 
	 * @throws ElementExistException
	 * @param forme
	 */
	public void add(final Formes_Graphiques forme) throws ElementExistException {
		if (!this.forme.contains(forme)) {
			this.forme.add(forme);
		} else {
			throw new ElementExistException();
		}
	}

	/**
	 * Retourn la taille de la liste es formes @see forme .
	 * 
	 * @return int
	 */
	public int size() {
		return this.forme.size();
	}

	/**
	 * elle permet de supprimer une forme de la liste.
	 * 
	 * @throws InExistArgumentException .
	 * @param formei
	 */
	public void remove(final Formes_Graphiques formei) throws InExistArgumentException {
		if (this.forme.contains(formei)) {
			this.forme.remove(formei);
		} else {
			throw new InExistArgumentException();
		}
	}

	/**
	 * Deplace le Groupe de forme en rajoutant le deplacement passer en \n parmetre
	 * pour les Coordonnée de chaque forme de ce groupe \n grace a l'appelle de la
	 * fonction move de la classe Coordonnee.
	 * 
	 * @param x
	 * @param y
	 */
	@Override
	public void move(final int x, final int y) {
		for (Formes_Graphiques formei : this.forme) {
			formei.move(x, y);
		}
	}
}
