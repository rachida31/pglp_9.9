package Dessin.TD_Dessin;

public class Cercle extends Formes_Graphiques {
	private Coordonnee centre;
	private int rayon;
	public Cercle(String name,Coordonnee centre ,int rayon) {
		super(name);
		this.centre=new Coordonnee(centre.getX(),centre.getY()) ;
		this.rayon=rayon;
	}

	public Coordonnee getCentre()
	{
		return this.centre;
	}
	public int getRayon()
	{
		return this.rayon;
	}
	@Override
	public void print() 
	{
		String cercle =  this.name + " : Cercle ((Rayon:" + rayon +") "
				 + ("(x:"+centre.getX() + "," + "y:"+centre.getY())+"))";
		System.out.println(cercle);
	}

	@Override
	public void move(int x,int y)
	{
		this.centre.move(x, y);
		
	}

}
