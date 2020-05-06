package Dessin.TD_Dessin;

public class Coordonnee {
	
	private int X;
	private int Y;
	public Coordonnee(int X,int Y) 
	{
		this.X=X;
		this.Y=Y;
	}
	public int getX()
	{
		return this.X;
	}
	public int getY()
	{
		return this.Y;
	}
	public void move(int X,int Y)
	{
		this.X+=X;
		this.Y+=Y;
	}
}
