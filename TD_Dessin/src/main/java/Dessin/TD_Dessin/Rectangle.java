package Dessin.TD_Dessin;

public class Rectangle extends Formes_Graphiques  {
	private Coordonnee Coor;
	private int longueur;
	private int largeur;
	public Rectangle(String name,Coordonnee Coor,int longueur,int largeur) {
		super(name);
		this.Coor=new Coordonnee(Coor.getX(),Coor.getY());
		this.longueur=longueur;
		this.largeur=largeur;
	}
	public Coordonnee getCoor()
	{
		return this.Coor;
	}
	public int getLongueur()
	{
		return this.longueur;
	}
	public int getLargeur()
	{
		return this.largeur;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
