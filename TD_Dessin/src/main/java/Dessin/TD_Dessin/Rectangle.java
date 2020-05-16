package Dessin.TD_Dessin;
/**
 *implemantation de la classe Rectangle 
 *pour definir un la forme géométrique Rectangle.
 * @author rachida ouchene.
 * 
 */
public class Rectangle extends Formes_Graphiques  {
	/**
     *la possition de Rectangle
     * de type Coordonnee (int ,int).
     * @see Rectangle#Rectangle().
     * @see Rectangle#getCoor().
     */
	private Coordonnee Coor;
	/**
     *la longeur  de Rectangle 
     * qu'est de type int.
     * @see Rectangle#Rectangle().
     * @see Rectangle#getLongeur().
     */
	private int longueur;
	/**
     *la largeur de Rectangle 
     * qu'est de type int.
     * @see Rectangle#Rectangle().
     * @see Rectangle#getLargeur().
     */
	private int largeur;
	/**
	* Constructor Rectangle qu'inisialise @see Coor par ces coordonnée 
	* et @see longeur et @see lagreur de Rectangle ainsi passe le name a la super classe.
	 * @param name :
	 * le nom de Rectangle.
	 * @param Coor: les coordonnée de Rectangle.
	 * @param longeur: longeur de Rectangle.
	 * @param largeur: largeur de Rectangle.
	 * */
	public Rectangle(String name,Coordonnee Coor,int longueur,int largeur) {
		super(name);
		this.Coor=new Coordonnee(Coor.getX(),Coor.getY());
		this.longueur=longueur;
		this.largeur=largeur;
	}
	/**
     * Retourne La coordonnée de Rectangle.
     * @return Coor.
     * @see Coor
     */
	public Coordonnee getCoor()
	{
		return this.Coor;
	}
	/**
     * Retourne la longeur de Rectangle.
     * @return longeur.
     * @see longeur
     */
	public int getLongueur()
	{
		return this.longueur;
	}
	/**
     * Retourne la largeur de Rectangle.
     * @return largeur.
     * @see largeur
     */
	public int getLargeur()
	{
		return this.largeur;
	}
	/**
     * Affiche les informations de Rectangle.
     */
	@Override
	public void print() {
		String rectangle =  this.name + " : Rectangle ((longueur:" + longueur +") "
				 + ",(largeur:" + largeur +") "
				 + (",(x:"+Coor.getX() + "," + "y:"+Coor.getY())+"))";
		System.out.println(rectangle);
	}
	/**
     * Deplace le Rectangle en rajoutant le deplacement passer en 
     * parmetre pour les Coordonnée de ce Rectangle 
     * grace a l'appelle de la fonction move de la classe Coordonnee.
     */
	@Override
	public void move(int x,int y) {
		this.Coor.move(x, y);
	}

}
