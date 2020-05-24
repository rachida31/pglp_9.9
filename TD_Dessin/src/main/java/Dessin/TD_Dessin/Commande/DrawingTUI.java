package Dessin.TD_Dessin.Commande;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import Dessin.TD_Dessin.forme.Carre;
import Dessin.TD_Dessin.forme.Cercle;
import Dessin.TD_Dessin.forme.Coordonnee;
import Dessin.TD_Dessin.forme.Form_Groupe;
import Dessin.TD_Dessin.forme.Formes_Graphiques;
import Dessin.TD_Dessin.forme.Rectangle;
import Dessin.TD_Dessin.forme.Triangle;
import Dessin.TD_Dessin.DAO.CarreDAO;
import Dessin.TD_Dessin.DAO.CercleDAO;
import Dessin.TD_Dessin.DAO.DaoFactory;
import Dessin.TD_Dessin.DAO.Form_GroupeDAO;
import Dessin.TD_Dessin.DAO.RectangleDAO;
import Dessin.TD_Dessin.DAO.TriangleDAO;

/**
 * classe DrawingTUI l'interface de l'utilisateur.
 * @author rachida ouchene.
 */
public class DrawingTUI {
	/**
	 * forme la forme que nous allons creer pour vérifier si elle correcte.
	 * @see DrawingTUI#DrawingTUI( )
	 */
	private Formes_Graphiques forme;
	/**
	 * formec la forme sur la quelle nous allons appliquer une commande.
	 * @see DrawingTUI#DrawingTUI( )
	 */
	private Formes_Graphiques formec;
	/**
	 * DaoFactory de type DaoFactory.
	 * @see DrawingTUI#DrawingTUI( )
	 */
	private DaoFactory daof;
	/**
	 * la liste des forme realiser par l'utilisateure.
	 */
	private ArrayList<Formes_Graphiques> listeforme;

	/**
	 * constructeur DrawingTUI. qui initialise
	 * this.forme a null this. firmecree
	 * a null et instancier l'objet daof de type DaoFactory.
	 * @see DrawingTUI#forme .
	 * @see DrawingTUI#formec .
	 * @see DrawingTUI#daof .
	 * @throws SQLException
	 **/
	public DrawingTUI() throws SQLException {
		this.forme = null;
		this.formec = null;
		this.daof = new DaoFactory();
		this.listeforme = new ArrayList<Formes_Graphiques>();
	}

	/**
	 * Elle verifie que la chaine passe par l'utilisateur
	 * pour cree un groupe de
	 * forme est sans erreur aussi que ce groupe n'existe
	 * pas dans la base aussi
	 * que les formes de ce groupe existe deja,si
	 * tout est bon on peut creer la
	 * forme corresspond a cette chaine pour
	 * appliquer sur elle la commande et la
	 * c'est la creation.
	 * @throws Exception .
	 * @param l .
	 **/
	public final void dessinGroupe(final ArrayList
			<String> l) throws Exception {
		Formes_Graphiques f = null;
		if (l.get(1).equalsIgnoreCase("groupe")) {
			if (l.size() <= 2) {
				System.out.println(" Erreur le nombre"
						+ " d\'élement pour créer "
						+ "le groupe est insuffisant!");
				forme = null;
			} else if (!("g".regionMatches(true, 0, l.
					get(0), 0, 1))) {
				System.out.println(
						" Erreur le nom de votre "
						+ "groupe doit commencer par "
						+ ": \" g \" et "
						+ "suiver par un "
						+ "chiffre !");
				forme = null;
			} else {
				int i = 2;
				while (i < l.size()) {
					if (("a".regionMatches(true, 0, l.
							get(i), 0, 1))) {
						f = daof.getCarreDAO().
							read(l.get(i));
					} else if (("c".
							regionMatches(true, 0, l.
							get(i), 0, 1))) {
						f = daof.getCercleDAO().
							read(l.get(i));

					} else if (("t".
							regionMatches(true, 0, l.
							get(i), 0, 1))) {
						f = daof.getTriangleDAO().
							read(l.get(i));
					} else if (("r".
							regionMatches(true, 0, l.
							get(i), 0, 1))) {
						f = daof.getRectangleDAO().
							read(l.get(i));
					}
					if (f == null) {
						System.out.println("Erreur la "
							+ "forme \" " + l.get(i)
							+ "\" n'existe pas vous douvez "
							+ " mettre une "
							+ "forme existante "
							+ "merci!");
						forme = new Cercle("c0", new
								Coordonnee(0, 0), 0);
						break;
					}
					i++;
				}
				if (f != null) {
					forme = daof.getForm_GroupeDAO().
							read(l.get(0));
					if (forme != null) {
						System.out.println(" Erreur ce nom de"
								+ " groupe "
								+ "existe déja merci de le "
								+ "modifier!");
					} else {
						formec = new Form_Groupe((String) l.
								get(0));
						int j = 2;
						while (j < l.size()) {
							if (("a".regionMatches(true, 0, l.
								get(j), 0, 1))) {
								((Form_Groupe) formec).add(
								daof.getCarreDAO().
								read(l.get(j)));
							} else if (("c".regionMatches(true, 0, l
								.get(j), 0, 1))) {
								((Form_Groupe) formec).add(
								daof.getCercleDAO().
								read(l.get(j)));
							} else if (("t".
								regionMatches(true, 0, l.
								get(j),0, 1))) {
								((Form_Groupe) formec).
								add(daof.getTriangleDAO().
								read(l.get(j)));
							} else if (("r".
								regionMatches(true, 0,
								l.get(j), 0, 1))) {
								((Form_Groupe) formec).
								add(
								daof.getRectangleDAO().
								read(l.get(j)));
							}
							j++;
						}
					}
				}
			}
		}
	}

	/**
	 * elle verifier si la chaine passer 
	 * en parametre c'est un entier ou non.
	 * @param cc
	 * @return testerreurfrappe : un boolean qui dit si.
	 * @param cc est un entier ou non.
	 */
	private boolean testErreur(final String cc) {
		char[] s = cc.toCharArray();
		boolean testerreurfrappe = true;
		for (int i = 0; i < s.length; i++) {
			if (!Character.isDigit(s[i])) {
				testerreurfrappe = false;
			}
		}
		return testerreurfrappe;
	}

	/**
	 * Elle verifie que la chaine passe par
	 * l'utilisateur pour cree une forme
	 * est sans erreur aussi que cette forme
	 * n'existe pas dans la base si tout
	 * est bon on peut creer la forme
	 * corresspond acette chaine pour appliquer
	 * sur elle la commande et la c'est la creation.
	 * @param l .
	 * @throws Exception .
	 */
	public final void dessinForme(final ArrayList
			<String> l) throws Exception {
		forme = new Cercle("c0", new Coordonnee(0, 0), 0);
		if (l.get(1).equalsIgnoreCase("cercle")) {
			if (l.size() != 5) {
				System.out.println(" Erreur le nombre "
						+ "d\'élement pour dessiner"
						+ " votre cercle est "
						+ "insuffisant !");
			} else if (!("c".
					regionMatches(true, 0, l.
					get(0), 0, 1))) {
				System.out.println(
						" Erreur  le nom de  cercle "
						+ "doit commancer par: \" c \" "
						+ "suiver "
						+ "par un chiffre !");
			} else if (!testErreur(l.
					get(2)) && !testErreur(l.
					get(3))) {
				System.out.println(" Erreur  les "
						+ "cooredonnee "
						+ "de centre pour le cercle doit "
						+ "être  des entiers!");
			} else if (!testErreur(l.get(4))) {
				System.out.println(" Erreur le rayon de "
						+ "cercle "
						+ "doit être un entier!");
			} else {
				forme = daof.getCercleDAO().read(l.get(0));
				if (forme != null) {
					System.out.println("Erreur ce nom de "
						+ "cercle existe déja!");
				} else {
					formec = new Cercle((String) l.get(0),
							new Coordonnee(Integer.
							parseInt((String) l.
							get(2)),
							Integer.
							parseInt((String) l.
							get(3))),
							Integer.
							parseInt((String) l.
							get(4)));
				}
			}
		} else if (l.get(1).
				equalsIgnoreCase("Carre")) {
			if (l.size() != 5) {
				System.out.println("Erreur le nombre "
						+ "d\'élement pour "
						+ "dessiner le carre est"
						+ " insufisant!");
			} else if (!("a".regionMatches(true, 0, l.
					get(0), 0, 1))) {
				System.out.println(
						" Erreur le nom pour le carre"
						+ " doit commencer par :"
						+ " \" a \" "
						+ "puis suiver par "
						+ "un chiffre !");
			} else if (!testErreur(l.
					get(2)) || !testErreur(l.
					get(3))) {
				System.out.println(" Erreur"
						+ " les cooredonnee"
						+ " de "
						+ "carre doit etre "
						+ "des entiers!");
			} else if (!testErreur(l.get(4))) {
				System.out.println("Erreur"
						+ " le rayon de "
						+ "carre doit "
						+ "etre un "
						+ "entier!");
			} else {
				forme = daof.getCarreDAO().read(l.get(0));
				if (forme != null) {
					System.out.println("Erreur ce nom "
						+ "de carre existe déja "
						+ "merci de le"
						+ " modifier!");
				} else {
					System.out.println(" Carre ");
					formec = new Carre((String) l.
							get(0),
							new Coordonnee(Integer.
							parseInt((String) l.
							get(2)),
							Integer.
							parseInt((String) l.
							get(3))),
							Integer.
							parseInt((String) l.
							get(4)));
				}
			}
		} else if (l.get(1).equalsIgnoreCase("Triangle")) {
			if (l.size() != 8) {
				System.out
						.println(" Erreur le bon "
						+ "nombre d\'élement"
						+ " pour"
						+ " dessiner votre "
						+ "triangle est "
						+ "insuffisant!");
			} else if (!("t".
					regionMatches(true, 0, l.
					get(0), 0, 1))) {
				System.out.println(
						" Erreur  le nom de  "
						+ "triangele doit "
						+ "commencer "
						+ "par: \" t \" "
						+ "puis suiver par "
						+ "un chiffre !");
			} else if (!testErreur(l.
					    get(2)) || !testErreur(l.
					    get(3))
						|| !testErreur(l.
						get(4)) || !testErreur(l.
						get(5))
						|| !testErreur(l.
						get(6)) || !testErreur(l.
						get(7))) {
				System.out.println(
						" Erreur  les cooredonnee "
						+ "des trois poinds "
						+ "de triangle "
						+ "doivent etre "
						+ "des entiers!");
			} else {
				forme = daof.getTriangleDAO().read(l.get(0));
				if (forme != null) {
					System.out.println("Erreur ce "
							+ "nom pour le triangle"
							+ " existe "
							+ "déja merci de le"
							+ " modifier!");
				} else {
					formec = new Triangle((String) l.
							get(0),
							new Coordonnee(Integer.
							parseInt((String) l.
							get(2)),
							Integer.
							parseInt((String) l.
							get(3))),
							new Coordonnee(Integer.
							parseInt((String) l.
							get(4)),
							Integer.
							parseInt((String) l.
							get(5))),
							new Coordonnee(Integer.
							parseInt((String) l.
							get(6)),
							Integer.
							parseInt((String) l.
							get(7))));
					formec.print();
				}
			}
		} else if (l.get(1).equalsIgnoreCase("Rectangle")) {
			if (l.size() != 6) {
				System.out.println(
						" Erreur le bon nombre "
						+ "d\'element pour "
						+ "dessiner le "
						+ "rectangle est "
						+ "insuffisant!");
			} else if (!("r".
					regionMatches(true, 0, l.
					get(0), 0, 1))) {
				System.out.println(" Erreur le nom"
						+ " de rectangle "
						+ "doit cpmmencer par "
						+ ": \" r \" "
						+ "puis suiver par un "
						+ "chiffre !");
			} else if (!testErreur(l.
					get(2)) || !testErreur(l.
					get(3))) {
				System.out.println(" Erreur les cooredonnee "
						+ "de rectangle doivent "
						+ "etre des entiers!");
			} else if (!testErreur(l.
					get(4)) || !testErreur(l.
					get(5))) {
				System.out.println(" Erreur  la "
						+ "largeur et la hauteur "
						+ "de rectangle doivent "
						+ "etre des entiers!");
			} else {
				forme = daof.getRectangleDAO().read(l.get(0));
				if (forme != null) {
					System.out.println("Erreur ce nom pour "
							+  "le rectangle"
							+ " existe déja merci "
							+ "de le "
							+ "modifier!");
				} else {
					formec = new Rectangle((String) l.
							 get(0),
							 new Coordonnee(Integer.
							 parseInt((String) l.
							 get(2)),
							 Integer.parseInt((String) l.
							 get(3))),
							 Integer.parseInt((String) l.
							 get(4)),
							 Integer.parseInt((String) l.
							 get(4)));
				}
			}
		} else if (l.get(1).equalsIgnoreCase("groupe")) {
			dessinGroupe(l);
		}
	}

	/**
	 * Elle verifie que la chaine passe par l'utilisateur pour deplacer une
	 * forme est sans erreur aussi que
	 * cette forme existe dans la base si
	 * tout
	 * est bon on recupere de la base
	 * cette forme corresspond a la
	 * chaine pour
	 * appliquer sur elle la commande
	 * et la c'est le deplacement(move).
	 * @param l .
	 * @throws Exception .
	 */
	public final void deplacerForme(final ArrayList<String> l) throws
		Exception {
		System.out.println("deplacer forme ");
		if (l.size() != 4) {
			System.out.println(" Erreur  le bon "
					+ "nombre d\'element de"
					+ " cette commnade est insuffisant pour"
					+ " effectuer le deplacement !");
			forme = null;
		} else if (("a".regionMatches(true, 0, l.get(1), 0, 1))) {
			if (!testErreur(l.
					get(2)) && !testErreur(l.
					get(3))) {
				System.out
						.println(" Erreur les "
								+ "cooredonnee "
								+ "pour "
								+ "le deplacement"
								+ " "
								+ "de carre "
								+ "doivent"
								+ "etre des "
								+ "entiers!");
				forme = null;
			} else {
				forme = daof.getCarreDAO().read(l.get(1));
				if (forme == null) {
					System.out.println("Erreur la"
							+ " forme "
							+ "n'existe pas pour "
							+ "etre "
							+ "déplacer!");
				}
			}
		} else if (("c".regionMatches(true, 0, l.get(1), 0, 1))) {
			if (!testErreur(l.get(2)) && !testErreur(l.get(3))) {
				System.out.println(
						" Erreur les cooredonnee "
						+ "pour le "
						+ "deplacement de "
						+ "cercle doivent "
						+ "etre des entiers!");
				forme = null;
			} else {
				forme = daof.getCercleDAO().read(l.get(1));
				if (forme == null) {
					System.out.println("Erreur la "
							+ "forme n'existe pas "
							+ "pour etre"
							+ " déplacer!");
				}
			}
		} else if (("t".regionMatches(true, 0, l.get(1), 0, 1))) {
			if (!testErreur(l.get(2)) && !testErreur(l.get(3))) {
				System.out.println(
						" Erreur les cooredonnee "
						+ "pour le deplacement de "
						+ "triangle doivent "
						+ "etre des entiers!");
				forme = null;
			} else {
				forme = daof.getTriangleDAO().read(l.get(1));
			}
			if (forme == null) {
				System.out.println("Erreur la forme "
						+ "n'existe pas pour etre "
						+ "déplacer!");
			}
		} else if (("r".regionMatches(true, 0, l.get(1), 0, 1))) {
			forme = daof.getRectangleDAO().read(l.get(1));
			if (forme == null) {
				System.out.println("Erreur la forme "
						+ "n'existe pas pour "
						+ "etre déplacer!");
			}
		} else if (("g".regionMatches(true, 0, l.
				get(1), 0, 1))) {
			if (!testErreur(l.
				get(2)) && !testErreur(l.
				get(3))) {
				System.out.println(
						" Erreur les "
						+ "cooredonnee pour le "
						+ "deplacement de "
						+ "groupe doivent etre "
						+ "des entiers!");
				forme = null;
			} else {
				forme = daof.getForm_GroupeDAO().read(l.get(1));
				if (forme == null) {
					System.out.println("Erreur la "
							+ "forme n'existe "
							+ "pas pour etre"
							+ " déplacer!");
				}
			}
		} else {
			System.out.println("Erreur ce "
					+ "nom " + l.get(1)
				+ " ne correspond a aucune forme!");
			}
	}

	/**
	 * Elle verifie que la chaine passe par l'utilisateur pour afficher une
	 * forme est sans erreur aussi que cette forme existe dans la base si
	 * tout est bon on peut recupere la
	 * forme corresspond a cette chaine pour
	 * appliquer sur elle la commande et la c'est la recherche d'une forme.
	 * @param l .
	 * @throws Exception .
	 */
	public final void findForme(final
			ArrayList<String> l) throws
			Exception {
		if (l.size() != 2) {
			System.out.println(" Erreur le  nombre d\'element "
					+ "pour afficher est insuffisant!");
			forme = null;
		} else if (("a".regionMatches(true, 0, l.get(1), 0, 1))) {
			forme = daof.getCarreDAO().read(l.get(1));
		} else if (("c".regionMatches(true, 0, l.get(1), 0, 1))) {
			forme = daof.getCercleDAO().read(l.get(1));
		} else if (("t".regionMatches(true, 0, l.get(1), 0, 1))) {
			forme = daof.getTriangleDAO().read(l.get(1));
		} else if (("r".regionMatches(true, 0, l.get(1), 0, 1))) {
			forme = daof.getRectangleDAO().read(l.get(1));
		} else if (("g".regionMatches(true, 0, l.get(1), 0, 1))) {
			forme = daof.getForm_GroupeDAO().read(l.get(1));
		}
		if (forme == null) {
			System.out.println(" Erreur vous douvez d'abord créer "
					+ "la forme pour la recherecher! ");
		}
	}

	/**
	 * Elle verifie que la chaine passe par
	 * l'utilisateur pour cree une forme
	 * est sans erreur aussi que cette
	 * forme existe dans la base si tout est bon
	 * on peut recupere la forme corresspond
	 * a cette chaine pour appliquer sur
	 * elle la commande et la c'est la supprission.
	 * @param l .
	 * @exception Exception .
	 */
	public final void deleteForme(final
			ArrayList<String> l) throws
			Exception {
		System.out.println("effacer forme ");
		int i = 1;
		if (l.size() != 2) {
			System.out.println("Erreur le  nombre d\'element de "
					+ "cette  commande "
					+ "pour supprimer est "
					+ "insuffisant!");
			forme = null;
		} else if (("a".regionMatches(true, 0, l.get(1), 0, 1))) {
			forme = daof.getCarreDAO().read(l.get(1));
		} else if (("c".regionMatches(true, 0, l.get(1), 0, 1))) {
			forme = daof.getCercleDAO().read(l.get(1));
		} else if (("t".regionMatches(true, 0, l.get(1), 0, 1))) {
			forme = daof.getTriangleDAO().read(l.get(1));
		} else if (("r".regionMatches(true, 0, l.get(1), 0, 1))) {
			forme = daof.getRectangleDAO().read(l.get(1));
		} else if (("g".regionMatches(true, 0, l.get(1), 0, 1))) {
			forme = daof.getForm_GroupeDAO().read(l.get(1));
		}
		if(forme != null) {
		for (Formes_Graphiques formei : this.listeforme) {
			if (formei.getName().
					equalsIgnoreCase(forme.getName())) {
				this.listeforme.remove(formei);
				i = 0;
				break;
			}
		}
		if (i != 0) {
			System.out.println(" Erreur "
					+ "vous douvez d'abord"
					+ " créer cette"
					+ " forme pour la supprimer!");
			forme = null;
		} }
		else {
			System.out.println(" Erreur "
					+ "vous douvez d'abord"
					+ " créer cette"
					+ " forme pour la supprimer!");
		}
	}

	/**
	 * separe la chaine entree par l'utilisateur en token.
	 * @param str .
	 * @return l
	 */
	public final ArrayList<String> liste(final String str) {
		ArrayList<String> l = new ArrayList<String>();
		StringTokenizer multiTokenizer = new
				StringTokenizer(str, "=(), ");
		while (multiTokenizer.hasMoreTokens()) {
			String a = multiTokenizer.nextToken();
			l.add(a);
		}
		return l;
	}

	/**
	 * Recuperation de la commande demander par l'utlisateur.
	 * @param commande : La chaine commande rentrée par l'utilisateur.
	 * @return command : La command a executer .
	 * @throws Exception .
	 */
	public final Commande nextCommand(final
			String commande) throws Exception {
		ArrayList<String> l;
		l = liste(commande);
		if (l.size() > 1) {
			if (!l.get(1).
					equalsIgnoreCase("cercle")
					&& !l.get(1).
					equalsIgnoreCase("carre")
					&& !l.get(1).
					equalsIgnoreCase("triangle")
					&& !l.get(1).
					equalsIgnoreCase("rectangle")
					&& !l.get(1).
					equalsIgnoreCase("groupe")
					&& !l.get(0).
					equalsIgnoreCase("move")
					&& !l.get(0).
					equalsIgnoreCase("delete")
					&& !l.get(0).
					equalsIgnoreCase("find")) {
				System.out.println("Erreur"
						+ " la commande que vous avez "
						+ "entrer ne correspond a"
						+ " aucun commande!");
				return null;
			} else {
				if (l.get(1).equalsIgnoreCase("cercle")
						|| l.get(1).
						equalsIgnoreCase("carre")
						|| l.get(1).
						equalsIgnoreCase("triangle")
						|| l.get(1).
						equalsIgnoreCase("rectangle")
						|| l.get(1).
						equalsIgnoreCase("groupe")) {
					dessinForme(l);
					if (forme == null) {
						this.listeforme.add(formec);
						CreationCommande command = new
						CreationCommande(formec);
						return command;
					}
				} else if (l.get(0).equalsIgnoreCase("move")) {
					deplacerForme(l);
					if (forme != null) {
						MoveCommande command = new
						MoveCommande(forme,
						new Coordonnee(
						Integer.parseInt((String)
						l.get(2)),
						Integer.parseInt((String)
						l.get(3))));
						return command;
					} else {
						return null;
					}
				} else if (l.get(0).equalsIgnoreCase(""
						+ "delete")) {
					deleteForme(l);
					if (forme != null) {
						DeleteCommande command = new
						DeleteCommande(forme);
						return command;
					}
				} else if (l.get(0).equalsIgnoreCase("find")) {
					findForme(l);
					if (forme != null) {
						FindCommande command = new
						FindCommande(forme);
						return command;
					}
				}
			}
		} else if (l.size() == 1) {
			if (l.get(0).equalsIgnoreCase("exit")) {
				this.listeforme.clear();
				ExiteCommande command = new ExiteCommande();
				return command;
			} else {
				System.out.println("Erreur la commande "
						+ "que vous avez entrer "
						+ "ne correspond a aucun "
						+ "commande!");
				return null;
			}
		}
		return null;
	}

	/**
	 * affiche les information d'une des formes realiser par l'utilisateur.
	 */
	public final void afficheForme() {
		System.out.println("   Voila la liste des formes que "
					+ "vous avez réaliser :");
		Formes_Graphiques f = null;
		for (Formes_Graphiques formei : this.listeforme) {
			if (formei instanceof Cercle) {
				CercleDAO cdao = (CercleDAO) daof.
						getCercleDAO();
				f = cdao.read(formei.getName());
			} else if (formei instanceof Carre) {
				CarreDAO cdao = (CarreDAO) daof.getCarreDAO();
				f = cdao.read(formei.getName());
			} else if (formei instanceof Rectangle) {
				RectangleDAO cdao = (RectangleDAO) daof.
						getRectangleDAO();
				f = cdao.read(formei.getName());
			} else if (formei instanceof Triangle) {
				TriangleDAO cdao = (TriangleDAO) daof.
						getTriangleDAO();
				f = cdao.read(formei.getName());
			} else if (formei instanceof Form_Groupe) {
				Form_GroupeDAO cdao = (Form_GroupeDAO) daof.
						getForm_GroupeDAO();
				try {
					f = cdao.read(formei.getName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			f.print();
		}
	}
}
